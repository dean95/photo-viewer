package com.example.dean.photoviewer.app.ui.photo;

public final class PhotoViewModel {

    private String id;
    private String description;
    private String dateCreated;
    private String author;
    private String photoUrl;

    public PhotoViewModel(final String id, final String description, final String dateCreated, final String author, final String photoUrl) {
        this.id = id;
        this.description = description;
        this.dateCreated = dateCreated;
        this.author = author;
        this.photoUrl = photoUrl;
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
}
