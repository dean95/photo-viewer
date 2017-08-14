package com.example.dean.photoviewer.app.injection.activity.module;

import android.app.Activity;
import android.content.Context;

import com.example.dean.photoviewer.app.injection.activity.ActivityScope;
import com.example.dean.photoviewer.app.injection.activity.DaggerActivity;
import com.example.dean.photoviewer.app.injection.activity.ForActivity;
import com.example.dean.photoviewer.app.ui.router.Router;
import com.example.dean.photoviewer.app.ui.router.RouterImpl;

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

    @Provides
    @ActivityScope
    Router provideRouter() {
        return new RouterImpl(daggerActivity);
    }

    public interface Exposes {

        Router router();
    }
}
