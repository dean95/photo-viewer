package com.example.dean.photoviewer.domain.model;

public final class Photo {

    private String id;
    private String description;
    private String dateCreated;
    private String author;
    private String photoUrl;
    private User user;

    public Photo(final String id, final String description, final String dateCreated, final String author, final String photoUrl, final User user) {
        this.id = id;
        this.description = description;
        this.dateCreated = dateCreated;
        this.author = author;
        this.photoUrl = photoUrl;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getAuthor() {
        return author;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public User getUser() {
        return user;
    }
}
