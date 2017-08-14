package com.example.dean.photoviewer.app.injection.application.module;

import com.example.dean.photoviewer.app.ui.photo.PhotoViewModelMapper;
import com.example.dean.photoviewer.data.network.mapper.ApiMapper;
import com.example.dean.photoviewer.data.network.mapper.ApiMapperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class MappersModule {

    @Provides
    @Singleton
    ApiMapper provideApiMapper() {
        return new ApiMapperImpl();
    }

    @Provides
    @Singleton
    PhotoViewModelMapper providePhotoViewModelMapper() {
        return new PhotoViewModelMapper();
    }

    public interface Exposes {

        PhotoViewModelMapper photoViewModelMapper();
    }
}
