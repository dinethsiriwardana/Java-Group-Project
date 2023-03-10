package com.tecmis.database;

import java.sql.*;
import java.util.HashMap;

public class ManageUsers extends Database implements  ManageUserInterface{

    private String username;


public ManageUsers(String username){


    this.username = username;
}


    @Override
    public boolean addUser(String accounttype) {
        return false;
    }

    @Override
    public boolean updateUser(String username,String accounttype, HashMap<String, String> userdata) {

        try {
            String query = "UPDATE " + accounttype + " SET ";
            for (String key : userdata.keySet()) {
                query += key + " = '" + userdata.get(key) + "', ";
            }
            query = query.substring(0, query.length() - 2); // remove last comma and space
            query += " WHERE username = '" + username + "'";
            System.out.println(query);
            Statement stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(query);
            if (rowsAffected == 1) {
                // update successful
                System.out.println("update successful");
                return true;
            } else {
                // update failed
                System.out.println("update failed");
                return false;
            }
        } catch (Exception e) {
            // handle exception
            return false;
        }

    }

    public HashMap<String, String> getUserDetails(String username, String accounttype) {
        HashMap<String, String> userdata = new HashMap<String, String>();

        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Lecturer WHERE username = " + "'"+username + "'";
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = rs.getString(i);
                    userdata.put(columnName, columnValue);
                }
            }
            return userdata;
        }catch (Exception e){
            userdata.put("Error", e.getMessage().toString());
            return userdata;
        }

    }

    @Override
    public boolean deleteUser(String accounttype) {
        return false;
    }



}


