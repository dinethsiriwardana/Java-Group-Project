package com.tecmis.ui.Student;

import com.tecmis.database.Auth;
import com.tecmis.database.ManageUsers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class Profile_Update extends  JFrame{
    private JLabel UpdateProHeader;
    private JTextField txtFname;
    private JLabel lblFName;
    private JLabel lblLName;
    private JTextField txtLname;
    private JLabel lblDOB;
    private JTextField txtMobileNo;
    private JLabel lblStuEmail;
    private JTextField txtareaAddress;
    private JPanel pnlProfile;
    private JTextField txtEmailAdd;
    private JTextField txtDob;
    private JComboBox comboGender;
    private JComboBox comboLevel;
    private JTextField txtDepartment;
    private JButton updateButton;

    private static String username;
    
    Profile_Update profileUpdate;

    public Profile_Update(){
        
        Auth auth = Auth.getInstance();
        username = auth.getUsername();
        
        add(pnlProfile);
        setVisible(true);
        setTitle("Student !!!");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(550,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(true);
        profileUpdate = this;

        dataLoad();
        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                updateDetails();
            }
        });
    }

    static ManageUsers manageusers = new ManageUsers();



    public  void dataLoad() {
        System.out.println(username);
        HashMap<String, String> udata = manageusers.getUserDetails(username,"Student");
//        System.out.println(udata.get("Fname"));
        profileUpdate.txtFname.setText(udata.get("Fname"));
        profileUpdate.txtLname.setText(udata.get("Lname"));
        profileUpdate.txtMobileNo.setText(udata.get("Mobile"));
        profileUpdate.txtareaAddress.setText(udata.get("Address"));
        profileUpdate.txtDob.setText(udata.get("DOM"));
        profileUpdate.txtEmailAdd.setText(udata.get("Email"));
        profileUpdate.comboGender.getModel().setSelectedItem(udata.get("Gender") == "M" ? "Male" : "Female");
        profileUpdate.comboLevel.getModel().setSelectedItem(udata.get("Level"));
        profileUpdate.txtDepartment.setText(udata.get("Department"));

    }

    public void updateDetails(){
        HashMap<String, String> studentData = new HashMap<String, String>();
        studentData.put("Fname", txtFname.getText());
        studentData.put("Lname", txtLname.getText());
        studentData.put("Mobile", txtMobileNo.getText());
        studentData.put("Address", txtareaAddress.getText());
        studentData.put("Email", txtEmailAdd.getText());
        studentData.put("DOM", txtDob.getText());
        studentData.put("Gender", comboGender.getModel().getSelectedItem() == "Male" ? "M" : "F");
        studentData.put("Level", comboLevel.getModel().getSelectedItem().toString());
        studentData.put("Department", txtDepartment.getText());
        manageusers.updateUser(username,"Student",studentData);
    }

    public static void main(String[] args) {
        Profile_Update profile=new Profile_Update();
    }

}
