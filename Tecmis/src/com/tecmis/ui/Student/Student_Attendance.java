package com.tecmis.ui.Student;

import javax.swing.*;
import java.sql.*;

public class Student_Attendance {
    private JLabel HeaderAttendance;
    private JLabel lblStuID;
    private JTextField textStuID;
    private JButton searchButton;
    private JTextArea textArea1;





    public Student_Attendance() {
        searchButton.addActionListener(e -> {
            String studentID = textStuID.getText();
            String attendanceDetails = getAttendanceDetails(studentID);
            textArea1.setText(attendanceDetails);
        });
    }

    private String getAttendanceDetails(String studentID) {
        String attendanceDetails = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mariadb://191.96.56.1:3306/u812963415_javag2", "u812963415_javag2", "qEc:0f=5");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM attendance WHERE student_id='" + studentID + "'");
            while (rs.next()) {
                String date = rs.getString("date");
                String status = rs.getString("status");
                attendanceDetails += date + ": " + status + "\n";
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error retrieving attendance details: " + ex.getMessage());
        }
        return attendanceDetails;
    }
}
