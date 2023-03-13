package com.tecmis.ui.lecture;

import com.tecmis.database.ManageUsers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;

public class LectureEditUser extends JFrame{
    private JTextField txtFname;
    private JTextField txtMobileNo;
    private JTextField txtEmailAdd;
    private JTextField txtLname;
    private JTextField txtDob;
    private JComboBox comboGender;
    private JTextArea txtareaAddress;
    private JComboBox comboPosition;
    private JPanel pnlEditLecDetilas;
    private JButton refreshButton;
    private JButton updateButton;


    private static String username;

    static LectureEditUser lecUI;

    public  LectureEditUser(String username)  throws SQLException {
        this.username = username;
        add(pnlEditLecDetilas);
        setVisible(true);
        setTitle("Lecturer Details");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600,600);

        setPreferredSize(new Dimension(220,400));
        setResizable(false);
        lecUI = this;
        dataLoad();




        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                updateDetails();
            }
        });
        refreshButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                    dataLoad();
            }
        });
    }

    static ManageUsers manageusers = new ManageUsers();

//    public static void main(String[] args) throws SQLException {
//        lecUI = new LectureEditUser("lec001");
//
//        lecUI.dataLoad();
//    }
    public  void dataLoad() {
        System.out.println(username);
        HashMap<String, String> udata = manageusers.getUserDetails(username,"Lecturer");
        lecUI.txtFname.setText(udata.get("Fname"));
        lecUI.txtLname.setText(udata.get("Lname"));
        lecUI.txtMobileNo.setText(udata.get("Mobile"));
        lecUI.txtareaAddress.setText(String.join("\n", udata.get("Address").split(",\\s*")));
        lecUI.txtDob.setText(udata.get("DOM"));
        lecUI.txtEmailAdd.setText(udata.get("Email"));
        lecUI.comboGender.getModel().setSelectedItem(udata.get("Gender") == "M" ? "Male" : "Female");
        lecUI.comboPosition.getModel().setSelectedItem(udata.get("Position"));

    }

    public void updateDetails(){
        HashMap<String, String> lecturerData = new HashMap<String, String>();
        lecturerData.put("Fname", txtFname.getText());
        lecturerData.put("Lname", txtLname.getText());
        lecturerData.put("Mobile", txtMobileNo.getText());
        lecturerData.put("Address", String.join(", ",txtareaAddress.getText().split("\n")));
        lecturerData.put("Email", txtEmailAdd.getText());
        lecturerData.put("DOM", txtDob.getText());
        lecturerData.put("Gender", comboGender.getModel().getSelectedItem() == "Male" ? "M" : "F");
        lecturerData.put("Position", comboPosition.getModel().getSelectedItem().toString());
        manageusers.updateUser(username,"Lecturer",lecturerData);

    }
}
