package com.panya.thereview.fragments;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.navi.component.support.NaviFragment;
import com.trello.rxlifecycle.FragmentLifecycleProvider;
import com.trello.rxlifecycle.navi.NaviLifecycle;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by PanyaN on 4/8/2017 AD.
 */

public class TheReviewBaseFragment extends NaviFragment {

    private final FragmentLifecycleProvider provider = NaviLifecycle.createFragmentLifecycleProvider(this);
    private Unbinder unbinder;

    protected boolean hasOptionMenu() {
        return false;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(hasOptionMenu());
    }

    @LayoutRes
    protected int getFragmentLayoutRes() {
        return 0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = null;
        final int layoutId = getFragmentLayoutRes();
        if (layoutId > 0) {
            root = inflater.inflate(layoutId, container, false);
            unbinder = ButterKnife.bind(this, root);
        }
        return root;
    }

    protected FragmentLifecycleProvider getProvider() {
        return provider;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
