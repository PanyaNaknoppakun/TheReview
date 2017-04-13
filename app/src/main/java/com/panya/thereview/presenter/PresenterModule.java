package com.panya.thereview.presenter;

import com.karumi.rosie.domain.usecase.UseCaseHandler;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    MainPresenter provideMainPresenter(UseCaseHandler handler) {
        return new MainPresenter(handler);
    }

//    @Provides
//    PhotoPresenter providePhotoPresenter(UseCaseHandler handler, GetPhotosInCategory useCase) {
//        return new PhotoPresenter(handler, useCase);
//    }
}
