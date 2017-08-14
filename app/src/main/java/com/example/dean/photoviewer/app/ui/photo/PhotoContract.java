package com.example.dean.photoviewer.app.ui.photo;

import java.util.List;

public interface PhotoContract {

    interface Presenter {

        void showAuthorActivity();

        void getPhotoData();
    }

    interface View {

        void fetchPhotoDataSuccess(List<PhotoViewModel> photoViewModels);

        void fetchPhotoDataFail();
    }
}
