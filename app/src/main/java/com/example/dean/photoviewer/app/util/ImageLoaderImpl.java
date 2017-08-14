package com.example.dean.photoviewer.app.util;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageLoaderImpl implements ImageLoader {

    private final Context context;

    public ImageLoaderImpl(final Context context) {
        this.context = context;
    }

    @Override
    public void loadImage(final String url, final ImageView imageView) {
        Picasso.with(context)
                .load(url)
                .into(imageView);
    }
}
