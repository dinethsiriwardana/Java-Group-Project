package com.tecmis.database;

import com.tecmis.dto.AdminData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManageAdmin {

    public static boolean addAdmin(AdminData addata) {
        String query = "INSERT INTO Admin" +
                "(ID, username, password, Fname, Lname, Mobile, Address, Age, Email, DOM, Gender,Admin_role) " +
                "VALUES ('" + addata.getID() + "', '" + addata.getUsername() + "', '" + addata.getPassword() + "', '" +
                addata.getFname() + "', '" + addata.getLname() + "', '" + addata.getMobile() + "', '" +
                addata.getAddress() + "', '" + addata.getAge() + "', '" + addata.getEmail() + "', '" +
                addata.getDOM() + "', '" + addata.getGender() + "','" + addata.getAdmin_role() + "')";

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

    public static boolean updateAdmin(AdminData addata) {
        String query = "UPDATE Admin SET ID='" + addata.getID() + "', username='" + addata.getUsername() + "', " +
                "password='" + addata.getPassword() + "', Fname='" + addata.getFname() + "', Lname='" + addata.getLname() + "', " +
                "Mobile='" + addata.getMobile() + "', Address='" + addata.getAddress() + "', Age='" + addata.getAge() + "', Email='" +
                addata.getEmail() + "', DOM='" + addata.getDOM() + "', Gender='" + addata.getGender() + "', Admin_role='" + addata.getAdmin_role() + "'" +
                " WHERE ID='" + addata.getID() + "'";

        System.out.println(query);
        try {
            Connection connection = Database.getDatabaseConnection();
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
        return false;

    }
    public static boolean deleteAdmin(AdminData addata){
        String query = "DELETE FROM Admin WHERE ID='" + addata.getID() + "'";

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
    public static boolean searchAdmin(AdminData addata) {
        String query = "SELECT * FROM Admin WHERE ID='" + addata.getID() + "'";
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
            System.out.println("Error searching admin record: " + e.getMessage());
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}



