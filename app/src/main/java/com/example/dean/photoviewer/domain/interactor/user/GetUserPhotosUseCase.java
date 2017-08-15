package com.example.dean.photoviewer.domain.interactor.user;

import com.example.dean.photoviewer.data.database.entity.DbPhoto;
import com.example.dean.photoviewer.data.network.mapper.ApiMapper;
import com.example.dean.photoviewer.domain.model.Photo;
import com.example.dean.photoviewer.domain.repository.PhotoRepository;

import java.util.List;

import io.reactivex.Single;

public final class GetUserPhotosUseCase {

    private final PhotoRepository photoRepository;
    private final ApiMapper apiMapper;

    public GetUserPhotosUseCase(final PhotoRepository photoRepository, final ApiMapper apiMapper) {
        this.photoRepository = photoRepository;
        this.apiMapper = apiMapper;
    }

    public Single<List<Photo>> getUsersPhotos(final String username) {
        return photoRepository.getUsersPhotos(username).map(apiMapper::apiToDomain);
    }

    public List<DbPhoto> getUserPhotos() {
        return photoRepository.getUsersPhotos();
    }
}
