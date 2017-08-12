package com.example.dean.photoviewer.data.network.service;

import com.example.dean.photoviewer.data.network.model.ApiCuratedPhoto;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface UnsplashService {

    String APPLICATION_ID = "Client-ID 66f45808ff812e016ff8ba16bb06e6ab5bd18653c9573a6412a782ef37d34451";

    @Headers("Application: " + APPLICATION_ID)
    @GET("photos/curated")
    Single<List<ApiCuratedPhoto>> getCuratedPhotos();
}
