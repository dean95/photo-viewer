package com.example.dean.photoviewer.app.ui.photo;

import com.example.dean.photoviewer.data.database.mappers.DbMapper;
import com.example.dean.photoviewer.domain.interactor.photo.DeletePhotoDataUseCase;
import com.example.dean.photoviewer.domain.interactor.photo.GetPhotoDataUseCase;
import com.example.dean.photoviewer.domain.interactor.photo.SavePhotoDataUseCase;
import com.example.dean.photoviewer.domain.interactor.user.GetUserPhotosUseCase;
import com.example.dean.photoviewer.domain.interactor.user.SaveUserDataUseCase;
import com.example.dean.photoviewer.domain.model.Photo;
import com.example.dean.photoviewer.domain.model.User;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PhotoActivityPresenter implements PhotoActivityContract.Presenter {

    @Inject
    GetPhotoDataUseCase getPhotoDataUseCase;

    @Inject
    SavePhotoDataUseCase savePhotoDataUseCase;

    @Inject
    SaveUserDataUseCase saveUserDataUseCase;

    @Inject
    PhotoViewModelMapper photoViewModelMapper;

    @Inject
    GetUserPhotosUseCase getUserPhotosUseCase;

    @Inject
    DeletePhotoDataUseCase deletePhotoDataUseCase;

    @Inject
    DbMapper dbMapper;

    private final WeakReference<PhotoActivityContract.View> view;

    public PhotoActivityPresenter(final PhotoActivityContract.View view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void getPhotoData() {
        getPhotoDataUseCase.getPhotos()
                           .subscribeOn(Schedulers.io())
                           .observeOn(AndroidSchedulers.mainThread())
                           .subscribe(this::fetchPhotoDataSuccess, this::fetchPhotoDataFail);
    }

    @Override
    public void savePhotoData(List<Photo> photos) {
        Completable.fromAction(() -> savePhotoDataUseCase.savePhotoData(dbMapper.domainPhotoToDb(photos)))
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe();
    }

    @Override
    public void saveUserData(final List<User> user) {
        Completable.fromAction(() -> saveUserDataUseCase.saveUserData(dbMapper.domainUserToDb(user)))
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe();
    }

    @Override
    public void getUserPhotos() {
        Single.fromCallable(() -> getUserPhotosUseCase.getUserPhotos())
              .map(dbPhoto -> dbMapper.dbPhotosToDomain(dbPhoto))
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(this::fetchUserPhotosSuccess, this::errorHandling);
    }

    private void fetchUserPhotosSuccess(List<Photo> photos) {
        if (view.get() != null) {
            view.get().fetchPhotoDataSuccess(getPhotoIds(photos));
        }
    }

    private void fetchPhotoDataSuccess(List<Photo> photos) {
        if (view.get() != null) {
            view.get().fetchPhotoDataSuccess(getPhotoIds(photos));
        }

        savePhotoData(photos);

        final List<User> users = new ArrayList<>(photos.size());
        for (Photo photo : photos) {
            final User dbUser = photo.getUser();
            users.add(dbUser);
        }
        saveUserData(users);
    }

    private void fetchPhotoDataFail(final Throwable throwable) {
        if (view.get() != null) {
            view.get().fetchPhotoDataFail();
        }
    }

    private List<String> getPhotoIds(List<Photo> photos) {
        final List<String> ids = new ArrayList<>(photos.size());
        for (final Photo photo : photos) {
            final String id = photo.getId();
            ids.add(id);
        }

        return ids;
    }

    private void errorHandling(final Throwable throwable) {
        //do nothing
    }
}
