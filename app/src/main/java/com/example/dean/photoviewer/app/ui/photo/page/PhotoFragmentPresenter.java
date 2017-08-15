package com.example.dean.photoviewer.app.ui.photo.page;

import android.util.Log;

import com.example.dean.photoviewer.app.injection.application.module.ThreadingModule;
import com.example.dean.photoviewer.app.ui.photo.PhotoViewModelMapper;
import com.example.dean.photoviewer.app.ui.router.Router;
import com.example.dean.photoviewer.data.database.entity.DbUser;
import com.example.dean.photoviewer.data.database.mappers.DbMapper;
import com.example.dean.photoviewer.domain.interactor.photo.GetOnePhotoUseCase;
import com.example.dean.photoviewer.domain.model.Photo;

import java.lang.ref.WeakReference;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class PhotoFragmentPresenter implements PhotoFragmentContract.Presenter {

    public WeakReference<PhotoFragmentContract.View> view;

    private CompositeDisposable disposables = new CompositeDisposable();

    @Inject
    GetOnePhotoUseCase getOnePhotoUseCase;

    @Inject
    PhotoViewModelMapper photoViewModelMapper;

    @Inject
    @Named(ThreadingModule.MAIN_SCHEDULER)
    Scheduler mainScheduler;

    @Inject
    @Named(ThreadingModule.BACKGROUND_SCHEDULER)
    Scheduler backgroundScheduler;

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
        disposables.add(Single.fromCallable(() -> getOnePhotoUseCase.getPhoto(id))
                              .map(dbPhoto -> dbMapper.dbPhotoToDomain(dbPhoto))
                              .subscribeOn(backgroundScheduler)
                              .observeOn(mainScheduler)
                              .subscribe(this::fetchDataSuccess, this::errorHandling));
    }

    @Override
    public void unsubscribe() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    private void fetchDataSuccess(final Photo photo) {
        if (view.get() != null) {
            view.get().fetchDataSuccess(photoViewModelMapper.domainToPhotoViewModel(photo));
        }
    }

    private void errorHandling(final Throwable throwable) {
        Log.d("PhotoFragmentPresenter", throwable.getMessage());
    }
}
