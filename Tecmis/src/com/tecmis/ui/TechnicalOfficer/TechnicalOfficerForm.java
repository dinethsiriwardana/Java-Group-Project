package com.tecmis.ui.TechnicalOfficer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.HashMap;
import java.util.Objects;

import com.tecmis.database.Auth;
import com.tecmis.database.Database;
import com.tecmis.database.ManageUsers;

import javax.swing.*;

public class TechnicalOfficerForm extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JPanel panel;
    private JButton updateButton;
    private JButton cancelButton;
    private JPanel panalTechnicalOfficer;
    private JComboBox comboDepartment;
    private JTextField txtFname;
    private JTextField txtLname;
    private JTextField txtMobileNo;
    private JTextArea txtareaAddress;
    private JTextField txtEmailAdd;
    private JTextField txtDob;
    private JComboBox comboGender;
    private JTextField passwordField;
    private JTextField departmentField;
    private JTextArea addressArea;
    private JTextField userIdField;
    private JComboBox<String> departmentBox;

    static TechnicalOfficerForm toUI;
    private static String username;



    public TechnicalOfficerForm(){
        Auth auth = Auth.getInstance();
        username = auth.getUsername();

        add(panalTechnicalOfficer);
        setVisible(true);
        setTitle("Technical Officer Profile Update");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600,600);
        setPreferredSize(new Dimension(800,600));
        setResizable(false);


        toUI = this;
        dataLoad();

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUserDetails();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    static ManageUsers manageusers = new ManageUsers();

    public  void dataLoad() {
        HashMap<String, String> udata = manageusers.getUserDetails(username,"TechnicalOfficer");
        toUI.txtFname.setText(udata.get("Fname"));
        toUI.txtLname.setText(udata.get("Lname"));
        toUI.txtMobileNo.setText(udata.get("Mobile"));
        toUI.txtareaAddress.setText(String.join("\n", udata.get("Address").split(",\\s*")));
        toUI.txtDob.setText(udata.get("DOM"));
        toUI.txtEmailAdd.setText(udata.get("Email"));
        System.out.println(udata.get("Gender"));
        toUI.comboGender.getModel().setSelectedItem(Objects.equals(udata.get("Gender"), "M") ? "Male" : "Female");
        toUI.comboDepartment.getModel().setSelectedItem(udata.get("T_Dep_ID"));

    }



    private void updateUserDetails() {

            HashMap<String, String> ToData = new HashMap<String, String>();
        ToData.put("Fname", txtFname.getText());
        ToData.put("Lname", txtLname.getText());
        ToData.put("Mobile", txtMobileNo.getText());
        ToData.put("Address", String.join(", ",txtareaAddress.getText().split("\n")));
        ToData.put("Email", txtEmailAdd.getText());
        ToData.put("DOM", txtDob.getText());
        ToData.put("Gender", comboGender.getModel().getSelectedItem() == "Male" ? "M" : "F");
        ToData.put("T_Dep_ID", comboDepartment.getModel().getSelectedItem().toString());
            manageusers.updateUser(username,"TechnicalOfficer",ToData);


    }

    public static void main(String[] args) {
        TechnicalOfficerForm techOfficer = new TechnicalOfficerForm();
    }
}

