package com.example.dean.photoviewer.data.network.service;

import com.example.dean.photoviewer.data.network.model.ApiCuratedPhoto;

import java.util.List;

import io.reactivex.Single;

public final class UnsplashClientImpl implements UnsplashClient {

    private final UnsplashService unsplashService;

    public UnsplashClientImpl(final UnsplashService unsplashService) {
        this.unsplashService = unsplashService;
    }

    @Override
    public Single<List<ApiCuratedPhoto>> getCuratedPhotos() {
        return unsplashService.getCuratedPhotos();
    }
}
