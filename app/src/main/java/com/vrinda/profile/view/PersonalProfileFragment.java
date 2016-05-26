package com.vrinda.profile.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vrinda.profile.Model.Constants;
import com.vrinda.profile.Model.PersonalDetails;
import com.vrinda.profile.R;

/**
 * Created by vrinda venugopal on 5/24/2016.
 */
public class PersonalProfileFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.personal_details_detailed_view, container, false);
        TextView viewById = (TextView) this.view.findViewById(R.id.profile_descirption);
        TextView gender = (TextView) this.view.findViewById(R.id.profile_gender);
        ImageView imageView = (ImageView) this.view.findViewById(R.id.profile_icon_imageView);
        if (getArguments() != null) {
            PersonalDetails bundle = (PersonalDetails) getArguments().getSerializable(Constants.PROFILE_BUNDLE);
            viewById.setText(bundle.getDescritpion());
            gender.setText(bundle.getGender());
            Picasso.with(getActivity()).load(bundle.getPicture()).into(imageView);
        }
        return this.view;
    }
}
