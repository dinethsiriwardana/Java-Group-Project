package com.tecmis.database;

import com.tecmis.dto.LecturerData;
import com.tecmis.dto.User;

import java.sql.Connection;
import java.sql.Statement;

public class ManageLecturer {
    public static boolean addLecturer(LecturerData lecdata){
        String query= "Insert INTO Lecturer " +
                "(ID,Fname,Lname,Mobile,Address,Age,Email,DOM,Gender,Position) " +
                "VALUES ( ' "+lecdata.getId()+ " ', ' "+lecdata.getFirstName()+" ', ' "+lecdata.getLastName()+" ', ' "+lecdata.getMobile()+" ', ' "+lecdata.getAddress()+" ',' "+lecdata.getAge()+" ',' "+lecdata.getEmail()+" ',' "+lecdata.getDom()+" ',' "+lecdata.getGender()+" ',' "+lecdata.getPosition()+" ')";

        System.out.println(query);
        try {
            Connection connection=Database.getDatabaseConnection();
            Statement stmt = connection.createStatement();
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
            System.out.println(e);
        }
        return  false;




    }
}
