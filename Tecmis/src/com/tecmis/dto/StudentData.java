package com.tecmis.dto;

import com.tecmis.database.Database;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Date;



public class StudentData extends User {

    public StudentData() {
        this.userAccountType = "student";
    }

    private String Id;
    private String userName;
    private String password;

    private String firstName;
    private String lastName;
    private String mobile;
    private String address;
    private String age;
    private String email;
    private String dom;
    private String gender;

    private String level;
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == "Male" ? "M" : "F";
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    private static final String[] student_table_columns = {"ID", "username", "password", "Fname", "Lname", "Mobile", "Address", "Age", "Email", "DOM", "Gender", "Level", "Department"};

        public static DefaultTableModel showStudent()  {


            Connection conn = null;
            Statement stmt = null;
            DefaultTableModel model=null;

            try {
                conn = Database.getDatabaseConnection();
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT " + String.join(",", student_table_columns) + " FROM Student");
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                model = new DefaultTableModel(student_table_columns, 0);

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

