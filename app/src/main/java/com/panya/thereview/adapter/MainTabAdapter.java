package com.panya.thereview.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.panya.thereview.model.TabType;

import java.util.List;

/**
 * Created by PanyaN on 4/8/2017 AD.
 */

public class MainTabAdapter extends FragmentStatePagerAdapter {
    private Context context;
    private List<TabType> tabTypes;

    public MainTabAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        this.tabTypes = TabType.TAB_TYPE_LIST;
    }

    @Override
    public int getCount() {
        return tabTypes.size();
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        return context.getString(tabTypes.get(position).getTabName()).toUpperCase();
    }

    @Override
    public Fragment getItem(int position) {
        return tabTypes.get(position).getTabFragment();
    }
}

