package com.tecmis.database;

import com.tecmis.dto.TechnicalOfficerData;
import com.tecmis.dto.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManageTechnicalOfficer extends User {

    public static  boolean addTechnicalOfficer(TechnicalOfficerData tecdata){

        String query= "INSERT INTO TechnicalOfficer " +
                      "(ID, username, password, Fname, Lname, Mobile, Address, Age, Email, DOM, Gender) " +
                      "VALUES ('" + tecdata.getId() + "', '" + tecdata.getUserName() + "', '" + tecdata.getPassword() + "', '" +
                      tecdata.getFirstName() + "', '" + tecdata.getLastName() + "', '" + tecdata.getMobile() + "', '" +
                      tecdata.getAddress() + "', '" + tecdata.getAge() + "', '" + tecdata.getEmail() + "', '" +
                      tecdata.getDom() + "', '" + tecdata.getGender() + "' )";

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
                System.out.println("user add  failed");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;

    }
    public static boolean updateTechnicalOfficer(TechnicalOfficerData tecdata){
        String query = "UPDATE TechnicalOfficer SET ID='" + tecdata.getId() + "', username='" + tecdata.getUserName() + "', " +
                "password='" + tecdata.getPassword() + "', Fname='" + tecdata.getFirstName() + "', Lname='" + tecdata.getLastName() + "', " +
                "Mobile='" + tecdata.getMobile() + "', Address='" + tecdata.getAddress() + "', Age='" + tecdata.getAge() + "', Email='" +
                tecdata.getEmail() + "', DOM='" + tecdata.getDom() + "', Gender='" + tecdata.getGender() + "' " +
                "WHERE ID='" + tecdata.getId() + "'";


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
    public static boolean deleteTechnicalOfficer(TechnicalOfficerData tecdata){
        String query = "DELETE FROM TechnicalOfficer WHERE ID='" + tecdata.getId() + "'";

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
    public static boolean searchTechnicalOfficer(TechnicalOfficerData tecdata){
        String query="SELECT * FROM TechnicalOfficer WHERE ID='" + tecdata.getId() + "'";
        System.out.println(query);
        try {
            Connection connection = Database.getDatabaseConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                // record found
                System.out.println("Record found");
                return true;
            } else {
                // record not found
                System.out.println("Record not found");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error searching technical officer record: " + e.getMessage());
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

