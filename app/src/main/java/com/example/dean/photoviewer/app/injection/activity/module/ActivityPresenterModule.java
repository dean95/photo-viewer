package com.example.dean.photoviewer.app.injection.activity.module;

import com.example.dean.photoviewer.app.injection.activity.ActivityScope;
import com.example.dean.photoviewer.app.injection.activity.DaggerActivity;
import com.example.dean.photoviewer.app.ui.photo.PhotoContract;
import com.example.dean.photoviewer.app.ui.photo.PhotoPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public final class ActivityPresenterModule {

    private final DaggerActivity daggerActivity;

    public ActivityPresenterModule(final DaggerActivity daggerActivity) {
        this.daggerActivity = daggerActivity;
    }

    @Provides
    @ActivityScope
    PhotoContract.Presenter providePhotoPresenter() {
        final PhotoPresenter presenter = new PhotoPresenter((PhotoContract.View) daggerActivity);
        daggerActivity.getActivityComponent().inject(presenter);
        return presenter;
    }
}
