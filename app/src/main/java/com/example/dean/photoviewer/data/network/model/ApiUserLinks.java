package com.example.dean.photoviewer.data.network.model;

import com.google.gson.annotations.SerializedName;

public final class ApiUserLinks {

    @SerializedName("self")
    public String self;

    @SerializedName("html")
    public String html;

    @SerializedName("photos")
    public String photos;

    @SerializedName("likes")
    public String likes;

    @SerializedName("portfolio")
    public String portfolio;
}
