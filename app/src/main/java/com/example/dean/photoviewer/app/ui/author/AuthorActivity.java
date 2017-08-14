package com.example.dean.photoviewer.app.ui.author;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.dean.photoviewer.R;
import com.example.dean.photoviewer.app.injection.activity.ActivityComponent;
import com.example.dean.photoviewer.app.injection.activity.DaggerActivity;

public class AuthorActivity extends DaggerActivity implements AuthorContract.View {

    public static Intent createIntent(final Activity activity) {
        return new Intent(activity, AuthorActivity.class);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
    }

    @Override
    protected void inject(final ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }
}
