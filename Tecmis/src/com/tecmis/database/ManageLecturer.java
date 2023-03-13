package com.tecmis.database;

import com.tecmis.dto.LecturerData;
import com.tecmis.dto.User;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;

public class ManageLecturer {
    public static boolean addLecturer(LecturerData lecdata) {
        String query = "Insert INTO Lecturer " +
                       "(ID,username,password,Fname,Lname,Mobile,Address,Age,Email,DOM,Gender,Position) " +
                       "VALUES ( '" + lecdata.getId() + "', '"+lecdata.getUsername()+ "','"+lecdata.getPassword()+ "','" + lecdata.getFirstName() + "', '" + lecdata.getLastName() + "', '" + lecdata.getMobile() + "', '" + lecdata.getAddress() + "','" + lecdata.getAge() + "','" + lecdata.getEmail() + "','" + lecdata.getDom() + "','" + lecdata.getGender() + "','" + lecdata.getPosition() + "')";


        System.out.println(query);
        try {
            Connection connection = Database.getDatabaseConnection();
            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected == 1) {
                // update successful
                System.out.println("user add successfully!! ");
                return true;
            } else {
                // update failed
                System.out.println("user add failed");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;

    }


    public static boolean updateLecturer(LecturerData lecdata){
        String query = "UPDATE Lecturer SET ID='"+ lecdata.getId() +"', username='"+ lecdata.getUsername() +"', password='"+ lecdata.getPassword() +"',"+
                       " Fname='"+ lecdata.getFirstName() +"', Lname='"+ lecdata.getLastName() +"', Mobile='"+ lecdata.getMobile() +"', Address='"+ lecdata.getAddress() +"', "+
                       "Age='"+ lecdata.getAge() +"', Email='"+ lecdata.getEmail() +"', DOM='"+ lecdata.getDom() +"', Gender='" + lecdata.getGender() +"', Position='"+ lecdata.getPosition() +
                       "' WHERE ID='"+ lecdata.getId() +"'";



        System.out.println(query);
        try {
            Connection connection=Database.getDatabaseConnection();
            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected == 1) {
                // update successful
                System.out.println("Record update successfully!! ");
                return true;
            } else {
                // update failed
                System.out.println("Record update failed");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return  false;

    }

    public static boolean deleteLecturer(LecturerData lecdata){
        String query = "DELETE FROM Lecturer WHERE ID='"+lecdata.getId()+"'";

        System.out.println(query);
        try {
            Connection connection=Database.getDatabaseConnection();
            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected == 1) {
                // update successful
                System.out.println("Record delete successfully!! ");
                return true;
            } else {
                // update failed
                System.out.println("Record delete failed");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return  false;

    }

}
