package com.example.dean.photoviewer.app.injection.application.module;

import com.example.dean.photoviewer.data.network.mapper.ApiMapper;
import com.example.dean.photoviewer.domain.interactor.photo.GetOnePhotoUseCase;
import com.example.dean.photoviewer.domain.interactor.photo.GetPhotoDataUseCase;
import com.example.dean.photoviewer.domain.interactor.photo.SavePhotoDataUseCase;
import com.example.dean.photoviewer.domain.interactor.user.GetOneUserUseCase;
import com.example.dean.photoviewer.domain.interactor.user.GetUserPhotosUseCase;
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

    @Provides
    @Singleton
    GetOnePhotoUseCase provideGetOnePhotoUseCase(final PhotoRepository photoRepository) {
        return new GetOnePhotoUseCase(photoRepository);
    }

    @Provides
    @Singleton
    GetOneUserUseCase provideGetOneUserUseCase(final UserRepository userRepository) {
        return new GetOneUserUseCase(userRepository);
    }

    @Provides
    @Singleton
    GetUserPhotosUseCase provideGetUserPhotosUseCase(final PhotoRepository photoRepository, final ApiMapper apiMapper) {
        return new GetUserPhotosUseCase(photoRepository, apiMapper);
    }

    public interface Exposes {

        GetPhotoDataUseCase getPhotoDataUseCase();

        SavePhotoDataUseCase savePhotoDataUseCase();

        SaveUserDataUseCase saveUserDataUseCase();

        GetOnePhotoUseCase getOnePhotoUseCase();

        GetOneUserUseCase getOneUserUseCase();

        GetUserPhotosUseCase getUsersPhotosUseCase();
    }
}
