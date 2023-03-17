package com.tecmis.database;

public class Auth {
    private static Auth instance;
    private String username;

    private Auth() {
        // Private constructor to prevent external instantiation
    }

    public static Auth getInstance() {
        if (instance == null) {
            instance = new Auth();
        }
        return instance;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}