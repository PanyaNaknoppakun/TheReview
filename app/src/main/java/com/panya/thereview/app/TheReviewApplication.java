package com.panya.thereview.app;

import android.app.Application;


/**
 * Created by PanyaN on 4/7/2017 AD.
 */

public class TheReviewApplication extends Application {

    private static TheReviewApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        initFabric();
        INSTANCE = initApp();

    }

    public static TheReviewApplication get() {
        return INSTANCE;
    }


    protected TheReviewApplication initApp() {
        return this;
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

}