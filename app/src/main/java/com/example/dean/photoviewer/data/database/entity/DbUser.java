package com.example.dean.photoviewer.data.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user")
public final class DbUser {

    @PrimaryKey
    @ColumnInfo(name = "_id")
    private String userId;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "profile_image_url")
    private String profileImageUrl;

    @ColumnInfo(name = "portfolio_url")
    private String portfolioUrl;

    public DbUser(final String userId, final String name, final String username, final String profileImageUrl, final String portfolioUrl) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.profileImageUrl = profileImageUrl;
        this.portfolioUrl = portfolioUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(final String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public void setPortfolioUrl(final String portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
    }
}
