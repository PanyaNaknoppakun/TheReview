package com.panya.thereview.presenter;


import com.panya.thereview.activities.MainActivity;
import com.panya.thereview.api.ApiModule;
import com.panya.thereview.app.AppModule;
import com.panya.thereview.domain.RosieAndroidModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApiModule.class,
        AppModule.class,
        PresenterModule.class,
        RosieAndroidModule.class
})
public interface PresenterComponent {

    void inject(MainActivity activity);
//    void inject(PhotoListActivity activity);
}
