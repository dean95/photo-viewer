package com.example.dean.photoviewer.app.injection.application.module;

import com.example.dean.photoviewer.data.network.mapper.ApiMapper;
import com.example.dean.photoviewer.domain.interactor.photo.GetPhotoDataUseCase;
import com.example.dean.photoviewer.domain.repository.PhotoRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class UseCaseModule {

    @Provides
    @Singleton
    GetPhotoDataUseCase provideGetPhotoDataUseCase(final PhotoRepository photoRepository, final ApiMapper apiMapper) {
        return new GetPhotoDataUseCase(photoRepository, apiMapper);
    }

    public interface Exposes {

        GetPhotoDataUseCase getPhotoDataUseCase();
    }
}
