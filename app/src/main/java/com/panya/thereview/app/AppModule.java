package com.panya.thereview.app;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final TheReviewApplication application;


    public AppModule(TheReviewApplication app) {
        application = app;
    }

    @Provides @Singleton TheReviewApplication provideApp() {
        return application;
    }
}
