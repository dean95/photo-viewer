package com.example.dean.photoviewer.domain.repository;

import com.example.dean.photoviewer.data.network.model.ApiCuratedPhoto;

import java.util.List;

import io.reactivex.Single;

public interface PhotoRepository {

    Single<List<ApiCuratedPhoto>> getPhotos();
}
