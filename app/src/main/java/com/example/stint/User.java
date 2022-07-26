package com.example.stint;

import android.widget.TextView;

public class User  {
    String FullName, UserEmail;
    public User(){}

    public User(String fullName, String userEmail, long timein, long timeOut) {
        this.FullName = fullName;
        this.UserEmail = userEmail;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserName(String userEmail) {
        UserEmail = userEmail;
    }
}
