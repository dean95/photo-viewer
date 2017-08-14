package com.example.dean.photoviewer.app.injection.application.module;

import android.content.Context;

import com.example.dean.photoviewer.app.application.PhotoViewerApplication;
import com.example.dean.photoviewer.app.injection.application.ForApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class ApplicationModule {

    private PhotoViewerApplication application;

    public ApplicationModule(final PhotoViewerApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    PhotoViewerApplication providePhotoViewerApplication() {
        return application;
    }

    @Provides
    @Singleton
    @ForApplication
    Context provideApplicationContext() {
        return application;
    }

    public interface Exposes {

    }
}
