package com.vrinda.profile.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by vrinda venugopal on 5/24/2016.
 */
public class DetailedResults implements Serializable {


    @SerializedName("results")
    ArrayList<Personal> entities;

    public ArrayList<Personal> getProfileDetails() {
        return entities;
    }

    @SerializedName("info")
    ResponseInfo responseInfo;

    public ResponseInfo getResponseInfo() {
        return responseInfo;
    }

    @Override
    public String toString() {
        return "DetailedResults{" +
                "entities=" + entities +
                ", responseInfo=" + responseInfo +
                '}';
    }
}
