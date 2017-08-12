package com.example.dean.photoviewer.data.network.model;

import com.google.gson.annotations.SerializedName;

public final class ApiUserProfileImage {

    @SerializedName("small")
    public String small;

    @SerializedName("medium")
    public String medium;

    @SerializedName("large")
    public String large;
}
