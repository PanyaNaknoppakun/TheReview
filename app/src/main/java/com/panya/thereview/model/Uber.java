package com.panya.thereview.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by panyanaknoppakun on 7/2/2017 AD.
 */

public class Uber {

    private Intent intent;

    public Uber(Intent intent) {
        this.intent = intent;
    }

    public Uber(Bundle bundle) {
        Intent i = new Intent();
        i.putExtras(bundle);
        intent = i;
    }

    @Nullable
    public Intent getIntent() {
        return intent;
    }
}
