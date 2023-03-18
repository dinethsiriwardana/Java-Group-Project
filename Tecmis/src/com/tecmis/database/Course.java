package com.tecmis.database;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public  class Course {
    private String courseId;

    private String courseName;
    private int credit;
    private String depID;
    private String lecID;
    private String quiz;
    private String asses;

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public String getAsses() {
        return asses;
    }

    public void setAsses(String asses) {
        this.asses = asses;
    }

    private static final String[] courses_test_table_columns = {"Course_ID", "Course_Name", "Credit", "Dep_ID", "Lec_ID","No_of_Quiz","No_of_Assessments"};


    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getLecID() {
        return lecID;
    }

    public void setLecID(String lecID) {
        this.lecID = lecID;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public static DefaultTableModel showCourses() throws Exception {


        Connection conn = Database.getDatabaseConnection();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT " + String.join(",", courses_test_table_columns) + " FROM Courses_test");

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        DefaultTableModel model = new DefaultTableModel(courses_test_table_columns, 0);

        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            model.addRow(row);
        }
        return model;



    }

    public static boolean addCourse(Course course) throws SQLException {
        boolean added=false;
        try {
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Courses_test (Course_Id, Course_Name, Credit, Dep_Id, Lec_Id, No_of_Quiz,No_of_Assessments) VALUES (?, ?, ?, ?, ?,?,?)");
            stmt.setString(1, course.getCourseId());
            stmt.setString(2, course.getCourseName());
            stmt.setInt(3, course.getCredit());
            stmt.setString(4,course.getDepID());
            stmt.setString(5,course.getLecID());
            stmt.setString(6,course.getQuiz());
            stmt.setString(7,course.getAsses());
            int rowsAdded=stmt.executeUpdate();
            stmt.close();
            conn.close();
            if (rowsAdded > 0) {
                added=true;
                System.out.println("Course add successful!!");
            } else {
                System.out.println("Course not add!!");
            }

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return added;
    }

    public static boolean updateCourse(Course course) throws SQLException {
       boolean updated=false;
        try {
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE Courses_test SET Course_Name=?, Credit=?, Dep_Id=?, Lec_Id=?, No_of_Quiz=?,No_of_Assessments=? WHERE Course_Id=?");
            stmt.setString(1, course.getCourseName());
            stmt.setInt(2, course.getCredit());
            stmt.setString(3,course.getDepID());
            stmt.setString(4,course.getLecID());
            stmt.setString(5,course.getQuiz());
            stmt.setString(6,course.getAsses());
            stmt.setString(7,course.getCourseId());

            int rowsUpdated = stmt.executeUpdate();
            stmt.close();
            conn.close();

            if (rowsUpdated > 0) {
                updated=true;
                System.out.println("Course Update successful!!");
            } else {
                System.out.println("Course not update!!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return  updated;
    }




    public static boolean deleteCourse(Course course) throws SQLException {
        boolean deleted = false;
        try {
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "DELETE FROM Courses_test WHERE Course_Id=?");
            stmt.setString(1, course.getCourseId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                // record found and
                deleted = true;
                System.out.println("Record deleted successfully!!");
            } else {
                // record not found
                System.out.println("Record not found!!");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return deleted;
    }


    public static boolean searchCourse(Course course) throws SQLException {
        boolean searched=false;
        try {
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Courses_test WHERE Course_Id=?");
            stmt.setString(1, course.getCourseId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // record found
                searched=true;
                System.out.println("Record found!!");
            }
            else {
                // record not found
                System.out.println("Record not found!!");
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return searched;
    }



}