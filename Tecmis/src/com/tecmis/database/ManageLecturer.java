package com.tecmis.database;

import com.tecmis.dto.LecturerData;
import com.tecmis.dto.User;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

public class ManageLecturer {
    public static boolean addLecturer(LecturerData lecdata) {
        String query = "Insert INTO Lecturer " +

                "(ID,Fname,Lname,Mobile,Address,Age,Email,DOM,Gender,Position) " +
                "VALUES ( ' " +
                lecdata.getId() + " ', ' " +
                lecdata.getFirstName() + " ', ' " +
                lecdata.getLastName() + " ', ' " +
                lecdata.getMobile() + " ', ' " +
                lecdata.getAddress() + " ',' " +
                lecdata.getAge() + " ',' " +
                lecdata.getEmail() + " ',' " +
                lecdata.getDom() + " ',' " +
                lecdata.getGender() + " ',' " +
                lecdata.getPosition() + " ')";



        System.out.println(query);
        try {
            Connection connection = Database.getDatabaseConnection();
            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected == 1) {
                // update successful
                System.out.println("Update successfully!! ");
                return true;
            } else {
                // update failed
                System.out.println("update failed");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;

    }

    public static boolean updateLecturer(LecturerData lecdata){


        String query = "UPDATE Lecturer SET id='" +
                lecdata.getId() + "', firstName='" +
                lecdata.getFirstName() + "', lastName='" +
                lecdata.getLastName() + "', mobile='" +
                lecdata.getMobile() + "', address='" +
                lecdata.getAddress() + "', age='" +
                lecdata.getAge() + "', email='" +
                lecdata.getEmail() + "', dom='" +
                lecdata.getDom() + "', gender='" +
                lecdata.getGender() + "', position='" +
                lecdata.getPosition() +
                "' WHERE id='" + lecdata.getId() + "'";


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
        String query = "DELETE FROM Lecturer WHERE ID='" + lecdata.getId() + "'";

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
