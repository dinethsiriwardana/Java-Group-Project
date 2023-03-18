package com.tecmis.ui.TechnicalOfficer;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class TechnicalOfficerMedicalForm extends JFrame {
    private JPanel PanalTechnicalOfficer;
    private JTextField studentIdField;
    private JTextField courseIdField;
    private JTextField dateField;
    private JTextField typeField;
    private JTextField fileField;
    private JButton addButton;
    private JButton updateButton;

    public TechnicalOfficerMedicalForm(){
        add(PanalTechnicalOfficer);
        setVisible(true);
        setTitle("Technical Officer Medical Add/Update");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(800,1600));
        setResizable(false);

        addButton.addActionListener(e -> {
            String studentId = studentIdField.getText().trim();
            String courseId = courseIdField.getText().trim();
            String date = dateField.getText().trim();
            String type = typeField.getText().trim();
            String file = fileField.getText().trim();

            if (studentId.isEmpty() || courseId.isEmpty() || date.isEmpty() || type.isEmpty() || file.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill out all fields");
                return;
            }

            try {
                // Establish database connection
                // String dbUrl = "jdbc:mysql://localhost:3306/mydb";
                String dbUsername = "u812963415_javag2";
                String dbPassword = "qEc:0f=5";
                Connection connection = DriverManager.getConnection(dbUsername, dbPassword);

                // Execute SQL query to insert medical form data into the database
                String query = "INSERT INTO medical_forms (student_id, course_id, date, type, file) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, studentId);
                statement.setString(2, courseId);
                statement.setString(3, date);
                statement.setString(4, type);
                statement.setString(5, file);
                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Medical form added successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to add medical form");
                }

                // Close database connection
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to add medical form to the database");
            }
        });
    }

    public static void main(String[] args) {
        TechnicalOfficerMedicalForm techOfficerMedical = new TechnicalOfficerMedicalForm();
    }
}
