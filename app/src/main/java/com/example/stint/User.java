package com.example.stint;

import android.widget.TextView;

public class User {
    String Fullname, UserEmail, TimeIn, TimeOut;

    public User() {
    }

    public User(String fullName, String userEmail, String timeOut, String timeIn) {
        this.Fullname = fullName;
        this.UserEmail = userEmail;
        this.TimeIn = timeIn;
        this.TimeOut = timeOut;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullName) {
        Fullname = fullName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserName(String userEmail) {
        UserEmail = userEmail;
    }

    public String getTimeIn() {
        return TimeIn;
    }

    public void setTimeIn(String timeIn) {
        TimeIn = timeIn;
    }

    public String getTimeOut() {
        return TimeOut;
    }

    public void setTimeOut(String timeOut) {
        TimeOut = timeOut;
    }
}

