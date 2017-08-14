package com.example.dean.photoviewer.app.injection.fragment;

import com.example.dean.photoviewer.app.ui.photo.page.PhotoFragment;
import com.example.dean.photoviewer.app.ui.photo.page.PhotoFragmentPresenter;

public interface FragmentComponentInjects {

    void inject(PhotoFragment photoFragment);

    void inject(PhotoFragmentPresenter presenter);
}
