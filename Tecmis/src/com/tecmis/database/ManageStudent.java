package com.tecmis.database;


import com.tecmis.dto.StudentData;
import com.tecmis.dto.User;


import java.sql.*;


public class ManageStudent {

    public static boolean addStudent(StudentData studata ){
        String query = "INSERT INTO Student " +
                       "(ID, username, password, Fname, Lname, Mobile, Address, Age, Email, DOM, Gender,Level,Department) " +
                       "VALUES ('" + studata.getId() + "', '" + studata.getUserName() + "', '" + studata.getPassword() + "', '" +
                        studata.getFirstName() + "', '" + studata.getLastName() + "', '" + studata.getMobile() + "', '" +
                        studata.getAddress() + "', '" + studata.getAge() + "', '" + studata.getEmail() + "', '" +
                        studata.getDom() + "', '" + studata.getGender() + "','" +studata.getLevel()+ "',' " +studata.getDepartment()+ " ')";

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
                System.out.println("user add  failed!!");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;

    }
    public  static boolean updateStudent(StudentData studata){
        String query = "UPDATE Student SET ID='" + studata.getId() + "', username='" + studata.getUserName() + "', " +
                       "password='" + studata.getPassword() + "', Fname='" + studata.getFirstName() + "', Lname='" + studata.getLastName() + "', " +
                       "Mobile='" + studata.getMobile() + "', Address='" + studata.getAddress() + "', Age='" + studata.getAge() + "', Email='" +
                        studata.getEmail() + "', DOM='" + studata.getDom() + "', Gender='" + studata.getGender() + "', Level='" + studata.getLevel() + "',Department= '" +studata.getDepartment()+ "' "+
                        " WHERE ID='" + studata.getId() + "'";



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
                System.out.println("Record update failed!!");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return  false;


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
        }
        return  false;

    }
    public static boolean searchStudent(StudentData studata){
        String query = "SELECT * FROM Student WHERE ID='" + studata.getId() + "'";
        System.out.println(query);
        try {
            Connection connection = Database.getDatabaseConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                // record found
                System.out.println("Record found!!");
                return true;
            } else {
                // record not found
                System.out.println("Record not found!!");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error searching student record: " + e.getMessage());
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    }

