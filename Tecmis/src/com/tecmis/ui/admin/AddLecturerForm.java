package com.tecmis.ui.admin;

import javax.swing.*;
import java.awt.*;

public class AddLecturerForm extends JFrame {


    private JPanel pnlAdmin;
    private JTextField textID;
    private JTextField textFirstName;
    private JTextField textLastName;
    private JTextField textMobile;
    private JTextArea textAddress;
    private JTextField textAge;
    private JTextField textEmail;
    private JTextField textDOB;
    private JComboBox comboBoxGender;
    private JComboBox comboBoxPosition;
    private JButton ADDButton;
    private JButton DELETEButton;
    private JButton UPDATEButton;

    public AddLecturerForm(){
        add(pnlAdmin);
        setVisible(true);
        setTitle("Add Lecturer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(false);

    }

    public static void main(String[] args) {
        AddLecturerForm addlec=new AddLecturerForm();
    }
}
