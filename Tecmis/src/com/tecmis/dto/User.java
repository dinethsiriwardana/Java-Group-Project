package com.tecmis.dto;

public class User {

    //create user class for  check the user account type in ManageUsers class
    public String getUserAccountType() {
        return userAccountType;
    }

    public void setUserAccountType(String userAccountType) {
        this.userAccountType = userAccountType;
    }

    protected String userAccountType;

}

