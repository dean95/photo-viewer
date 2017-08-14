package com.example.dean.photoviewer.app.injection.application.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.dean.photoviewer.app.application.PhotoViewerApplication;
import com.example.dean.photoviewer.app.injection.application.ForApplication;
import com.example.dean.photoviewer.data.database.db.AppDatabase;
import com.example.dean.photoviewer.data.network.service.UnsplashClient;
import com.example.dean.photoviewer.data.network.service.UnsplashClientImpl;
import com.example.dean.photoviewer.data.network.service.UnsplashService;
import com.example.dean.photoviewer.data.repository.PhotoRepositoryImpl;
import com.example.dean.photoviewer.data.repository.UserRepositoryImpl;
import com.example.dean.photoviewer.domain.repository.PhotoRepository;
import com.example.dean.photoviewer.domain.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public final class DataModule {

    private static final String UNSPLASH_BASE_URL = "https://api.unsplash.com/";

    private final PhotoViewerApplication application;

    public DataModule(final PhotoViewerApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(final HttpLoggingInterceptor interceptor) {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(final OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl(UNSPLASH_BASE_URL)
                                     .client(okHttpClient)
                                     .addConverterFactory(GsonConverterFactory.create())
                                     .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                     .build();
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@ForApplication final Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DB_NAME).build();
    }

    @Provides
    @Singleton
    UnsplashService provideUnsplashService(final Retrofit retrofit) {
        return retrofit.create(UnsplashService.class);
    }

    @Provides
    @Singleton
    UnsplashClient provideUnsplashClient(final UnsplashService unsplashService) {
        return new UnsplashClientImpl(unsplashService);
    }

    @Provides
    @Singleton
    PhotoRepository providePhotoRepository(final UnsplashClient unsplashClient, final AppDatabase appDatabase) {
        return new PhotoRepositoryImpl(unsplashClient, appDatabase);
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(final AppDatabase appDatabase) {
        return new UserRepositoryImpl(appDatabase);
    }

    public interface Exposes {

    }
}
