package com.panya.thereview.fragments;

import android.os.Bundle;

import com.panya.thereview.R;

/**
 * Created by PanyaN on 4/8/2017 AD.
 */

public class ProfileFragment extends TheReviewBaseFragment {


    public static SubscriptionFragment newInstance() {
        Bundle args = new Bundle();
        SubscriptionFragment fragment = new SubscriptionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getFragmentLayoutRes() {
        return R.layout.fragment_profile;
    }
}
