package com.panya.thereview.presenter;

import com.karumi.rosie.domain.usecase.UseCaseHandler;

/**
 * Created by PanyaN on 4/8/2017 AD.
 */

public class MainPresenter extends TheReviewPresenter<MainPresenter.View> {

    public MainPresenter(UseCaseHandler handler) {
        super(handler);
    }

    public interface View extends TheReviewPresenter.View {

        void showDemo();
    }
}
