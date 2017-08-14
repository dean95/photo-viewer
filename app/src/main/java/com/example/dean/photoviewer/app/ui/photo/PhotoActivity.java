package com.example.dean.photoviewer.app.ui.photo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dean.photoviewer.R;
import com.example.dean.photoviewer.app.injection.activity.ActivityComponent;
import com.example.dean.photoviewer.app.injection.activity.DaggerActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhotoActivity extends DaggerActivity implements PhotoContract.View {

    @BindView(R.id.photo_view_pager)
    ViewPager photoViewPager;

    @Inject
    PhotoContract.Presenter presenter;

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
    public void fetchPhotoDataSuccess(final List<PhotoViewModel> photoViewModels) {
        photoViewPager.setAdapter(new PhotoFragmentPagerAdapter(getSupportFragmentManager(), photoViewModels));
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
