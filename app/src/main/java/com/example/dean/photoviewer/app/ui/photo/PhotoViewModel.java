package com.example.dean.photoviewer.app.ui.photo;

import android.os.Parcel;
import android.os.Parcelable;

public final class PhotoViewModel implements Parcelable {

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

    protected PhotoViewModel(Parcel in) {
        id = in.readString();
        description = in.readString();
        dateCreated = in.readString();
        author = in.readString();
        photoUrl = in.readString();
    }

    public static final Creator<PhotoViewModel> CREATOR = new Creator<PhotoViewModel>() {

        @Override
        public PhotoViewModel createFromParcel(Parcel in) {
            return new PhotoViewModel(in);
        }

        @Override
        public PhotoViewModel[] newArray(int size) {
            return new PhotoViewModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel parcel, final int i) {
        parcel.writeString(id);
        parcel.writeString(description);
        parcel.writeString(dateCreated);
        parcel.writeString(author);
        parcel.writeString(photoUrl);
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
