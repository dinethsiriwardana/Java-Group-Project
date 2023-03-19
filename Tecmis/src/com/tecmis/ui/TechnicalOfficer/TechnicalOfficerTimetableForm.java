package com.tecmis.ui.TechnicalOfficer;

import com.tecmis.database.Database;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class TechnicalOfficerTimetableForm extends JFrame {
    private JPanel PanalTechnicalOfficer;
    private JButton downloadButton2;
    private JButton downloadButton3;
    private JButton downloadButton1;
    private JButton downloadButton;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton searchButton;
    private JButton addButton;
    private JButton updateButton;
    private JTextArea textArea1;

    public TechnicalOfficerTimetableForm(){
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
                Connection conn = Database.getDatabaseConnection();

                String query = "SELECT * FROM attendance WHERE student_id=?";
                PreparedStatement statement = conn.prepareStatement(query);
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
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to retrieve attendance data from the database");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public static void main(String[] args) {

    }
}