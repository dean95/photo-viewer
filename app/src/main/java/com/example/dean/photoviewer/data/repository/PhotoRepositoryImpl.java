package com.example.dean.photoviewer.data.repository;

import com.example.dean.photoviewer.data.network.model.ApiCuratedPhoto;
import com.example.dean.photoviewer.data.network.service.UnsplashClient;
import com.example.dean.photoviewer.domain.repository.PhotoRepository;

import java.util.List;

import io.reactivex.Single;

public final class PhotoRepositoryImpl implements PhotoRepository {

    private final UnsplashClient unsplashClient;

    public PhotoRepositoryImpl(final UnsplashClient unsplashClient) {
        this.unsplashClient = unsplashClient;
    }

    @Override
    public Single<List<ApiCuratedPhoto>> getPhotos() {
        return unsplashClient.getCuratedPhotos();
    }
}
