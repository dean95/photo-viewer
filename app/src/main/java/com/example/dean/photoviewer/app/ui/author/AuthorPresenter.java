package com.example.dean.photoviewer.app.ui.author;

import com.example.dean.photoviewer.app.ui.router.Router;
import com.example.dean.photoviewer.data.database.mappers.DbMapper;
import com.example.dean.photoviewer.domain.interactor.photo.SaveUserPhotosUseCase;
import com.example.dean.photoviewer.domain.interactor.user.GetOneUserUseCase;
import com.example.dean.photoviewer.domain.interactor.user.GetUserPhotosUseCase;
import com.example.dean.photoviewer.domain.model.Photo;

import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AuthorPresenter implements AuthorContract.Presenter {

    private WeakReference<AuthorContract.View> view;

    public AuthorPresenter(final AuthorContract.View view) {
        this.view = new WeakReference<>(view);
    }

    @Inject
    GetOneUserUseCase getOneUserUseCase;

    @Inject
    GetUserPhotosUseCase getUserPhotosUseCase;

    @Inject
    SaveUserPhotosUseCase saveUserPhotosUseCase;

    @Inject
    Router router;

    @Inject
    DbMapper dbMapper;

    @Override
    public void getAuthorData(final String authorName) {
        Single.fromCallable(() -> getOneUserUseCase.getUser(authorName))
              .map(dbUser -> dbMapper.dbUserToViewModel(dbUser))
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(this::fetchUserSuccess);
    }

    @Override
    public void getAuthorPhotos(final String username) {
        getUserPhotosUseCase.getUsersPhotos(username)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(this::getUsersPhotosSuccess);
    }

    @Override
    public void showPhotoActivity() {
        router.showPhotoActivity();
    }

    private void getUsersPhotosSuccess(final List<Photo> photos) {
        if (view.get() != null) {
            view.get().renderUserPhotos(photos);
        }

        saveUserPhotos(photos);
    }

    private void fetchUserSuccess(final AuthorViewModel user) {
        if (view.get() != null) {
            view.get().renderUserData(user);
        }
    }

    private void saveUserPhotos(final List<Photo> photos) {
        Completable.fromAction(() -> saveUserPhotosUseCase.saveUserPhotos(photos))
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                   .subscribe();
    }
}
