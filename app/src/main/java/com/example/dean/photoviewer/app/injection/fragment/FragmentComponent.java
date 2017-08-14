package com.example.dean.photoviewer.app.injection.fragment;

import com.example.dean.photoviewer.app.injection.activity.ActivityComponent;

import dagger.Component;

@FragmentScope
@Component(
        dependencies = {
                ActivityComponent.class
        }
)
public interface FragmentComponent extends FragmentComponentInjects {

    final class Initializer {

        static public FragmentComponent init(final DaggerFragment fragment, final ActivityComponent activityComponent) {
            return DaggerFragmentComponent.builder()
                                          .activityComponent(activityComponent)
                                          .build();
        }

        private Initializer() {

        }
    }
}
