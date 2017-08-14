package com.example.dean.photoviewer.app.ui.photo.page;

import com.example.dean.photoviewer.app.ui.photo.PhotoViewModelMapper;
import com.example.dean.photoviewer.app.ui.router.Router;
import com.example.dean.photoviewer.data.database.entity.DbUser;
import com.example.dean.photoviewer.data.database.mappers.DbMapper;
import com.example.dean.photoviewer.domain.interactor.photo.GetOnePhotoUseCase;
import com.example.dean.photoviewer.domain.model.Photo;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PhotoFragmentPresenter implements PhotoFragmentContract.Presenter {

    public WeakReference<PhotoFragmentContract.View> view;

    @Inject
    GetOnePhotoUseCase getOnePhotoUseCase;

    @Inject
    PhotoViewModelMapper photoViewModelMapper;

    @Inject
    DbMapper dbMapper;

    @Inject
    Router router;

    public PhotoFragmentPresenter(final PhotoFragmentContract.View view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void showAuthorActivity(final String authorName) {
        router.showAuthorActivity(authorName);
    }

    @Override
    public void getImageData(final String id) {
        Single.fromCallable(() -> getOnePhotoUseCase.getPhoto(id))
              .map(dbPhoto -> dbMapper.dbPhotoToDomain(dbPhoto))
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(this::fetchDataSuccess);
    }

    private void fetchDataSuccess(final Photo photo) {
        if (view.get() != null) {
            view.get().fetchDataSuccess(photoViewModelMapper.domainToPhotoViewModel(photo));
        }
    }
}
