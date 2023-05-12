package com.tecmis.database;

import com.tecmis.dto.AdminData;

import java.sql.*;


public class ManageAdmin {



    public static boolean addAdmin(AdminData addata) {


        String query =  "INSERT INTO Admin" +
                        "(ID, username, password, Fname, Lname, Mobile, Address, Age, Email, DOM, Gender, Admin_role) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        System.out.println(query);

        try (

                Connection   connection = Database.getDatabaseConnection();
                PreparedStatement pst = connection.prepareStatement(query)) {

                pst.setString(1, addata.getID());
                pst.setString(2, addata.getUsername());
                pst.setString(3, addata.getPassword());
                pst.setString(4, addata.getFname());
                pst.setString(5, addata.getLname());
                pst.setString(6, addata.getMobile());
                pst.setString(7, addata.getAddress());
                pst.setString(8, addata.getAge());
                pst.setString(9, addata.getEmail());
                pst.setString(10, addata.getDOM());
                pst.setString(11, addata.getGender());
                pst.setString(12, addata.getAdmin_role());

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected == 1) {

                System.out.println("Record add successfully!! ");
                return true;
            } else {

                System.out.println("Record add  failed!!");
                return false;
            }

        }catch (SQLException e){
            System.out.println("Error in executing query "+e.getMessage());
            return false;
        }
        catch (Exception e) {
            System.out.println("Error in getting connection"+e.getMessage());
            return false;
        }

    }

    public static boolean updateAdmin(AdminData addata) {
        String query = "UPDATE Admin SET  username=?, password=?, Fname=?, Lname=?, " +
                       "Mobile=?, Address=?, Age=?, Email=?, DOM=?, Gender=?, Admin_role=? WHERE ID=?"  ;

        try {
            Connection connection = Database.getDatabaseConnection();
            PreparedStatement pst = connection.prepareStatement(query);


            pst.setString(1, addata.getUsername());
            pst.setString(2, addata.getPassword());
            pst.setString(3, addata.getFname());
            pst.setString(4, addata.getLname());
            pst.setString(5, addata.getMobile());
            pst.setString(6, addata.getAddress());
            pst.setString(7, addata.getAge());
            pst.setString(8, addata.getEmail());
            pst.setString(9, addata.getDOM());
            pst.setString(10, addata.getGender());
            pst.setString(11, addata.getAdmin_role());
            pst.setString(12, addata.getID());

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected == 1) {
                System.out.println("Record update successfully!! ");
                return true;

            } else {
                System.out.println("Record update failed!!");
                return false;
            }

        } catch (SQLException e){
            System.out.println("Error in executing query "+e.getMessage());
            return false;

        }catch (Exception e) {
            System.out.println("Error in getting connection"+e.getMessage());
            return false;
        }

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
                System.out.println("Record delete failed!!");
                return false;
            }
        } catch (SQLException e){
            System.out.println("Error in executing query "+e.getMessage());
            return false;
        }
        catch (Exception e) {
            System.out.println("Error in getting connection"+e.getMessage());
            return  false;
        }


    }
    public static ResultSet searchAdmin(AdminData addata) {
        String query = "SELECT * FROM Admin WHERE ID='" + addata.getID() + "'";
        System.out.println(query);
        try {
            Connection connection = Database.getDatabaseConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;

        } catch (SQLException e){
            System.out.println("Error in executing query "+e.getMessage());
            return null;
        }
        catch (Exception e) {
            System.out.println("Error in getting connection"+e.getMessage());
            return null;
        }

    }


}



