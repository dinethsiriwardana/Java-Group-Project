package com.tecmis.dto;

import com.tecmis.database.Database;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Date;

public class AdminData extends  User {

    public AdminData() {
        this.userAccountType = "admin";
    }

    private String ID;
    private String username;
    private String password;
    private String Fname;
    private String Lname;
    private String Mobile;
    private String Address;
    private String Age;
    private String Email;
    private String DOM;
    private String Gender;
    private String Admin_role;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDOM() {
        return DOM;
    }

    public void setDOM(String DOM) {
        this.DOM = DOM;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getAdmin_role() {
        return Admin_role;
    }

    public void setAdmin_role(String Admin_role) {
        this.Admin_role = Admin_role;
    }

    private static final String[] admin_table_columns = {"ID", "username", "password", "Fname", "Lname", "Mobile", "Address", "Age", "Email", "DOM", "Gender", "Admin_role"};

    public static DefaultTableModel showAdmin()  {

        Connection conn = null;
        Statement stmt = null;
        DefaultTableModel model=null;

        try {
            conn = Database.getDatabaseConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT " + String.join(",", admin_table_columns) + " FROM Admin");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            model = new DefaultTableModel(admin_table_columns, 0);

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

        } catch (Exception e) {
            System.out.println("Error in getting connection " + e.getMessage());
        }finally {
            try {
                conn.close();
             } catch (SQLException e) {
                System.out.println("Error in closing the Connection..."+ e.getMessage());
            }
        }
        return model;



    }
}
