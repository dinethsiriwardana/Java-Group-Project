package com.tecmis.database;

import com.tecmis.dto.User;

import java.util.HashMap;

public interface ManageUserInterface {


    boolean updateUser(String username,String accounttype, HashMap<String, String> userdata);

    HashMap<String, String> getUserDetails(String accounttype,String username);

    boolean deleteUser(String accounttype);

    boolean addUser(User userDto);

    boolean updateUser(User userUp);
    boolean serchUser(User userSea);
    boolean deleteUser(User userDel);
    boolean addStu(User userAdd);
    boolean upStu(User userUp );
    boolean serchStu(User userSea);

    boolean delStu(User userDel);

    boolean addTo(User userDto);
    boolean upTo(User userUp);
    boolean delTo(User userDel);
    boolean serchTo(User userSea);
    boolean addAdm(User userAdd);

    boolean upAdm(User userUp);

    boolean delAdm(User userDel);
    boolean searchAdm(User userSea);

}
