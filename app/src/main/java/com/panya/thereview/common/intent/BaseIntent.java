package com.panya.thereview.common.intent;

import android.content.Context;
import android.content.Intent;

/**
 * Created by panyanaknoppakun on 7/7/2017 AD.
 */

public class BaseIntent extends Intent {

    protected BaseIntent(Context context, Class<?> cls) {
        super(context, cls);
    }
}
