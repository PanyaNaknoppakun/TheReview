package com.panya.thereview.presenter;

import com.karumi.rosie.domain.usecase.UseCaseHandler;
import com.karumi.rosie.view.loading.RosiePresenterWithLoading;

/**
 * Created by PanyaN on 4/7/2017 AD.
 */

public class TheReviewPresenter<T extends TheReviewPresenter.View> extends RosiePresenterWithLoading<T> {

    public TheReviewPresenter(UseCaseHandler handler) {
        super(handler);
    }


    public interface View extends RosiePresenterWithLoading.View {

    }
}
