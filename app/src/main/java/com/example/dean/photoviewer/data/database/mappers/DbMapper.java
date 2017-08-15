package com.example.dean.photoviewer.data.database.mappers;

import com.example.dean.photoviewer.app.ui.author.AuthorViewModel;
import com.example.dean.photoviewer.data.database.entity.DbPhoto;
import com.example.dean.photoviewer.data.database.entity.DbUser;
import com.example.dean.photoviewer.domain.model.Photo;
import com.example.dean.photoviewer.domain.model.User;

import java.util.ArrayList;
import java.util.List;

public final class DbMapper {

    public List<DbPhoto> domainPhotoToDb(List<Photo> photos) {
        final List<DbPhoto> dbPhotos = new ArrayList<>(photos.size());
        for (Photo photo : photos) {
            final DbPhoto dbPhoto = new DbPhoto(photo.getId(),
                                                photo.getDescription(), photo.getDateCreated(), photo.getAuthor(), photo.getPhotoUrl());
            dbPhotos.add(dbPhoto);
        }

        return dbPhotos;
    }

    public List<DbUser> domainUserToDb(List<User> users) {
        final List<DbUser> dbUsers = new ArrayList<>(users.size());
        for (User user : users) {
            final DbUser dbUser = new DbUser(user.getUserId(), user.getName(), user.getUsername(),
                                             user.getProfileImageUrl(), user.getPortfolioUrl());
            dbUsers.add(dbUser);
        }

        return dbUsers;
    }

    public Photo dbPhotoToDomain(DbPhoto dbPhoto) {
        return new Photo(dbPhoto.getPhotoId(), dbPhoto.getDescription(), dbPhoto.getDateCreated(), dbPhoto.getAuthor(), dbPhoto.getPhotoUrl());
    }

    public List<Photo> dbPhotosToDomain(List<DbPhoto> dbPhotos) {
        final List<Photo> photos = new ArrayList<>(dbPhotos.size());
        for (DbPhoto dbPhoto : dbPhotos) {
            final Photo photo = new Photo(dbPhoto.getPhotoId(),
                                          dbPhoto.getDescription(), dbPhoto.getDateCreated(), dbPhoto.getAuthor(), dbPhoto.getPhotoUrl());
            photos.add(photo);
        }

        return photos;
    }

    public AuthorViewModel dbUserToViewModel(DbUser user) {
        return new AuthorViewModel(user.getUserId(), user.getName(), user.getPortfolioUrl(), user.getUsername(), user.getProfileImageUrl());
    }
}
