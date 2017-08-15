package com.example.dean.photoviewer.app.ui.photo;

import com.example.dean.photoviewer.domain.model.Photo;
import com.example.dean.photoviewer.domain.model.User;

import java.util.List;

public interface PhotoActivityContract {

    interface Presenter {

        void getPhotoData();

        void savePhotoData(List<Photo> photos);

        void saveUserData(List<User> user);

        void getUserPhotos();
    }

    interface View {

        void fetchPhotoDataSuccess(List<String> ids);

        void fetchPhotoDataFail();
    }
}
