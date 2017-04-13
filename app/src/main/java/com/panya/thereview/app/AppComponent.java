package com.panya.thereview.app;
import com.panya.thereview.api.ApiComponent;
import com.panya.thereview.api.ApiModule;
import com.panya.thereview.domain.RosieAndroidModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApiModule.class,
        AppModule.class,
        RosieAndroidModule.class
})
public interface AppComponent extends ApiComponent {
}
