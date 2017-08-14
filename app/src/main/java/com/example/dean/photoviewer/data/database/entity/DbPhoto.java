package com.example.dean.photoviewer.data.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "photo")
public final class DbPhoto {

    @PrimaryKey
    @ColumnInfo(name = "_id")
    private String photoId;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "date_created")
    private String dateCreated;

    @ColumnInfo(name = "author")
    private String author;

    @ColumnInfo(name = "photo_url")
    private String photoUrl;

    public DbPhoto(final String photoId, final String description, final String dateCreated, final String author, final String photoUrl) {
        this.photoId = photoId;
        this.description = description;
        this.dateCreated = dateCreated;
        this.author = author;
        this.photoUrl = photoUrl;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(final String photoId) {
        this.photoId = photoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(final String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
