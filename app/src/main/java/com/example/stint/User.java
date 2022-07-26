package com.example.stint;

public class User  {
    String FullName, UserEmail;

    public User(){}

    public User(String fullName, String userEmail) {
        FullName = fullName;
        UserEmail = userEmail;
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
