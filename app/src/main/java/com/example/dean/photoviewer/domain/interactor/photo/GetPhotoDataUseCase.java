package com.example.dean.photoviewer.domain.interactor.photo;

import com.example.dean.photoviewer.data.network.mapper.ApiMapper;
import com.example.dean.photoviewer.domain.model.Photo;
import com.example.dean.photoviewer.domain.repository.PhotoRepository;

import java.util.List;

import io.reactivex.Single;

public class GetPhotoDataUseCase {

    private final PhotoRepository photoRepository;
    private final ApiMapper apiMapper;

    public GetPhotoDataUseCase(final PhotoRepository photoRepository, final ApiMapper apiMapper) {
        this.photoRepository = photoRepository;
        this.apiMapper = apiMapper;
    }

    public Single<List<Photo>> getPhotos() {
        return photoRepository.getPhotos().map(apiMapper::apiToDomain);
    }
}
