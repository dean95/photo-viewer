package com.example.dean.photoviewer.domain.interactor.photo;

import com.example.dean.photoviewer.data.database.mappers.DbMapper;
import com.example.dean.photoviewer.domain.model.Photo;
import com.example.dean.photoviewer.domain.repository.PhotoRepository;

import java.util.List;

public final class SaveUserPhotosUseCase {

    private final PhotoRepository photoRepository;
    private final DbMapper dbMapper;

    public SaveUserPhotosUseCase(final PhotoRepository photoRepository, final DbMapper dbMapper) {
        this.photoRepository = photoRepository;
        this.dbMapper = dbMapper;
    }

    public void saveUserPhotos(final List<Photo> photos) {
        photoRepository.saveUserPhotos(dbMapper.domainPhotoToDb(photos));
    }
}
