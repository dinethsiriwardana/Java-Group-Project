package com.tecmis.database;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public  class Course {
    private String courseId;

    private String courseName;
    private int credit;

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

    public static void addCourse(Course course) throws SQLException {

        try {
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Course (course_id, course_name, credit) VALUES (?, ?, ?)");
            stmt.setString(1, course.getCourseId());
            stmt.setString(2, course.getCourseName());
            stmt.setInt(3, course.getCredit());
            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean updateCourse(Course course) throws SQLException {
       boolean updated=false;
        try {
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE Course SET course_name=?, credit=? WHERE course_id=?");
            stmt.setString(1, course.getCourseName());
            stmt.setInt(2, course.getCredit());
            stmt.setString(3, course.getCourseId());
            int rowsUpdated = stmt.executeUpdate();
            stmt.close();
            conn.close();

            if (rowsUpdated > 0) {
                updated=true;
                System.out.println("Course Update successful!!");
            } else {
                System.out.println("Course not found!!");
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
                    "DELETE FROM Course WHERE course_id=?");
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
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Course WHERE course_id=?");
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