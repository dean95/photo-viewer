package com.example.dean.photoviewer.app.ui.photo;

import com.example.dean.photoviewer.data.database.entity.DbUser;
import com.example.dean.photoviewer.data.database.mappers.DbMapper;
import com.example.dean.photoviewer.data.network.mapper.ApiMapper;
import com.example.dean.photoviewer.domain.interactor.photo.GetPhotoDataUseCase;
import com.example.dean.photoviewer.domain.interactor.photo.SavePhotoDataUseCase;
import com.example.dean.photoviewer.domain.interactor.user.SaveUserDataUseCase;
import com.example.dean.photoviewer.domain.model.Photo;
import com.example.dean.photoviewer.domain.model.User;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
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

    private void fetchPhotoDataSuccess(List<Photo> photos) {
        if (view.get() != null) {
            view.get().fetchPhotoDataSuccess(photoViewModelMapper.domainToPhotoViewModel(photos));
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
}
