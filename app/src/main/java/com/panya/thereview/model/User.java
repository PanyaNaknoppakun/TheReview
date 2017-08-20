package com.panya.thereview.model;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by panyanaknoppakun on 7/12/2017 AD.
 */

@IgnoreExtraProperties
public class User {
    public String userName;
    public String email;

    public User() {

    }

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
