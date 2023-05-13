package com.tecmis.database;

import com.tecmis.dto.LecturerData;
import com.tecmis.dto.StudentData;
import com.tecmis.dto.User;

import javax.swing.*;
import java.sql.*;
import java.util.HashMap;

public class ManageLecturer {


    public static boolean addLecturer(LecturerData lecdata) {

        String query = "INSERT INTO Lecturer" +
                      "(ID, username, password, Fname, Lname, Mobile, Address, Age, Email, DOM, Gender, Position) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        System.out.println(query);

        try {

            Connection connection = Database.getDatabaseConnection();
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, lecdata.getId());
            pst.setString(2, lecdata.getUsername());
            pst.setString(3, lecdata.getPassword());
            pst.setString(4, lecdata.getFirstName());
            pst.setString(5, lecdata.getLastName());
            pst.setString(6, lecdata.getMobile());
            pst.setString(7, lecdata.getAddress());
            pst.setString(8, lecdata.getAge());
            pst.setString(9, lecdata.getEmail());
            pst.setString(10, lecdata.getDom());
            pst.setString(11, lecdata.getGender());
            pst.setString(12, lecdata.getPosition());


            int rowsAffected = pst.executeUpdate();

            if (rowsAffected == 1) {
                //add successfull
                System.out.println("Record add successfully!! ");
                return true;
            } else {
                //add failed
                System.out.println("Record add  failed!!");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error in executing query " + e.getMessage());
            return false;
        } catch (Exception e) {

            System.out.println( e.getMessage());
            return false;
        }
    }


    public static boolean updateLecturer(LecturerData lecdata) {

        String query = "UPDATE Lecturer SET  username=?, password=?, Fname=?, Lname=?, " +
                "Mobile=?, Address=?, Age=?, Email=?, DOM=?, Gender=?, Position=? WHERE ID=?";


        System.out.println(query);
        try {
            Connection connection = Database.getDatabaseConnection();
            PreparedStatement pst = connection.prepareStatement(query);

                pst.setString(1, lecdata.getUsername());
                pst.setString(2, lecdata.getPassword());
                pst.setString(3, lecdata.getFirstName());
                pst.setString(4, lecdata.getLastName());
                pst.setString(5, lecdata.getMobile());
                pst.setString(6, lecdata.getAddress());
                pst.setString(7, lecdata.getAge());
                pst.setString(8, lecdata.getEmail());
                pst.setString(9, lecdata.getDom());
                pst.setString(10, lecdata.getGender());
                pst.setString(11, lecdata.getPosition());
                pst.setString(12,lecdata.getId());

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected == 1) {
                    //update successfull
                    System.out.println("Record update successfully!! ");
                    return true;

                } else {
                    //update failed
                    System.out.println("Record update  failed!!");
                    return false;
                }
        }catch (SQLException e) {
            System.out.println("Error in executing query " + e.getMessage());
            return false;

        } catch (Exception e) {
            System.out.println("Error in getting connection"+e.getMessage());
            return false;
        }
    }

    public static boolean deleteLecturer(LecturerData lecdata) {

        String query = "DELETE FROM Lecturer WHERE ID='" + lecdata.getId() + "'";

        System.out.println(query);

        try {
            Connection connection = Database.getDatabaseConnection();
            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected == 1) {
                // delete successful
                System.out.println("Record delete successfully!! ");
                return true;
            } else {
                // delete failed
                System.out.println("Record delete failed");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error in getting connection" + e.getMessage());
            return false;
        }


    }

    public static ResultSet searchLecturer(LecturerData lecdata) {
        String query = "SELECT * FROM Lecturer WHERE ID='" + lecdata.getId() + "'";
        System.out.println(query);
        try {
            Connection connection = Database.getDatabaseConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            return rs;

        } catch (SQLException e) {
            System.out.println("Error searching search record: " + e.getMessage());
           return null;
        } catch (Exception e) {
            System.out.println("Error in getting connection" + e.getMessage());
           return null;
        }
    }
}

