package com.example.dean.photoviewer.data.repository;

import com.example.dean.photoviewer.data.database.db.AppDatabase;
import com.example.dean.photoviewer.data.database.entity.DbPhoto;
import com.example.dean.photoviewer.data.network.model.ApiCuratedPhoto;
import com.example.dean.photoviewer.data.network.service.UnsplashClient;
import com.example.dean.photoviewer.domain.repository.PhotoRepository;

import java.util.List;

import io.reactivex.Single;

public final class PhotoRepositoryImpl implements PhotoRepository {

    private final UnsplashClient unsplashClient;
    private final AppDatabase database;

    public PhotoRepositoryImpl(final UnsplashClient unsplashClient, final AppDatabase database) {
        this.unsplashClient = unsplashClient;
        this.database = database;
    }

    @Override
    public Single<List<ApiCuratedPhoto>> getPhotos() {
        return unsplashClient.getCuratedPhotos();
    }

    @Override
    public Single<List<ApiCuratedPhoto>> getUsersPhotos(final String username) {
        return unsplashClient.getUsersPhotos(username);
    }

    @Override
    public DbPhoto getOnePhoto(final String id) {
        return database.photoDao().getOne(id);
    }

    @Override
    public void savePhotoData(List<DbPhoto> photos) {
        database.photoDao().insertAll(photos);
    }
}
