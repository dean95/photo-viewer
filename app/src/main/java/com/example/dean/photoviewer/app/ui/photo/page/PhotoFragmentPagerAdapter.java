package com.example.dean.photoviewer.app.ui.photo.page;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dean.photoviewer.app.ui.photo.PhotoViewModel;

import java.util.List;

public class PhotoFragmentPagerAdapter extends FragmentPagerAdapter {

    private final List<PhotoViewModel> photos;

    public PhotoFragmentPagerAdapter(final FragmentManager fragmentManager, final List<PhotoViewModel> photos) {
        super(fragmentManager);

        this.photos = photos;
    }

    @Override
    public Fragment getItem(final int position) {
        return PhotoFragment.newInstance(photos.get(position));
    }

    @Override
    public int getCount() {
        return photos.size();
    }
}
