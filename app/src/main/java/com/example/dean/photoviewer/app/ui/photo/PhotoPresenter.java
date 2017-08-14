package com.example.dean.photoviewer.app.ui.photo;

import com.example.dean.photoviewer.domain.interactor.photo.GetPhotoDataUseCase;
import com.example.dean.photoviewer.domain.model.Photo;

import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PhotoPresenter implements PhotoContract.Presenter {

    @Inject
    GetPhotoDataUseCase getPhotoDataUseCase;

    @Inject
    PhotoViewModelMapper photoViewModelMapper;

    private final WeakReference<PhotoContract.View> view;

    public PhotoPresenter(final PhotoContract.View view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void showAuthorActivity() {

    }

    @Override
    public void getPhotoData() {
        getPhotoDataUseCase.getPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::fetchPhotoDataSuccess, this::fetchPhotoDataFail);
    }

    private void fetchPhotoDataSuccess(List<Photo> photos) {
        if (view.get() != null) {
            view.get().fetchPhotoDataSuccess(photoViewModelMapper.domainToPhotoViewModel(photos));
        }
    }

    private void fetchPhotoDataFail(final Throwable throwable) {
        if (view.get() != null) {
            view.get().fetchPhotoDataFail();
        }
    }
}
