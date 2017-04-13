package com.panya.thereview.app;

import android.app.Application;


import com.panya.thereview.presenter.DaggerPresenterComponent;
import com.panya.thereview.presenter.PresenterComponent;


/**
 * Created by PanyaN on 4/7/2017 AD.
 */

public class TheReviewApplication extends Application {

    private AppComponent appComponent;
    private PresenterComponent presenterComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        initFabric();
        initDagger();
    }

    private void initFabric() {
//        Crashlytics crashlytics = new Crashlytics.Builder()
//                .core(new CrashlyticsCore.Builder()
//                        .build())
//                .build();
//
//        Fabric fabric = new Fabric.Builder(this)
//                .kits(crashlytics)
//                .debuggable(true)
//                .build();
//
//        Fabric.with(fabric);
//
//        Timber.plant(new CrashlyticsTree());
//
//        Crashlytics.setString(CrashlyticsKey.GIT_SHA, BuildConfig.GIT_SHA);
    }

    private void initDagger() {
        appComponent = DaggerAppComponent.builder()
                .build();
        presenterComponent = DaggerPresenterComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public PresenterComponent getPresenterComponent() {
        return presenterComponent;
    }
}