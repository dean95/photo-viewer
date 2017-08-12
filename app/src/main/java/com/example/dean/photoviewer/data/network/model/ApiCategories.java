package com.example.dean.photoviewer.data.network.model;

import com.google.gson.annotations.SerializedName;

public final class ApiCategories {

    @SerializedName("ApiCategories")
    public Integer id;

    @SerializedName("title")
    public String title;

    @SerializedName("photo_count")
    public Integer photoCount;
}
