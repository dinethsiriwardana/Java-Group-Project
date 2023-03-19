package com.tecmis.ui.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Medical_Details {
    private JLabel lblStuID;
    private JTextField textStuID;
    private JLabel lblCourseID;
    private JTextField textCourseID;
    private JLabel lblDate;
    private JTextField textDate;
    private JLabel lblType;
    private JLabel MedicalHeader;
    private JLabel lblReport;
    private JComboBox TypecomboBox;
    private JButton clearButton;
    private JButton submitButton;

    /*submitButton.addActionListener(new public Medical_Details() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stuID = textStuID.getText();
                String courseID = textCourseID.getText();
                String date = textDate.getText();
                String type = (String) TypecomboBox.getSelectedItem();

                // Save the data entered by the user into the database using appropriate database APIs
                boolean success = saveDataToDatabase(stuID, courseID, date, type);

                if (success) {
                    JOptionPane.showMessageDialog(null, "Data saved successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to save data.");
                }
            }
        });
    }

    /*clearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent e){

            textStuID.setText("");
            textCourseID.setText("");
            textDate.setText("");
            TypecomboBox.setSelectedIndex(0);
        }
    });*/
}




