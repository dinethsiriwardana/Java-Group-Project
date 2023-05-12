package com.tecmis.ui.admin;

import com.tecmis.database.ManageUsers;
import com.tecmis.dto.StudentData;
import com.tecmis.util.Security;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class AddStudent extends JFrame{
    private JTextField txtID;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtMobile;
    private JTextArea txtAddress;
    private JTextField txtAge;
    private JTextField txtEmail;
    private JTextField txtDOB;
    private JComboBox txtGender;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JPanel pnlStudent;
    private JTextField txtUserName;
    private JTextField txtPassword;
    private JTextField txtLevel;
    private JButton searchButton;
    private JComboBox txtDepartment;
    private JTable studentTable;
    private JButton backButton;


    public AddStudent(){
    add(pnlStudent);
    setVisible(true);
    setSize(1000,600);
    setTitle("Admin !!!");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(220,400));
    setResizable(true);
    StudentData studentUser=new StudentData();
    Security security=new Security();

        try {
            studentTable.setModel(studentUser.showStudent());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            StudentData studentUser=new StudentData();
            studentUser.setId(txtID.getText());
            studentUser.setUserName(txtUserName.getText());
            try {
                studentUser.setPassword(security.encryption(txtPassword.getText()));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            studentUser.setFirstName(txtFirstName.getText());
            studentUser.setLastName(txtLastName.getText());
            studentUser.setMobile(txtMobile.getText());
            studentUser.setAddress(txtAddress.getText());
            studentUser.setAge((txtAge.getText()));
            studentUser.setEmail(txtEmail.getText());
            studentUser.setDom(txtDOB.getText());
            studentUser.setGender(txtGender.getModel().getSelectedItem().toString());
            studentUser.setLevel(txtLevel.getText());
            studentUser.setDepartment(txtDepartment.getModel().getSelectedItem().toString());



            ManageUsers manageUser = new ManageUsers();
            boolean isAdded = manageUser.addStu(studentUser);
            if (isAdded) {
                txtID.setText("");
                txtUserName.setText("");
                txtPassword.setText("");
                txtFirstName.setText("");
                txtLastName.setText("");
                txtMobile.setText("");
                txtAddress.setText("");
                txtAge.setText("");
                txtEmail.setText("");
                txtDOB.setText("");
                txtGender.setSelectedItem("");
                txtLevel.setText("");
                txtDepartment.setSelectedItem("");
                JOptionPane.showMessageDialog(null, "Student added successfully",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Failed to add Student ",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }


    });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentData studentUser=new StudentData();
                studentUser.setId(txtID.getText());
                studentUser.setUserName(txtUserName.getText());
                studentUser.setPassword(txtPassword.getText());
                studentUser.setFirstName(txtFirstName.getText());
                studentUser.setLastName(txtLastName.getText());
                studentUser.setMobile(txtMobile.getText());
                studentUser.setAddress(txtAddress.getText());
                studentUser.setAge((txtAge.getText()));
                studentUser.setEmail(txtEmail.getText());
                studentUser.setDom(txtDOB.getText());
                studentUser.setGender(txtGender.getModel().getSelectedItem().toString());
                studentUser.setLevel(txtLevel.getText());
                studentUser.setDepartment(txtDepartment.getModel().getSelectedItem().toString());



                ManageUsers manageUser = new ManageUsers();
                boolean isUpdated = manageUser.upStu(studentUser);
                if (isUpdated) {
                    txtID.setText("");
                    txtUserName.setText("");
                    txtPassword.setText("");
                    txtFirstName.setText("");
                    txtLastName.setText("");
                    txtMobile.setText("");
                    txtAddress.setText("");
                    txtAge.setText("");
                    txtEmail.setText("");
                    txtDOB.setText("");
                    txtGender.setSelectedItem("");
                    txtLevel.setText("");
                    txtDepartment.setSelectedItem("");
                    JOptionPane.showMessageDialog(null, "Student updated successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Failed to update Student ",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentData studentUser=new StudentData();
                studentUser.setId(txtID.getText());
                studentUser.setUserName(txtUserName.getText());
                studentUser.setPassword(txtPassword.getText());
                studentUser.setFirstName(txtFirstName.getText());
                studentUser.setLastName(txtLastName.getText());
                studentUser.setMobile(txtMobile.getText());
                studentUser.setAddress(txtAddress.getText());
                studentUser.setAge((txtAge.getText()));
                studentUser.setEmail(txtEmail.getText());
                studentUser.setDom(txtDOB.getText());
                studentUser.setGender(txtGender.getModel().getSelectedItem().toString());
                studentUser.setLevel(txtLevel.getText());
                studentUser.setDepartment(txtDepartment.getModel().getSelectedItem().toString());

                ManageUsers manageUser = new ManageUsers();
                boolean isDeleted = manageUser.delStu(studentUser);
                if (isDeleted) {
                    txtID.setText("");
                    txtUserName.setText("");
                    txtPassword.setText("");
                    txtFirstName.setText("");
                    txtLastName.setText("");
                    txtMobile.setText("");
                    txtAddress.setText("");
                    txtAge.setText("");
                    txtEmail.setText("");
                    txtDOB.setText("");
                    txtGender.setSelectedItem("");
                    txtLevel.setText("");
                    txtDepartment.setSelectedItem("");
                    JOptionPane.showMessageDialog(null, "Student delete successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Failed to delete Student ",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentData studentUser=new StudentData();
                studentUser.setId(txtID.getText());
                studentUser.setUserName(txtUserName.getText());
                studentUser.setPassword(txtPassword.getText());
                studentUser.setFirstName(txtFirstName.getText());
                studentUser.setLastName(txtLastName.getText());
                studentUser.setMobile(txtMobile.getText());
                studentUser.setAddress(txtAddress.getText());
                studentUser.setAge((txtAge.getText()));
                studentUser.setEmail(txtEmail.getText());
                studentUser.setDom(txtDOB.getText());
                studentUser.setGender(txtGender.getModel().getSelectedItem().toString());
                studentUser.setLevel(txtLevel.getText());
                studentUser.setDepartment(txtDepartment.getModel().getSelectedItem().toString());

                ManageUsers manageUser = new ManageUsers();
                ResultSet  searchStudent = manageUser.serchStu(studentUser);
                try {
                    if (searchStudent.next()) {

                        txtUserName.setText(searchStudent.getString("username"));
                        txtPassword.setText(searchStudent.getString("password"));
                        txtID.setText(searchStudent.getString("ID"));
                        txtFirstName.setText(searchStudent.getString("Fname"));
                        txtLastName.setText(searchStudent.getString("Lname"));
                        txtMobile.setText(searchStudent.getString("Mobile"));
                        txtAddress.setText(searchStudent.getString("Address"));
                        txtAge.setText(searchStudent.getString("Age"));
                        txtEmail.setText(searchStudent.getString("Email"));
                        txtDOB.setText(searchStudent.getString("DOM"));
                        txtGender.setSelectedItem(searchStudent.getString("Gender"));
                        txtLevel.setText(searchStudent.getString("Level"));
                        txtDepartment.setSelectedItem(searchStudent.getString("Department"));
                        JOptionPane.showMessageDialog(null, "Student search successfully",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Failed to search Student ",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminForm object = new AdminForm();
                object.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

    AddStudent addstudent=new AddStudent();
    }

}
