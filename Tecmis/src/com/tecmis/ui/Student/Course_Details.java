package com.tecmis.ui.Student;

import javax.swing.*;
import java.sql.*;


public class Course_Details {
    private JLabel lblcourseHeader;
    private JTextArea textArea1;

    public Course_Details() {

        String courseDetails = getCourseDetails();
        textArea1.setText(courseDetails);
    }

    private String getCourseDetails() {
        String courseDetails = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mariadb://191.96.56.1:3306/u812963415_javag2", "u812963415_javag2", "qEc:0f=5");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM course");
            while (rs.next()) {
                String CourseID = rs.getString("Course_ID");
                String CourseName = rs.getString("Course_name");
                Integer Credit  = rs.getInt("Credit");
                String Dep_ID = rs.getString("Dep_ID");
                String Lec_ID = rs.getString("Lec_ID");

                courseDetails += "Course ID: " + CourseID + "\nCourse Name: " + CourseName + "\nCredit: " + Credit + "\nDep_ID: " + Dep_ID + "\nLec_ID: " + Lec_ID + "\n\n";
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error retrieving course details: " + ex.getMessage());
        }
        return courseDetails;
    }
}
