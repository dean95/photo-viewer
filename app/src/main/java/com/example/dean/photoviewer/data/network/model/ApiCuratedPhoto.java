package com.example.dean.photoviewer.data.network.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class ApiCuratedPhoto {

    @SerializedName("id")
    public String id;

    @SerializedName("created_at")
    public String createdAt;

    @SerializedName("updated_at")
    public String updatedAt;

    @SerializedName("width")
    public Integer width;

    @SerializedName("height")
    public Integer height;

    @SerializedName("color")
    public String color;

    @SerializedName("likes")
    public Integer likes;

    @SerializedName("liked_by_user")
    public Boolean likedByUser;

    @SerializedName("description")
    @Nullable
    public String description;

    @SerializedName("user")
    public ApiUser user;

    @SerializedName("current_user_collections")
    public List<ApiCurrentUserCollections> currentUserCollections;

    @SerializedName("urls")
    public ApiUrls urls;

    @SerializedName("categories")
    public List<ApiCategories> categories;

    @SerializedName("links")
    public ApiLinks links;
}
