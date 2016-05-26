package com.vrinda.profile.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 08468 on 5/26/2016.
 */
public class ResponseInfo {

    @SerializedName("status")
    String status;

    public String getStatus() {
        return status;
    }
}
