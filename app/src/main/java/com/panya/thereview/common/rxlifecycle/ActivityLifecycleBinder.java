package com.panya.thereview.common.rxlifecycle;

import android.support.annotation.NonNull;

import com.trello.rxlifecycle.ActivityLifecycleProvider;
import com.trello.rxlifecycle.LifecycleTransformer;

/**
 * Created by panyanaknoppakun on 9/6/2016 AD.
 */
public class ActivityLifecycleBinder implements LifecycleBinder {

    private final ActivityLifecycleProvider activityLifecycleProvider;


    public ActivityLifecycleBinder(@NonNull ActivityLifecycleProvider provider) {
        activityLifecycleProvider = provider;
    }

    @NonNull
    @Override
    public <T> LifecycleTransformer<T> bindToLifecycle() {
        return activityLifecycleProvider.bindToLifecycle();
    }
}
