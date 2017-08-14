package com.example.dean.photoviewer.domain.interactor.photo;

import com.example.dean.photoviewer.data.database.entity.DbPhoto;
import com.example.dean.photoviewer.domain.repository.PhotoRepository;

import java.util.List;

public final class SavePhotoDataUseCase {

    private final PhotoRepository photoRepository;

    public SavePhotoDataUseCase(final PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public void savePhotoData(final List<DbPhoto> photos) {
        photoRepository.savePhotoData(photos);
    }
}
