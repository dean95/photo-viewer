package com.example.dean.photoviewer.app.ui.photo.page;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dean.photoviewer.app.ui.photo.PhotoViewModel;

import java.util.List;

public class PhotoFragmentPagerAdapter extends FragmentPagerAdapter {

    private final List<String> photoIds;

    public PhotoFragmentPagerAdapter(final FragmentManager fragmentManager, final List<String> photoIds) {
        super(fragmentManager);

        this.photoIds = photoIds;
    }

    @Override
    public Fragment getItem(final int position) {
        return PhotoFragment.newInstance(photoIds.get(position));
    }

    @Override
    public int getCount() {
        return photoIds.size();
    }
}
