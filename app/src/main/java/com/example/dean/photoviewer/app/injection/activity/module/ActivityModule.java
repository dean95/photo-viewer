package com.example.dean.photoviewer.app.injection.activity.module;

import android.app.Activity;
import android.content.Context;

import com.example.dean.photoviewer.app.injection.activity.ActivityScope;
import com.example.dean.photoviewer.app.injection.activity.DaggerActivity;
import com.example.dean.photoviewer.app.injection.activity.ForActivity;

import dagger.Module;
import dagger.Provides;

@Module
public final class ActivityModule {

    private DaggerActivity daggerActivity;

    public ActivityModule(final DaggerActivity daggerActivity) {
        this.daggerActivity = daggerActivity;
    }

    @Provides
    @ActivityScope
    @ForActivity
    Context provideActivityContext() {
        return daggerActivity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return daggerActivity;
    }

    public interface Exposes {

    }
}
