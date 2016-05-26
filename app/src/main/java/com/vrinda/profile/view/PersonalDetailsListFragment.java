package com.vrinda.profile.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.vrinda.profile.Model.Constants;
import com.vrinda.profile.Model.DetailedResults;
import com.vrinda.profile.Model.PersonalDetails;
import com.vrinda.profile.R;
import com.vrinda.profile.adapter.DetailsAdapter;

import java.io.IOException;

/**
 * Created by vrinda venugopal on 5/24/2016.
 */
public class PersonalDetailsListFragment extends Fragment {

    private View mainView;
    private RecyclerView profile_list;
    private ProfileClickListener profileClickListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.mainView = inflater.inflate(R.layout.personal_details_list, container, false);
        profile_list = (RecyclerView) this.mainView.findViewById(R.id.list_view);
        return this.mainView;
    }

    @Override
    public void onResume() {
        super.onResume();
        requestData();
    }

    private void requestData() {
        new WebRequest().execute(Constants.URL);
    }

    private void bindRecyclerView(DetailedResults detailedResults) {
        DetailsAdapter detailsAdapter = new DetailsAdapter(detailedResults.getProfileDetails(), getActivity());
        detailsAdapter.setOnItemClick(new DetailsAdapter.EnityItemClick() {
            @Override
            public void onEnityItemClick(PersonalDetails personalDetails) {
                if (profileClickListener != null) {
                    profileClickListener.onProfileItemClick(personalDetails);
                }
            }
        });
        profile_list.setHasFixedSize(false);
        LinearLayoutManager myLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        profile_list.setLayoutManager(myLinearLayoutManager);
        profile_list.setAdapter(detailsAdapter);
        if (profileClickListener != null) {
            profileClickListener.onProfileItemClick(detailedResults.getProfileDetails().get(0).getPersonalDetails());
        }
    }

    private void parseData(String response) {
        Gson gson = new GsonBuilder().create();
        DetailedResults detailedResults = gson.fromJson(response, DetailedResults.class);
        if (!detailedResults.getResponseInfo().getStatus().equalsIgnoreCase("error")) {
            bindRecyclerView(detailedResults);
        } else {
            Toast.makeText(getActivity(), "Data Not Available from service. Loading cache data...", Toast.LENGTH_LONG).show();
        }
    }


    public class WebRequest extends AsyncTask<String, Void, String> {
        private static final String TAG = "WebRequest";

        @Override
        protected String doInBackground(String... ulr) {
            Response response = null;
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(ulr[0])
                    .build();

            try {
                response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                Log.i(TAG, e.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            parseData(result);
        }
    }


    public void setOnItemClick(ProfileClickListener itemClick) {
        this.profileClickListener = itemClick;
    }

    public interface ProfileClickListener {
        void onProfileItemClick(PersonalDetails personalDetails);
    }

}
