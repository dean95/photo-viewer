package com.example.dean.photoviewer.app.injection.fragment.module;

import com.example.dean.photoviewer.app.injection.fragment.DaggerFragment;
import com.example.dean.photoviewer.app.injection.fragment.FragmentComponent;
import com.example.dean.photoviewer.app.ui.photo.PhotoFragmentContract;
import com.example.dean.photoviewer.app.ui.photo.PhotoFragmentPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public final class FragmentPresenterModule {

    private final DaggerFragment daggerFragment;

    public FragmentPresenterModule(final DaggerFragment daggerFragment) {
        this.daggerFragment = daggerFragment;
    }

    private FragmentComponent getFragmentComponent() {
        return daggerFragment.getFragmentComponent();
    }

    @Provides
    PhotoFragmentContract.Presenter providePhotoFragmentPresenter() {
        final PhotoFragmentPresenter presenter = new PhotoFragmentPresenter();
        getFragmentComponent().inject(presenter);

        return presenter;
    }
}
