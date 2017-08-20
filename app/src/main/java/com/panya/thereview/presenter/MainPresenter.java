package com.panya.thereview.presenter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.panya.thereview.common.presenter.BasePresenter;
import com.panya.thereview.common.rxlifecycle.LifecycleBinder;
import com.panya.thereview.model.User;
import com.panya.thereview.views.views.MainView;

/**
 * Created by PanyaN on 4/8/2017 AD.
 */

public class MainPresenter extends BasePresenter<MainView> {


    public MainPresenter(MainView view, LifecycleBinder lifecycleBinder) {
        super(view, lifecycleBinder);
        getInit();
    }

    public void getInit() {
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        FirebaseAuth auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            FirebaseUser firebaseUser = auth.getCurrentUser();
            String uid = firebaseUser.getUid();
            String name = firebaseUser.getDisplayName();
            String email = firebaseUser.getEmail();
            User user = new User(name, email);
            rootRef.child("user").child(uid).setValue(user);
        }

    }
}
