package com.panya.thereview.views.views;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.panya.thereview.common.view.BaseView;

/**
 * Created by panyanaknoppakun on 7/2/2017 AD.
 */

public interface LoginView extends BaseView {
    void goToMainPage();
    void showToast(String msg);
    void signIn();
    void firebaseAuthWithGoogle(GoogleSignInAccount account);
}
