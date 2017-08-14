package com.example.dean.photoviewer.app.injection.application;

import com.example.dean.photoviewer.app.injection.application.module.ApplicationModule;
import com.example.dean.photoviewer.app.injection.application.module.DataModule;
import com.example.dean.photoviewer.app.injection.application.module.MappersModule;
import com.example.dean.photoviewer.app.injection.application.module.ThreadingModule;
import com.example.dean.photoviewer.app.injection.application.module.UseCaseModule;
import com.example.dean.photoviewer.app.injection.application.module.UtilsModule;

public interface ApplicationComponentExposes extends ApplicationModule.Exposes,
                                                     DataModule.Exposes,
                                                     MappersModule.Exposes,
                                                     ThreadingModule.Exposes,
                                                     UseCaseModule.Exposes,
                                                     UtilsModule.Exposes {
}
