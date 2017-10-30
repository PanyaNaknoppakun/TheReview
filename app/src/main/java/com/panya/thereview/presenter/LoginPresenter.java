package com.panya.thereview.presenter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.panya.thereview.common.presenter.BasePresenter;
import com.panya.thereview.common.rxlifecycle.LifecycleBinder;
import com.panya.thereview.views.views.LoginView;

/**
 * Created by PanyaN on 4/9/2017 AD.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    private final String TAG = "LoginPresenter";

    public LoginPresenter(LoginView view, LifecycleBinder lifecycleBinder) {
        super(view, lifecycleBinder);
    }
    public void onGoogleSignInClicked() {
        getView().signIn();
    }

    public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            // User is signed in
            getView().goToMainPage();
        } else {
            // User is signed out
            Log.d("MainActivity", "onAuthStateChanged:signed_out");
        }
    }

    public void onSignInComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
//            getView().goToMainPage();
            getView().showToast("Login Completed");
        } else {
            Log.w(TAG, "signInWithCredential", task.getException());
            getView().showToast("Authentication failed.");
        }
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        getView().showToast(connectionResult.getErrorMessage());
    }

    public void onActivityResultFromGoogleSignIn(Intent data) {
        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
        if (result.isSuccess()) {
            // Google Sign In was successful, authenticate with Firebase
            GoogleSignInAccount account = result.getSignInAccount();
            getView().firebaseAuthWithGoogle(account);
        } else {
            Log.d(TAG, "signInWithCredential, isSuccess false");
            // Google Sign In failed, update UI appropriately
            // ...
        }
    }
}