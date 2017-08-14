package com.example.dean.photoviewer.data.network.mapper;

import com.example.dean.photoviewer.data.network.model.ApiCuratedPhoto;
import com.example.dean.photoviewer.domain.model.Photo;

import java.util.ArrayList;
import java.util.List;

public final class ApiMapperImpl implements ApiMapper {

    @Override
    public List<Photo> apiToDomain(final List<ApiCuratedPhoto> apiPhotos) {
        final List<Photo> photos = new ArrayList<>(apiPhotos.size());

        for (ApiCuratedPhoto apiPhoto : apiPhotos) {
            Photo photo = new Photo(apiPhoto.id, apiPhoto.description, apiPhoto.createdAt, apiPhoto.user.name, apiPhoto.urls.regular);
            photos.add(photo);
        }

        return photos;
    }
}
