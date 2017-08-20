package com.panya.thereview.common.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.panya.thereview.R;
import com.panya.thereview.app.TheReviewApplication;
import com.panya.thereview.common.view.BaseView;
import com.panya.thereview.model.Uber;
import com.trello.rxlifecycle.ActivityLifecycleProvider;
import com.trello.rxlifecycle.navi.NaviLifecycle;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PanyaN on 4/7/2017 AD.
 */

public abstract class TheReviewBaseActivity extends TheReviewAppCompatActivity implements BaseView {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ProgressDialog progressDialog;

    private final ActivityLifecycleProvider provider = NaviLifecycle.createActivityLifecycleProvider(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int activityLayout = getActivityLayout();
        if (activityLayout > 0) {
            setContentView(activityLayout);
            ButterKnife.bind(this);

            if (toolbar != null) {
                setSupportActionBar(toolbar);
                final ActionBar actionBar = getSupportActionBar();
                if (actionBar != null) {
                    setupSupportActionBar(actionBar);
                }
            }
        }

        onPreparePresenter();
    }

    @LayoutRes
    protected abstract int getActivityLayout();

    protected void setupSupportActionBar(@NonNull ActionBar actionBar) {}

    protected void onPreparePresenter() {}

    @NonNull
    protected TheReviewApplication getApp() {
        return (TheReviewApplication) getApplication();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int itemId = item.getItemId();
        if (android.R.id.home == itemId) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public ActivityLifecycleProvider getProvider() {
        return provider;
    }

    @Override
    public Uber getUber() {
        return new Uber(getIntent());
    }

    @Override
    public void showProgressDialog() {
        if (progressDialog != null && !progressDialog.isShowing()) {
            progressDialog.show();
        } else if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setTitle(getString(R.string.general_please_wait));
            progressDialog.setMessage(getString(R.string.general_processing));
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    }

    @Override
    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}