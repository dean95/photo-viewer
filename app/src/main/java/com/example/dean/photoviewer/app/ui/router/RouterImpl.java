package com.example.dean.photoviewer.app.ui.router;

import android.app.Activity;
import android.content.Intent;

import com.example.dean.photoviewer.app.injection.activity.ActivityScope;
import com.example.dean.photoviewer.app.ui.author.AuthorActivity;
import com.example.dean.photoviewer.app.ui.photo.PhotoActivity;

@ActivityScope
public final class RouterImpl implements Router {

    private final Activity activity;

    public RouterImpl(final Activity activity) {
        this.activity = activity;
    }

    @Override
    public void showPhotoActivity() {
        final Intent intent = PhotoActivity.createIntent(activity);
        activity.startActivity(intent);
    }

    @Override
    public void showAuthorActivity(final String authorName) {
        final Intent intent = AuthorActivity.createIntent(activity);
        intent.putExtra(AuthorActivity.AUTHOR_NAME_KEY, authorName);
        activity.startActivity(intent);
    }
}
