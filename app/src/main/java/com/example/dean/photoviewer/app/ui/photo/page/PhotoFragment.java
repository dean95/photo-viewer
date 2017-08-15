package com.example.dean.photoviewer.app.ui.photo.page;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dean.photoviewer.R;
import com.example.dean.photoviewer.app.injection.fragment.DaggerFragment;
import com.example.dean.photoviewer.app.injection.fragment.FragmentComponent;
import com.example.dean.photoviewer.app.ui.photo.PhotoViewModel;
import com.example.dean.photoviewer.app.util.ImageLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhotoFragment extends DaggerFragment implements PhotoFragmentContract.View {

    public static final String PHOTO_KEY = "photo_key";

    @BindView(R.id.tv_photo_description)
    TextView photoDescription;

    @BindView(R.id.tv_author_name)
    TextView authorName;

    @BindView(R.id.tv_photo_created_date)
    TextView photoCreatedDate;

    @BindView(R.id.photo)
    ImageView photo;

    @Inject
    ImageLoader imageLoader;

    @Inject
    PhotoFragmentContract.Presenter presenter;

    public PhotoFragment() {

    }

    public static PhotoFragment newInstance(final String id) {
        final PhotoFragment photoFragment = new PhotoFragment();
        final Bundle args = new Bundle();
        args.putString(PHOTO_KEY, id);
        photoFragment.setArguments(args);
        return photoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_photo_page, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

    @Override
    public void fetchDataSuccess(final PhotoViewModel photoViewModel) {
        bindViews(photoViewModel);
    }

    @Override
    protected void inject(final FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @OnClick(R.id.btn_author_details)
    public void onButtonClicked() {
        final String author = authorName.getText().toString();
        presenter.showAuthorActivity(author);
    }

    private void init() {
        final String id = getArguments().getString(PHOTO_KEY);
        presenter.getImageData(id);
    }

    private void bindViews(final PhotoViewModel photoModel) {
        imageLoader.loadImage(photoModel.getPhotoUrl(), photo);
        photoDescription.setText(photoModel.getDescription());
        photoCreatedDate.setText(photoModel.getDateCreated());
        authorName.setText(photoModel.getAuthor());
    }
}
