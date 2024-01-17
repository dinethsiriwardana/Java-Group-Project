package com.tecmis.ui.Student;

import com.tecmis.database.Auth;
import com.tecmis.database.Database;
import com.tecmis.dto.SubjectDetails;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Student_Marks extends JFrame {
    private JPanel Jresult;
    private JLabel txtresult;
    private JLabel tctgpa;
    private JComboBox comboBox1;
    private JTable marksTable;
    static Student_Marks marks;

    public Student_Marks(){
        Auth auth = Auth.getInstance();
        String studentId = auth.getSID();
    add(Jresult);
    setVisible(true);
    setTitle("Student Result!!!");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(500,500);
    setPreferredSize(new Dimension(220,400));
    setResizable(true);
        SubjectDetails subjectDetails = new SubjectDetails();
        comboBox1.setModel(subjectDetails.getSubjectModel());



            // HTML table variables

            try {
                // Establish database connection
                Connection connection = Database.getDatabaseConnection();

                // Create the SQL query
                String query = "SELECT gpa FROM student WHERE id = ?";


                // Prepare the statement
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, studentId);

                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    tctgpa.setText("You GPA = " + resultSet.getFloat("gpa"));
                }




            } catch (Exception e) {
            throw new RuntimeException(e);
        }

        comboBox1.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = Database.getDatabaseConnection();

                    // Create the SQL query
                    String query = "SELECT grade FROM "+comboBox1.getModel().getSelectedItem()+"_marks WHERE SID = ?";


                    // Prepare the statement
                    PreparedStatement preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1, studentId);
                    System.out.println(studentId);
                    // Execute the query
                    System.out.println(preparedStatement);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        txtresult.setText("You Result = " + resultSet.getString("grade"));
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }


            }
        });

    }






    public static void main(String[] args) {
        Student_Marks studentMarks= new Student_Marks();

    }
}
