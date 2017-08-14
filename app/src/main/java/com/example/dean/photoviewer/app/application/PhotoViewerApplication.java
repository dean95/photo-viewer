package com.example.dean.photoviewer.app.application;

import android.app.Application;

import com.example.dean.photoviewer.app.injection.application.ApplicationComponent;
import com.facebook.stetho.Stetho;

public final class PhotoViewerApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);

        initApplicationComponent();
        injectMe();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    private void injectMe() {
        applicationComponent.inject(this);
    }

    private void initApplicationComponent() {
        applicationComponent = ApplicationComponent.Initializer.init(this);
    }
}
