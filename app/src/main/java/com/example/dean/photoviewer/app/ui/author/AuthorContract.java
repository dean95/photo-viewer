package com.example.dean.photoviewer.app.ui.author;

import com.example.dean.photoviewer.domain.model.Photo;

import java.util.List;

public interface AuthorContract {

    interface Presenter {

        void getAuthorData(String authorName);

        void getAuthorPhotos(String username);

        void showPhotoActivity();

        void unsubscribe();
    }

    interface View {

        void renderUserData(AuthorViewModel user);

        void renderUserPhotos(List<Photo> photo);
    }
}
