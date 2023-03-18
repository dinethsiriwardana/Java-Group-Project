package com.tecmis.ui.TechnicalOfficer;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class TechnicalOfficerAttendanceForm extends JFrame {
    private JPanel PanalTechnicalOfficer;
    private JTextField textField1;
    private JButton searchButton;
    private JButton addButton;
    private JButton updateButton;
    private JTextArea textArea1;

    public TechnicalOfficerAttendanceForm(){
        add(PanalTechnicalOfficer);
        setVisible(true);
        setTitle("Technical Officer Attendance Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(800,1600));
        setResizable(false);

        searchButton.addActionListener(e -> {
            String studentId = textField1.getText().trim();
            if (studentId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a student id");
                return;
            }

            try {
                // Establish database connection
               // String dbUrl = "jdbc:mysql://localhost:3306/mydb";
                String dbUsername = "u812963415_javag2";
                String dbPassword = "qEc:0f=5";
                Connection connection = DriverManager.getConnection(dbUsername, dbPassword);

                // Execute SQL query to retrieve attendance data for the student id
                String query = "SELECT * FROM attendance WHERE student_id=?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, studentId);
                ResultSet resultSet = statement.executeQuery();

                // Display the retrieved attendance data in the UI
                StringBuilder attendanceData = new StringBuilder();
                while (resultSet.next()) {
                    String date = resultSet.getString("date");
                    String status = resultSet.getString("status");
                    attendanceData.append(date).append(": ").append(status).append("\n");
                }
                textArea1.setText(attendanceData.toString());

                // Close database connection
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to retrieve attendance data from the database");
            }
        });
    }

    public static void main(String[] args) {
        TechnicalOfficerAttendanceForm techOfficerAttendance = new TechnicalOfficerAttendanceForm();
    }
}