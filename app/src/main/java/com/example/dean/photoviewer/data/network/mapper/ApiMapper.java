package com.example.dean.photoviewer.data.network.mapper;

import com.example.dean.photoviewer.data.network.model.ApiCuratedPhoto;
import com.example.dean.photoviewer.domain.model.Photo;

import java.util.List;

public interface ApiMapper {

    List<Photo> apiToDomain(List<ApiCuratedPhoto> apiPhoto);
}
