package com.tecmis.ui.Student;

import javax.swing.*;
import java.awt.*;

public class Profile_Update extends  JFrame{
    private JLabel UpdateProHeader;
    private JLabel lblStuID;
    private JTextField txtFname;
    private JTextField txtID;
    private JLabel lblFName;
    private JLabel lblLName;
    private JTextField txtLname;
    private JLabel lblDOB;
    private JTextField txtDOB;
    private JLabel lblStuEmail;
    private JTextField txtEmail;
    private JPanel pnlProfile;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField4;
    private JButton updateButton;

    public Profile_Update(){
        add(pnlProfile);
        setVisible(true);
        setTitle("Student !!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,1500);
        setPreferredSize(new Dimension(220,400));
        setResizable(true);
    }


    public static void main(String[] args) {
        Profile_Update profile=new Profile_Update();
    }

}
