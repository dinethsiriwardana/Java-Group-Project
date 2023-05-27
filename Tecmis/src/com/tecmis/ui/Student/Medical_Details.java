package com.tecmis.ui.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Medical_Details extends JFrame{
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
    private JPanel Jmedi;


    public  Medical_Details(){
    add(Jmedi);
    setVisible(true);
    setTitle("Medical Details");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(1500,1500);
    setPreferredSize(new Dimension(220,400));
    setResizable(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentID = textStuID.getText();
                String courseID = textCourseID.getText();
                String date = textDate.getText();
                String selectedType = (String) TypecomboBox.getSelectedItem();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textStuID.setText("");
                textCourseID.setText("");
                textDate.setText("");
                TypecomboBox.setSelectedIndex(0);
            }
        });
    }

    public static void main(String[] args) {
        Medical_Details Medical = new Medical_Details();
    }
}




