package com.panya.thereview.intent;

import android.content.Context;

import com.panya.thereview.common.intent.BaseIntent;
import com.panya.thereview.views.activities.MainActivity;

/**
 * Created by panyanaknoppakun on 7/7/2017 AD.
 */

public class OpenMainActivityIntent extends BaseIntent {

    public OpenMainActivityIntent(Context context) {
        super(context, MainActivity.class);
    }
}
