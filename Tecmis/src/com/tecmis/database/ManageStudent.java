package com.tecmis.database;


import com.tecmis.dto.StudentData;
import com.tecmis.dto.User;


import java.sql.*;


public class ManageStudent {

    public static boolean addStudent(StudentData studata ){

        String query = "INSERT INTO Student " +
                       "(ID, username, password, Fname, Lname, Mobile, Address, Age, Email, DOM, Gender,Level,Department) " +
                       "VALUES ( ?,?,?,?,?,?,?,?,?,?,?,?,?)";

        System.out.println(query);

        try {

            Connection connection = Database.getDatabaseConnection();
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, studata.getId());
            pst.setString(2, studata.getUserName());
            pst.setString(3, studata.getPassword());
            pst.setString(4, studata.getFirstName());
            pst.setString(5, studata.getLastName());
            pst.setString(6, studata.getMobile());
            pst.setString(7, studata.getAddress());
            pst.setString(8, studata.getAge());
            pst.setString(9, studata.getEmail());
            pst.setString(10, studata.getDom());
            pst.setString(11, studata.getGender());
            pst.setString(12, studata.getLevel());
            pst.setString(13,studata.getDepartment());

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
        }

    }
    public  static boolean updateStudent(StudentData studata){
        String query = "UPDATE Student " +
                       "SET username=?, password=?, Fname=?, Lname=?, Mobile=?, Address=?, Age=?, Email=?, DOM=?, Gender=?, Level=?, Department=? " +
                       "WHERE ID=?";


        try {

            Connection connection = Database.getDatabaseConnection();
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, studata.getUserName());
            pst.setString(2, studata.getPassword());
            pst.setString(3, studata.getFirstName());
            pst.setString(4, studata.getLastName());
            pst.setString(5, studata.getMobile());
            pst.setString(6, studata.getAddress());
            pst.setString(7, studata.getAge());
            pst.setString(8, studata.getEmail());
            pst.setString(9, studata.getDom());
            pst.setString(10, studata.getGender());
            pst.setString(11, studata.getLevel());
            pst.setString(12, studata.getDepartment());
            pst.setString(13, studata.getId());

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
        }

    }
    public  static  boolean deleteStudent(StudentData studata){

        String query = "DELETE FROM Student WHERE ID='" + studata.getId() + "'";

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
        } catch (Exception e) {
            System.out.println(e);
            return  false;
        }


    }
    public static ResultSet searchStudent(StudentData studata){

        String query = "SELECT * FROM Student WHERE ID='" + studata.getId() + "'";
        System.out.println(query);
        try {
            Connection connection = Database.getDatabaseConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            return rs;
        } catch (SQLException e) {
            System.out.println("Error in executing query " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Error in getting connection" + e.getMessage());
            return null;
        }
    }


}

