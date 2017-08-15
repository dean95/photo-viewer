package com.example.dean.photoviewer.domain.repository;

import com.example.dean.photoviewer.data.database.entity.DbPhoto;
import com.example.dean.photoviewer.data.network.model.ApiCuratedPhoto;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface PhotoRepository {

    Single<List<ApiCuratedPhoto>> getPhotos();

    Single<List<ApiCuratedPhoto>> getUsersPhotos(String username);

    DbPhoto getOnePhoto(String id);

    List<DbPhoto> getUsersPhotos();

    void savePhotoData(List<DbPhoto> photos);

    void saveUserPhotos(List<DbPhoto> userPhotos);

    void deletePhotoData();
}
