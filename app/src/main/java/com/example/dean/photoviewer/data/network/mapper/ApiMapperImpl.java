package com.example.dean.photoviewer.data.network.mapper;

import com.example.dean.photoviewer.data.network.model.ApiCuratedPhoto;
import com.example.dean.photoviewer.data.network.model.ApiUser;
import com.example.dean.photoviewer.domain.model.Photo;
import com.example.dean.photoviewer.domain.model.User;

import java.util.ArrayList;
import java.util.List;

public final class ApiMapperImpl implements ApiMapper {

    @Override
    public List<Photo> apiToDomain(final List<ApiCuratedPhoto> apiPhotos) {
        final List<Photo> photos = new ArrayList<>(apiPhotos.size());

        for (ApiCuratedPhoto apiPhoto : apiPhotos) {
            Photo photo = new Photo(apiPhoto.id, apiPhoto.description, apiPhoto.createdAt, apiPhoto.user.name, apiPhoto.urls.regular,
                                    apiUserToDomain(apiPhoto.user));
            photos.add(photo);
        }

        return photos;
    }

    private User apiUserToDomain(final ApiUser apiUser) {
        return new User(apiUser.id, apiUser.name, apiUser.username, apiUser.profileImage.medium, apiUser.portfolioUrl);
    }
}
