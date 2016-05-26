package com.vrinda.profile.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by vrinda venugopal on 5/24/2016.
 */
public class Personal implements Serializable{

    @SerializedName("entity")
    PersonalDetails personalDetails;

    @SerializedName("seed")
    String seed;

    @Override
    public String toString() {
        return "EntityDetails{" +
                "entity=" + personalDetails +
                ", seed='" + seed + '\'' +
                '}';
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

      public String getSeed() {
        return seed;
    }

}
