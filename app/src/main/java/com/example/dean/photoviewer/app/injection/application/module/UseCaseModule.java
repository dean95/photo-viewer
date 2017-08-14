package com.example.dean.photoviewer.app.injection.application.module;

import com.example.dean.photoviewer.data.network.mapper.ApiMapper;
import com.example.dean.photoviewer.domain.interactor.photo.GetPhotoDataUseCase;
import com.example.dean.photoviewer.domain.interactor.photo.SavePhotoDataUseCase;
import com.example.dean.photoviewer.domain.interactor.user.SaveUserDataUseCase;
import com.example.dean.photoviewer.domain.repository.PhotoRepository;
import com.example.dean.photoviewer.domain.repository.UserRepository;

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

    @Provides
    @Singleton
    SavePhotoDataUseCase provideSavePhotoDataUseCase(final PhotoRepository photoRepository) {
        return new SavePhotoDataUseCase(photoRepository);
    }

    @Provides
    @Singleton
    SaveUserDataUseCase provideSaveUserDataUseCase(final UserRepository userRepository) {
        return new SaveUserDataUseCase(userRepository);
    }

    public interface Exposes {

        GetPhotoDataUseCase getPhotoDataUseCase();

        SavePhotoDataUseCase savePhotoDataUseCase();

        SaveUserDataUseCase saveUserDataUseCase();
    }
}
