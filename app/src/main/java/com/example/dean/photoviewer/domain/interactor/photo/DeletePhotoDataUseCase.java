package com.example.dean.photoviewer.domain.interactor.photo;

import com.example.dean.photoviewer.domain.repository.PhotoRepository;

public final class DeletePhotoDataUseCase {

    private final PhotoRepository photoRepository;

    public DeletePhotoDataUseCase(final PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public void deleteAllData() {
        photoRepository.deletePhotoData();
    }
}
