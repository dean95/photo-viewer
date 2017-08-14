package com.example.dean.photoviewer.data.network.service;

import com.example.dean.photoviewer.data.network.model.ApiCuratedPhoto;

import java.util.List;

import io.reactivex.Single;

public interface UnsplashClient {

    Single<List<ApiCuratedPhoto>> getCuratedPhotos();

    Single<List<ApiCuratedPhoto>> getUsersPhotos(String username);
}
