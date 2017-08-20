package com.panya.thereview.common.presenter;

import android.support.annotation.NonNull;

import com.panya.thereview.common.rxlifecycle.LifecycleBinder;
import com.panya.thereview.common.view.BaseView;

public abstract class BasePresenter<V extends BaseView> {

    private final V view;
    private final LifecycleBinder lifecycleBinder;

    public BasePresenter(V view, LifecycleBinder lifecycleBinder) {
        this.view = view;
        this.lifecycleBinder = lifecycleBinder;
    }

    @NonNull
    protected V getView() {
        return view;
    }

    @NonNull
    protected LifecycleBinder getLifecycleBinder() {
        return lifecycleBinder;
    }
}
