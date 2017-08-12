package com.example.dean.photoviewer.data.network.model;

import com.google.gson.annotations.SerializedName;

public final class ApiUser {

    @SerializedName("id")
    public String id;

    @SerializedName("username")
    public String username;

    @SerializedName("name")
    public String name;

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("twitter_username")
    public String twitterUsername;

    @SerializedName("portfolio_url")
    public String portfolioUrl;

    @SerializedName("bio")
    public String bio;

    @SerializedName("location")
    public String location;

    @SerializedName("total_likes")
    public Integer totalLikes;

    @SerializedName("total_photos")
    public Integer totalPhotos;

    @SerializedName("total_collections")
    public Integer totalCollections;

    @SerializedName("profile_image")
    public ApiUserProfileImage profileImage;

    @SerializedName("links")
    public ApiUserLinks links;
}
