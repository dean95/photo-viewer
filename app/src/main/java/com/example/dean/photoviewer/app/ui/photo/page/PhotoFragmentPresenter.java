package com.example.dean.photoviewer.app.ui.photo.page;

import com.example.dean.photoviewer.app.ui.photo.PhotoViewModel;
import com.example.dean.photoviewer.app.ui.router.Router;

import javax.inject.Inject;

public class PhotoFragmentPresenter implements PhotoFragmentContract.Presenter {

    @Inject
    Router router;

    @Override
    public void showAuthorActivity() {
        router.showAuthorActivity();
    }
}
