package com.example.dean.photoviewer.app.injection.application.module;

import android.content.Context;

import com.example.dean.photoviewer.app.injection.application.ForApplication;
import com.example.dean.photoviewer.app.util.ImageLoader;
import com.example.dean.photoviewer.app.util.ImageLoaderImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class UtilsModule {

    @Provides
    @Singleton
    ImageLoader provideImageLoader(final @ForApplication Context context) {
        return new ImageLoaderImpl(context);
    }

    public interface Exposes {

        ImageLoader imageLoader();
    }
}
