package com.tecmis.dto;

import com.tecmis.database.Database;

import javax.swing.*;
import java.sql.*;
import java.util.HashMap;

public class SubjectDetails {
    private HashMap<String, HashMap<String, String>> data;

    DefaultComboBoxModel<String> subjectModel = new DefaultComboBoxModel<>(new String[] {});

    public ComboBoxModel<String> getSubjectModel() {
        return subjectModel;
    }

    public SubjectDetails(){
        data = new HashMap<String, HashMap<String, String>>();

        try {

            Connection conn = Database.getDatabaseConnection();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Courses");

            while (rs.next()) {
                HashMap<String, String> course = new HashMap<String, String>();
                course.put("Course_Name", rs.getString("Course_Name"));
                course.put("Credit", rs.getString("Credit"));
                course.put("Dep_ID", rs.getString("Dep_ID"));
                course.put("Lec_ID", rs.getString("Lec_ID"));
                course.put("No_of_Quiz", rs.getString("No_of_Quiz"));
                course.put("Quiz_to_End", rs.getString("Quiz_to_End"));
                course.put("Quiz_Percentage", rs.getString("Quiz_Percentage"));
                course.put("No_of_Assessments", rs.getString("No_of_Assessments"));
                course.put("Assessments_to_End", rs.getString("Assessments_to_End"));
                course.put("Assessment_Percentage", rs.getString("Assessment_Percentage"));
                course.put("Mid_to_End", rs.getString("Mid_to_End"));
                course.put("Final_theory", rs.getString("Final_theory"));
                course.put("Final_preactical", rs.getString("Final_preactical"));
                subjectModel.addElement(rs.getString("Course_ID"));
                data.put(rs.getString("Course_ID"), course);
            }

            // Close the resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public HashMap<String, HashMap<String, String>> getData() {
        return data;
    }




}
