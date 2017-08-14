package com.example.dean.photoviewer.app.injection.activity;

import com.example.dean.photoviewer.app.ui.author.AuthorActivity;
import com.example.dean.photoviewer.app.ui.photo.PhotoActivity;
import com.example.dean.photoviewer.app.ui.photo.PhotoActivityPresenter;

public interface ActivityComponentInjects {

    void inject(PhotoActivityPresenter presenter);

    void inject(PhotoActivity activity);

    void inject(AuthorActivity activity);
}
