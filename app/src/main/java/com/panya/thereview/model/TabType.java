package com.panya.thereview.model;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.panya.thereview.R;
import com.panya.thereview.common.fragments.TheReviewBaseFragment;
import com.panya.thereview.views.fragments.HomeFragment;
import com.panya.thereview.views.fragments.ProfileFragment;
import com.panya.thereview.views.fragments.SubscriptionFragment;
import com.panya.thereview.views.fragments.TrendFragment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by PanyaN on 4/8/2017 AD.
 */

public enum TabType {
    UNKNOWN("unknown", R.string.app_name, R.mipmap.ic_launcher, null),
    HOME("home", R.string.tab_home, R.mipmap.ic_launcher, HomeFragment.newInstance()),
    TREND("trend", R.string.tab_trend, R.mipmap.ic_launcher, TrendFragment.newInstance()),
    SUBSCRIPTION("subscription", R.string.tab_subscription, R.mipmap.ic_launcher, SubscriptionFragment.newInstance()),
    PROFILE("profile", R.string.tab_profile, R.mipmap.ic_launcher, ProfileFragment.newInstance());

    public static final List<TabType> TAB_TYPE_LIST = Arrays.asList(
            HOME,
            TREND,
            SUBSCRIPTION,
            PROFILE
    );

    private final String key;
    @StringRes
    private int tabName;
    @DrawableRes
    private int icon;

    private TheReviewBaseFragment fragment;

    TabType(@NonNull final String key, @StringRes final int tabName, @DrawableRes final int icon, final TheReviewBaseFragment fragment) {
        this.key = key;
        this.tabName = tabName;
        this.icon = icon;
        this.fragment = fragment;
    }

    public TheReviewBaseFragment getTabFragment() {
        return this.fragment;
    }

    @StringRes
    public int getTabName() {
        return tabName;
    }
}

