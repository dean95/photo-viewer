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

    private PhotoViewModel photoModel;

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

    public static PhotoFragment newInstance(final PhotoViewModel photo) {
        final PhotoFragment photoFragment = new PhotoFragment();
        final Bundle args = new Bundle();
        args.putParcelable(PHOTO_KEY, photo);
        photoFragment.setArguments(args);
        return photoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_photo_page, container, false);
        ButterKnife.bind(this, view);

        photoModel = getArguments().getParcelable(PHOTO_KEY);
        bindViews();

        return view;
    }

    @Override
    protected void inject(final FragmentComponent fragmentComponent) {
        fragmentComponent.inject(this);
    }

    @OnClick(R.id.btn_author_details)
    public void onButtonClicked() {
        presenter.showAuthorActivity();
    }

    private void bindViews() {
        imageLoader.loadImage(photoModel.getPhotoUrl(), photo);
        photoDescription.setText(photoModel.getDescription());
        photoCreatedDate.setText(photoModel.getDateCreated());
        authorName.setText(photoModel.getAuthor());
    }
}
