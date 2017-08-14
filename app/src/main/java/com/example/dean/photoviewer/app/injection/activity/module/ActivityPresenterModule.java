package com.example.dean.photoviewer.app.injection.activity.module;

import com.example.dean.photoviewer.app.injection.activity.ActivityScope;
import com.example.dean.photoviewer.app.injection.activity.DaggerActivity;
import com.example.dean.photoviewer.app.ui.author.AuthorContract;
import com.example.dean.photoviewer.app.ui.author.AuthorPresenter;
import com.example.dean.photoviewer.app.ui.photo.PhotoActivityContract;
import com.example.dean.photoviewer.app.ui.photo.PhotoActivityPresenter;

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
    PhotoActivityContract.Presenter providePhotoPresenter() {
        final PhotoActivityPresenter presenter = new PhotoActivityPresenter((PhotoActivityContract.View) daggerActivity);
        daggerActivity.getActivityComponent().inject(presenter);
        return presenter;
    }

    @Provides
    @ActivityScope
    AuthorContract.Presenter provideAuthorPresenter() {
        final AuthorPresenter presenter = new AuthorPresenter((AuthorContract.View) daggerActivity);
        daggerActivity.getActivityComponent().inject(presenter);
        return presenter;
    }
}
