package com.example.dean.photoviewer.domain.model;

public final class User {

    private String userId;
    private String name;
    private String username;
    private String profileImageUrl;
    private String portfolioUrl;

    public User(final String userId, final String name, final String username, final String profileImageUrl, final String portfolioUrl) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.profileImageUrl = profileImageUrl;
        this.portfolioUrl = portfolioUrl;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }
}
