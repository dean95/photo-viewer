package com.example.dean.photoviewer.app.ui.photo;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dean.photoviewer.R;
import com.example.dean.photoviewer.app.injection.activity.ActivityComponent;
import com.example.dean.photoviewer.app.injection.activity.DaggerActivity;
import com.example.dean.photoviewer.app.ui.photo.page.PhotoFragmentPagerAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoActivity extends DaggerActivity implements PhotoActivityContract.View {

    @BindView(R.id.photo_view_pager)
    ViewPager photoViewPager;

    @Inject
    PhotoActivityContract.Presenter presenter;

    public static Intent createIntent(final Activity activity) {
        return new Intent(activity, PhotoActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        init();
    }

    @Override
    protected void inject(final ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    public void fetchPhotoDataSuccess(final List<String> photoIds) {
        photoViewPager.setAdapter(new PhotoFragmentPagerAdapter(getSupportFragmentManager(), photoIds));
    }

    @Override
    public void fetchPhotoDataFail() {
        Toast.makeText(this, "fetchPhotoDataFail", Toast.LENGTH_SHORT).show();
    }

    private void init() {
        ButterKnife.bind(this);

        presenter.getPhotoData();
    }
}
