package com.tecmis.database;

import com.tecmis.dto.User;

import java.util.HashMap;

public interface ManageUserInterface {


    boolean updateUser(String username,String accounttype, HashMap<String, String> userdata);

    HashMap<String, String> getUserDetails(String accounttype,String username);

    boolean deleteUser(String accounttype);

    boolean addUser(User userDto);

    boolean updateUser(User userUp);

    boolean deleteUser(User userDel);

}
