package com.tecmis.ui.Student;

import com.tecmis.database.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

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

    String Stu_ID;
    String Course_ID;
    String Date;
    String Type;


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
                insertMedical();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textStuID.setText("");
                textCourseID.setText("");
                textDate.setText("");
                TypecomboBox.setSelectedItem("");
            }
        });


    }

    public void insertMedical(){
        String query= "INSERT INTO Medical"+"(Stu_ID,Course_ID,DATE,Type)"+"Values(?,?,?,?)";
        try {
            Connection connection= Database.getDatabaseConnection();
            PreparedStatement pst=connection.prepareStatement(query);
            pst.setString(1,Stu_ID);
            pst.setString(2,Course_ID);
            pst.setString(3,Date);
            pst.setString(4,Type);

            int rowsAffected= pst.executeUpdate();
            if(rowsAffected==1){
                System.out.println("Record add successfully");
            }else{
                System.out.println("Record add failed");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Medical_Details Medical = new Medical_Details();
    }
}




