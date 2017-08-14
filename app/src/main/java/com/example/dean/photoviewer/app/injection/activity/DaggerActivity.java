package com.example.dean.photoviewer.app.injection.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.dean.photoviewer.app.application.PhotoViewerApplication;

public abstract class DaggerActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(getActivityComponent());
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = ActivityComponent.Initializer.init(this, getPhotoViewerAppclication().getApplicationComponent());
        }
        return activityComponent;
    }

    private PhotoViewerApplication getPhotoViewerAppclication() {
        return ((PhotoViewerApplication) getApplication());
    }

    protected abstract void inject(final ActivityComponent activityComponent);
}
