package com.vrinda.profile.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by vrinda venugopal on 5/24/2016.
 */
public class PersonalDetails implements Serializable {

    @SerializedName("gender")
    String gender;

    @SerializedName("number")
    int number;

    @SerializedName("thumbnail")
    String thumbnail;

    @SerializedName("picture")
    String picture;

    @SerializedName("descritpion")
    String descritpion;

    @Override
    public String toString() {
        return "Entity{" +
                "gender='" + gender + '\'' +
                ", number=" + number +
                ", thumbnail='" + thumbnail + '\'' +
                ", picture='" + picture + '\'' +
                ", descritpion='" + descritpion + '\'' +
                '}';
    }

    public String getPicture() {
        return picture;
    }

    public String getGender() {
        return gender;
    }

    public int getNumber() {
        return number;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getDescritpion() {
        return descritpion;
    }

}
