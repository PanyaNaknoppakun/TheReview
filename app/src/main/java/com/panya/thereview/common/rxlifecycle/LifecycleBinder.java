package com.panya.thereview.common.rxlifecycle;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import com.trello.rxlifecycle.LifecycleTransformer;

/**
 * Created by panyanaknoppakun on 9/6/2016 AD.
 */
public interface LifecycleBinder {

    @NonNull
    @CheckResult
    <T> LifecycleTransformer<T> bindToLifecycle();
}
