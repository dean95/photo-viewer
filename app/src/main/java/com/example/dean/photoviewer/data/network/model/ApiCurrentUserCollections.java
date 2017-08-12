package com.example.dean.photoviewer.data.network.model;

import com.google.gson.annotations.SerializedName;

public final class ApiCurrentUserCollections {

    @SerializedName("id")
    public Integer id;

    @SerializedName("title")
    public String title;

    @SerializedName("published_at")
    public String publishedAt;

    @SerializedName("updated_at")
    public String updatedAt;

    @SerializedName("curated")
    public Boolean curated;
}
