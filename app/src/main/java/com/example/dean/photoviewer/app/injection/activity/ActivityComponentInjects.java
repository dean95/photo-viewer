package com.example.dean.photoviewer.app.injection.activity;

import com.example.dean.photoviewer.app.ui.photo.PhotoActivity;
import com.example.dean.photoviewer.app.ui.photo.PhotoPresenter;

public interface ActivityComponentInjects {

    void inject(PhotoPresenter presenter);

    void inject(PhotoActivity activity);
}
