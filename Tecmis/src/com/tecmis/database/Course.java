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

    public static void updateCourse(Course course) throws SQLException {

        try {
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE from Course SET  course_name=?, credit=? WHERE course_id=?");
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

    public static void deleteCourse(Course course) throws SQLException {
        try {
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "DELETE FROM Course WHERE course_id=?");
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


}