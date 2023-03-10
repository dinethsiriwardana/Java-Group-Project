package com.tecmis.database;

import java.util.HashMap;

public interface ManageUserInterface {

    boolean addUser(String accounttype);
    boolean updateUser(String username,String accounttype, HashMap<String, String> userdata);

    HashMap<String, String> getUserDetails(String accounttype,String username);

    boolean deleteUser(String accounttype);
}
