package com.example.dean.photoviewer.app.ui.author;

public final class AuthorViewModel {

    private String id;
    private String name;
    private String portfolioUrl;
    private String username;
    private String profileImageUrl;

    public AuthorViewModel(final String id, final String name, final String portfolioUrl, final String username, final String profileImageUrl) {
        this.id = id;
        this.name = name;
        this.portfolioUrl = portfolioUrl;
        this.username = username;
        this.profileImageUrl = profileImageUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }
}
