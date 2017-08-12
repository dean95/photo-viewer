package com.example.dean.photoviewer.data.network.model;

import com.google.gson.annotations.SerializedName;

public final class ApiPhotoLinks {

    @SerializedName("self")
    public String self;

    @SerializedName("html")
    public String html;

    @SerializedName("download")
    public String download;

    @SerializedName("download_location")
    public String downloadLocation;
}
