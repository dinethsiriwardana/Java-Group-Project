package com.tecmis.ui.admin;

import com.tecmis.database.ManageUsers;
import com.tecmis.dto.AdminData;
import com.tecmis.dto.StudentData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAdmin  extends JFrame{

    private JPanel pnlAdmin;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtMobile;
    private JTextArea txtAddress;
    private JTextField txtAge;
    private JTextField txtEmail;
    private JTextField txtDOB;
    private JComboBox txtGender;
    private JTable table1;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JTextField txtID;
    private JButton ADDButton;
    private JButton DELETEButton;
    private JButton UPDATEButton;
    private JTextField txtAdminRole;

    public  AddAdmin(){
        add(pnlAdmin);
        setVisible(true);
        setTitle("Admin Details!!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,1500);
        setPreferredSize(new Dimension(220,400));
        setResizable(true);
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminData adminUser=new AdminData();
                adminUser.setID(txtID.getText());
                adminUser.setUsername(txtUsername.getText());
                adminUser.setPassword(txtPassword.getText());
                adminUser.setFname(txtFirstName.getText());
                adminUser.setLname(txtLastName.getText());
                adminUser.setMobile(txtMobile.getText());
                adminUser.setAddress(txtAddress.getText());
                adminUser.setAge((txtAge.getText()));
                adminUser.setEmail(txtEmail.getText());
                adminUser.setDOM(txtDOB.getText());
                adminUser.setGender(txtGender.getModel().getSelectedItem().toString());
                adminUser.setAdmin_role(txtAdminRole.getText());



                ManageUsers manageUser = new ManageUsers();
                boolean isAdded = manageUser.addAdm(adminUser);
                if (isAdded) {
                    txtID.setText("");
                    txtUsername.setText("");
                    txtPassword.setText("");
                    txtFirstName.setText("");
                    txtLastName.setText("");
                    txtMobile.setText("");
                    txtAddress.setText("");
                    txtAge.setText("");
                    txtEmail.setText("");
                    txtDOB.setText("");
                    txtGender.setSelectedItem("");
                    txtAdminRole.setText("");
                    JOptionPane.showMessageDialog(null, "User added successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Failed to add user ",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminData adminUser=new AdminData();
                adminUser.setID(txtID.getText());
                adminUser.setUsername(txtUsername.getText());
                adminUser.setPassword(txtPassword.getText());
                adminUser.setFname(txtFirstName.getText());
                adminUser.setLname(txtLastName.getText());
                adminUser.setMobile(txtMobile.getText());
                adminUser.setAddress(txtAddress.getText());
                adminUser.setAge((txtAge.getText()));
                adminUser.setEmail(txtEmail.getText());
                adminUser.setDOM(txtDOB.getText());
                adminUser.setGender(txtGender.getModel().getSelectedItem().toString());
                adminUser.setAdmin_role(txtAdminRole.getText());



                ManageUsers manageUser = new ManageUsers();
                boolean isUpdated = manageUser.upAdm(adminUser);
                if (isUpdated) {
                    txtID.setText("");
                    txtUsername.setText("");
                    txtPassword.setText("");
                    txtFirstName.setText("");
                    txtLastName.setText("");
                    txtMobile.setText("");
                    txtAddress.setText("");
                    txtAge.setText("");
                    txtEmail.setText("");
                    txtDOB.setText("");
                    txtGender.setSelectedItem("");
                    txtAdminRole.setText("");
                    JOptionPane.showMessageDialog(null, "User update successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Failed to update user ",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminData adminUser=new AdminData();
                adminUser.setID(txtID.getText());
                adminUser.setUsername(txtUsername.getText());
                adminUser.setPassword(txtPassword.getText());
                adminUser.setFname(txtFirstName.getText());
                adminUser.setLname(txtLastName.getText());
                adminUser.setMobile(txtMobile.getText());
                adminUser.setAddress(txtAddress.getText());
                adminUser.setAge((txtAge.getText()));
                adminUser.setEmail(txtEmail.getText());
                adminUser.setDOM(txtDOB.getText());
                adminUser.setGender(txtGender.getModel().getSelectedItem().toString());
                adminUser.setAdmin_role(txtAdminRole.getText());



                ManageUsers manageUser = new ManageUsers();
                boolean isDeleted = manageUser.delAdm(adminUser);
                if (isDeleted) {
                    txtID.setText("");
                    txtUsername.setText("");
                    txtPassword.setText("");
                    txtFirstName.setText("");
                    txtLastName.setText("");
                    txtMobile.setText("");
                    txtAddress.setText("");
                    txtAge.setText("");
                    txtEmail.setText("");
                    txtDOB.setText("");
                    txtGender.setSelectedItem("");
                    txtAdminRole.setText("");
                    JOptionPane.showMessageDialog(null, "User delete successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Failed to delete user ",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        AddAdmin addAdmin= new AddAdmin();
    }
}
