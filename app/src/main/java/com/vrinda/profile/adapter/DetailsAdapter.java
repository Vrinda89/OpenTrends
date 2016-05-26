package com.vrinda.profile.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import com.vrinda.profile.Model.Personal;
import com.vrinda.profile.Model.PersonalDetails;
import com.vrinda.profile.R;

/**
 * Created by vrinda venugopal on 5/24/2016.
 */
public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.MyViewHolder> {

    private final Context context;
    private List<Personal> entityDetails;
    private EnityItemClick itemClick;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mmageView;
        public TextView title;
        public LinearLayout mView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.profile_number);
            mView = (LinearLayout) view.findViewById(R.id.recyclermain);
            mmageView = (ImageView) view.findViewById(R.id.profile_icon_imageView);
        }
    }


    public DetailsAdapter(List<Personal> entityDetails, Context context) {
        this.entityDetails = entityDetails;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.personal_details_list_item_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Personal personal = this.entityDetails.get(position);
        holder.title.setText(String.valueOf(personal.getPersonalDetails().getNumber()));
        Picasso.with(context).load(personal.getPersonalDetails().getPicture()).into(holder.mmageView);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClick != null) {
                    itemClick.onEnityItemClick(personal.getPersonalDetails());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return entityDetails.size();
    }

    public void setOnItemClick(EnityItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public interface EnityItemClick {
        void onEnityItemClick(PersonalDetails personalDetails);
    }
}
