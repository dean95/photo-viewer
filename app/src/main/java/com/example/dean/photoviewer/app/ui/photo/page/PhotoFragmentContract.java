package com.example.dean.photoviewer.app.ui.photo.page;

import com.example.dean.photoviewer.app.ui.photo.PhotoViewModel;

public interface PhotoFragmentContract {

    interface Presenter {

        void showAuthorActivity(String auhorName);

        void getImageData(String id);

        void unsubscribe();
    }

    interface View {

        void fetchDataSuccess(PhotoViewModel photoViewModel);
    }
}
