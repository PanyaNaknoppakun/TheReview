package com.panya.thereview.views.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.panya.thereview.R;
import com.panya.thereview.adapter.MainTabAdapter;
import com.panya.thereview.common.activities.TheReviewBaseActivity;
import com.panya.thereview.common.rxlifecycle.ActivityLifecycleBinder;
import com.panya.thereview.presenter.MainPresenter;
import com.panya.thereview.views.views.MainView;

import butterknife.BindView;

public class MainActivity extends TheReviewBaseActivity implements MainView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.tabs)
    TabLayout tabs;

    MainPresenter presenter;
    MainTabAdapter mainTabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter(this, new ActivityLifecycleBinder(getProvider()));
        initView();
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_main;
    }

    private void initView() {
        mainTabAdapter = new MainTabAdapter(getSupportFragmentManager(), this);
        pager.setAdapter(mainTabAdapter);
        tabs.setTabMode(TabLayout.MODE_FIXED);
        tabs.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
