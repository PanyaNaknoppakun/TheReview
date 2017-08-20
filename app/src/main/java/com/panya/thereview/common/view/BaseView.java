package com.panya.thereview.common.view;

import com.panya.thereview.model.Uber;

/**
 * Created by panyanaknoppakun on 7/2/2017 AD.
 */

public interface BaseView {
    Uber getUber();

    void showProgressDialog();

    void dismissProgressDialog();
}
