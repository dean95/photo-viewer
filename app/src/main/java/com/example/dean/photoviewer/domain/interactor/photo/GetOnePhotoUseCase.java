package com.example.dean.photoviewer.domain.interactor.photo;

import com.example.dean.photoviewer.data.database.entity.DbPhoto;
import com.example.dean.photoviewer.domain.repository.PhotoRepository;

public final class GetOnePhotoUseCase {

    private final PhotoRepository photoRepository;

    public GetOnePhotoUseCase(final PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public DbPhoto getPhoto(final String id) {
        return photoRepository.getOnePhoto(id);
    }
}
