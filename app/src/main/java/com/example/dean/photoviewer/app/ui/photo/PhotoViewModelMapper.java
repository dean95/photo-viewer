package com.example.dean.photoviewer.app.ui.photo;

import com.example.dean.photoviewer.domain.model.Photo;

import java.util.ArrayList;
import java.util.List;

public final class PhotoViewModelMapper {

    public List<PhotoViewModel> domainToPhotoViewModel(List<Photo> photos) {
        final List<PhotoViewModel> photoViewModels = new ArrayList<>(photos.size());

        for (final Photo photo : photos) {
            final String description = photo.getDescription() == null ? "Description is not available" : photo.getDescription();
            final PhotoViewModel photoViewModel = new PhotoViewModel(photo.getId(), description,
                                                                     photo.getDateCreated(), photo.getAuthor(), photo.getPhotoUrl());
            photoViewModels.add(photoViewModel);
        }

        return photoViewModels;
    }

    public PhotoViewModel domainToPhotoViewModel(Photo photo) {
        final String description = photo.getDescription() == null ? "Description is not available" : photo.getDescription();
        return new PhotoViewModel(photo.getId(), description, photo.getDateCreated(), photo.getAuthor(), photo.getPhotoUrl());
    }
}
