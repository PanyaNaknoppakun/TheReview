package com.panya.thereview.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.panya.thereview.R;
import com.panya.thereview.common.activities.TheReviewBaseActivity;
import com.panya.thereview.common.rxlifecycle.ActivityLifecycleBinder;
import com.panya.thereview.intent.OpenMainActivityIntent;
import com.panya.thereview.presenter.LoginPresenter;
import com.panya.thereview.views.views.LoginView;

import butterknife.BindView;
import butterknife.OnClick;
import timber.log.Timber;

/**
 * Created by PanyaN on 4/8/2017 AD.
 */

public class LoginActivity extends TheReviewBaseActivity implements LoginView {

    @BindView(R.id.sign_in_button)
    SignInButton signInButton;

    private LoginPresenter loginPresenter;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private GoogleSignInOptions gso;
    private GoogleApiClient mGoogleApiClient;
    private final int RC_SIGN_IN = 1235;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("LoginActivity onCreate");
        loginPresenter = new LoginPresenter(this, new ActivityLifecycleBinder(getProvider()));
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                loginPresenter.onAuthStateChanged(firebaseAuth);
            }
        };

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, onConnectionFailedListener)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            loginPresenter.onActivityResultFromGoogleSignIn(data);
        }
    }

    @OnClick(R.id.sign_in_button)
    public void onClickGoogleSignInButton() {
        loginPresenter.onGoogleSignInClicked();
    }

    @Override
    public void goToMainPage() {
        Timber.d("LoginActivity goToMainPage");
        OpenMainActivityIntent intent = new OpenMainActivityIntent(this);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        loginPresenter.onSignInComplete(task);
                    }
                })
        .addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Timber.e(e, e.getMessage());
            }
        });
    }

    @Override
    public void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = new GoogleApiClient.OnConnectionFailedListener() {
        @Override
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            loginPresenter.onConnectionFailed(connectionResult);
        }
    };

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
