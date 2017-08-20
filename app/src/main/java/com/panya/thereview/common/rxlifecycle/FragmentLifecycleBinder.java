package com.panya.thereview.common.rxlifecycle;

import android.support.annotation.NonNull;

import com.trello.rxlifecycle.FragmentLifecycleProvider;
import com.trello.rxlifecycle.LifecycleTransformer;

/**
 * Created by panyanaknoppakun on 9/6/2016 AD.
 */
public class FragmentLifecycleBinder implements LifecycleBinder {

    private final FragmentLifecycleProvider fragmentLifecycleProvider;


    public FragmentLifecycleBinder(@NonNull FragmentLifecycleProvider provider) {
        fragmentLifecycleProvider = provider;
    }

    @NonNull
    @Override
    public <T> LifecycleTransformer<T> bindToLifecycle() {
        return fragmentLifecycleProvider.bindToLifecycle();
    }
}
