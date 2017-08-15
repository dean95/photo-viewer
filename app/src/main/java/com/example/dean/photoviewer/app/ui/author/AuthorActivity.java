package com.example.dean.photoviewer.app.ui.author;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dean.photoviewer.R;
import com.example.dean.photoviewer.app.injection.activity.ActivityComponent;
import com.example.dean.photoviewer.app.injection.activity.DaggerActivity;
import com.example.dean.photoviewer.app.util.ImageLoader;
import com.example.dean.photoviewer.domain.model.Photo;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AuthorActivity extends DaggerActivity implements AuthorContract.View {

    public static final String AUTHOR_NAME_KEY = "author_name_key";

    @BindView(R.id.iv_profile_picture)
    ImageView profilePicture;

    @BindView(R.id.tv_name)
    TextView authorName;

    @BindView(R.id.tv_portfolio_url)
    TextView portfolioUrl;

    @BindView(R.id.iv_photo1)
    ImageView photo1;

    @BindView(R.id.iv_photo2)
    ImageView photo2;

    @BindView(R.id.iv_photo3)
    ImageView photo3;

    @BindView(R.id.iv_photo4)
    ImageView photo4;

    @BindView(R.id.iv_photo5)
    ImageView photo5;

    @Inject
    AuthorContract.Presenter presenter;

    @Inject
    ImageLoader imageLoader;

    public static Intent createIntent(final Activity activity) {
        return new Intent(activity, AuthorActivity.class);
    }

    @Override
    public void renderUserData(final AuthorViewModel user) {
        imageLoader.loadImage(user.getProfileImageUrl(), profilePicture);
        authorName.setText(user.getName());
        portfolioUrl.setText(user.getPortfolioUrl());

        presenter.getAuthorPhotos(user.getUsername());
    }

    @Override
    public void renderUserPhotos(final List<Photo> photo) {
        imageLoader.loadImage(photo.get(0).getPhotoUrl(), photo1);
        imageLoader.loadImage(photo.get(1).getPhotoUrl(), photo2);
        imageLoader.loadImage(photo.get(2).getPhotoUrl(), photo3);
        imageLoader.loadImage(photo.get(3).getPhotoUrl(), photo4);
        imageLoader.loadImage(photo.get(4).getPhotoUrl(), photo5);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        init();
    }

    @Override
    protected void inject(final ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    private void init() {
        ButterKnife.bind(this);

        final String authorName = getIntent().getStringExtra(AUTHOR_NAME_KEY);
        presenter.getAuthorData(authorName);
    }

    @OnClick({R.id.iv_photo1, R.id.iv_photo2, R.id.iv_photo3, R.id.iv_photo4, R.id.iv_photo5})
    public void onImageClick() {
        presenter.showPhotoActivity();
    }
}
