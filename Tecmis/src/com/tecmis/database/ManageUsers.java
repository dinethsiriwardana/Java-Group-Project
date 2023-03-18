package com.tecmis.database;

import com.tecmis.ui.lecture.LectureEditUser;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;

public class ManageUsers implements  ManageUserInterface{

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
            Database database = new Database();
            Connection conn = database.getDatabaseConnection();
            String query = "UPDATE " + accounttype + " SET ";
            for (String key : userdata.keySet()) {
                query += key + " = '" + userdata.get(key) + "', ";
            }
            query = query.substring(0, query.length() - 2); // remove last comma and space
            query += " WHERE username = '" + username + "'";
            System.out.println(query);
            Statement stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(query);
            URL imageUrl = LectureEditUser.class.getResource("/com/tecmis/assets/fac_logo.png");
            Icon icon = new ImageIcon(imageUrl);

            if (rowsAffected == 1) {
                // update successful
                System.out.println("User details updated successfully");
                JOptionPane.showMessageDialog(null, "User details updated successfully", "Update Details", JOptionPane.ERROR_MESSAGE, icon);
                return true;
            } else {
                // update failed
                JOptionPane.showMessageDialog(null, "User details updated unsuccessfully", "Error", JOptionPane.INFORMATION_MESSAGE, icon);
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
            Database database = new Database();
            Connection conn = database.getDatabaseConnection();
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


