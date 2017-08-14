package com.example.dean.photoviewer.app.injection.application;

import com.example.dean.photoviewer.app.application.PhotoViewerApplication;
import com.example.dean.photoviewer.app.injection.application.module.ApplicationModule;
import com.example.dean.photoviewer.app.injection.application.module.DataModule;
import com.example.dean.photoviewer.app.injection.application.module.MappersModule;
import com.example.dean.photoviewer.app.injection.application.module.ThreadingModule;
import com.example.dean.photoviewer.app.injection.application.module.UseCaseModule;
import com.example.dean.photoviewer.app.injection.application.module.UtilsModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                DataModule.class,
                MappersModule.class,
                ThreadingModule.class,
                UseCaseModule.class,
                UtilsModule.class
        }
)
public interface ApplicationComponent extends ApplicationComponentExposes, ApplicationComponentInjects {

    final class Initializer {

        static public ApplicationComponent init(final PhotoViewerApplication application) {
            return DaggerApplicationComponent.builder()
                                             .applicationModule(new ApplicationModule(application))
                                             .dataModule(new DataModule(application))
                                             .mappersModule(new MappersModule())
                                             .threadingModule(new ThreadingModule())
                                             .useCaseModule(new UseCaseModule())
                                             .build();
        }

        private Initializer() {

        }
    }
}
