package com.tecmis.database;

import com.tecmis.dto.TechnicalOfficerData;
import com.tecmis.dto.User;

import java.sql.*;

public class ManageTechnicalOfficer extends User {

    static Connection connection=null;
    static PreparedStatement pst=null;
    public static  boolean addTechnicalOfficer(TechnicalOfficerData tecdata){

        String query= "INSERT INTO TechnicalOfficer " +
                      "(ID, username, password, Fname, Lname, Mobile, Address, Age, Email, DOM, Gender) " +
                      "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        System.out.println(query);

        try {

            connection = Database.getDatabaseConnection();
            pst = connection.prepareStatement(query);

            pst.setString(1, tecdata.getId());
            pst.setString(2, tecdata.getUserName());
            pst.setString(3, tecdata.getPassword());
            pst.setString(4, tecdata.getFirstName());
            pst.setString(5, tecdata.getLastName());
            pst.setString(6, tecdata.getMobile());
            pst.setString(7, tecdata.getAddress());
            pst.setString(8, tecdata.getAge());
            pst.setString(9, tecdata.getEmail());
            pst.setString(10,tecdata.getDom());
            pst.setString(11,tecdata.getGender());

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected == 1) {

                System.out.println("Record add successfully!! ");
                return true;
            } else {

                System.out.println("Record add  failed!!");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error in executing query " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error in getting connection" + e.getMessage());
            return false;
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error in closing the connection"+e.getMessage());
            }
        }

    }
    public static boolean updateTechnicalOfficer(TechnicalOfficerData tecdata){

        String query = "UPDATE TechnicalOfficer " +
                       "SET username=?, password=?, Fname=?, Lname=?, Mobile=?, Address=?, Age=?, Email=?, DOM=?, Gender=? " +
                       "WHERE ID=?";


        System.out.println(query);


        try {

           connection = Database.getDatabaseConnection();
           pst = connection.prepareStatement(query);

            pst.setString(1, tecdata.getUserName());
            pst.setString(2, tecdata.getPassword());
            pst.setString(3, tecdata.getFirstName());
            pst.setString(4, tecdata.getLastName());
            pst.setString(5, tecdata.getMobile());
            pst.setString(6, tecdata.getAddress());
            pst.setString(7, tecdata.getAge());
            pst.setString(8, tecdata.getEmail());
            pst.setString(9,tecdata.getDom());
            pst.setString(10,tecdata.getGender());
            pst.setString(11,tecdata.getId());

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected == 1) {

                System.out.println("Record update successfully!! ");
                return true;
            } else {

                System.out.println("Record update  failed!!");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error in executing query " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error in getting connection" + e.getMessage());
            return false;
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error in closing the connection"+e.getMessage());
            }
        }


    }
    public static boolean deleteTechnicalOfficer(TechnicalOfficerData tecdata){

        String query = "DELETE FROM TechnicalOfficer WHERE ID='" + tecdata.getId() + "'";

        System.out.println(query);
        try {
             connection=Database.getDatabaseConnection();
            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected == 1) {
                // update successful
                System.out.println("Record delete successfully!! ");
                return true;
            } else {
                // update failed
                System.out.println("Record delete failed!!");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return  false;
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error in closing the connection"+e.getMessage());
            }
        }

    }
    public static ResultSet searchTechnicalOfficer(TechnicalOfficerData tecdata) {

        String query = "SELECT * FROM TechnicalOfficer WHERE ID='" + tecdata.getId() + "'";

        System.out.println(query);

        try {
            connection = Database.getDatabaseConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            return rs;
        } catch (SQLException e) {
            System.out.println("Error in executing query " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Error in getting connection" + e.getMessage());
            return null;
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error in closing the connection"+e.getMessage());
            }
        }
    }
}

