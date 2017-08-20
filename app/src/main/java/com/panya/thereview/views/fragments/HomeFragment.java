package com.panya.thereview.views.fragments;

import android.os.Bundle;

import com.panya.thereview.R;
import com.panya.thereview.common.fragments.TheReviewBaseFragment;

/**
 * Created by PanyaN on 4/8/2017 AD.
 */

public class HomeFragment extends TheReviewBaseFragment {


    public static SubscriptionFragment newInstance() {
        Bundle args = new Bundle();
        SubscriptionFragment fragment = new SubscriptionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getFragmentLayoutRes() {
        return R.layout.fragment_home;
    }
}
