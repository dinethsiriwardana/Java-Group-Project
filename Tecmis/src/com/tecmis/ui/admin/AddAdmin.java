package com.tecmis.ui.admin;

import com.tecmis.database.ManageUsers;
import com.tecmis.dto.AdminData;
import com.tecmis.util.Security;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JTextField txtID;
    private JButton ADDButton;
    private JButton DELETEButton;
    private JButton UPDATEButton;
    private JTextField txtAdminRole;
    private JButton SEARCHButton;
    private JTable adminTable;
    private JButton backButton;

    public  AddAdmin(){
        add(pnlAdmin);
        setVisible(true);
        setTitle("Admin !!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,1500);
        setPreferredSize(new Dimension(220,400));
        setResizable(true);

        AdminData adminUser=new AdminData();
        Security security= new Security();

        try {
            adminTable.setModel(adminUser.showAdmin());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminData adminUser=new AdminData();
                adminUser.setID(txtID.getText());
                adminUser.setUsername(txtUsername.getText());
                try {
                    adminUser.setPassword(security.encryption(txtPassword.getText()));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
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

                    DefaultTableModel model=adminUser.showAdmin();
                    adminTable.setModel(model);

                    JOptionPane.showMessageDialog(null, "Admin added successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Failed to add Admin ",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtID.getText().isEmpty() || txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty() || txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() || txtMobile.getText().isEmpty() ||
                    txtAge.getText().isEmpty() || txtEmail.getText().isEmpty() || txtDOB.getText().isEmpty() ||
                    txtGender.getModel().getSelectedItem().toString().isEmpty() || txtAdminRole.getText().isEmpty())
                {

                    JOptionPane.showMessageDialog(null, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);

                }else{

                AdminData adminUser = new AdminData();

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
                try {
                    boolean isUpdated=manageUser.upAdm(adminUser);


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

                    DefaultTableModel model=adminUser.showAdmin();
                    adminTable.setModel(model);

                    JOptionPane.showMessageDialog(null, "Admin update successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);

                }catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to update Admin ",
                            "ERROR", JOptionPane.ERROR_MESSAGE);

                }
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

                    DefaultTableModel model=adminUser.showAdmin();
                    adminTable.setModel(model);

                    JOptionPane.showMessageDialog(null, "Admin delete successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Failed to delete Admin ",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        SEARCHButton.addActionListener(new ActionListener() {
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
                ResultSet userdata = manageUser.searchAdm(adminUser);
                try {
                    if (userdata.next()) {

                        txtID.setText(userdata.getString("ID"));
                        txtUsername.setText(userdata.getString("username"));
                        txtPassword.setText(userdata.getString("password"));
                        txtFirstName.setText(userdata.getString("Fname"));
                        txtLastName.setText(userdata.getString("Lname"));
                        txtMobile.setText(userdata.getString("Mobile"));
                        txtAddress.setText(userdata.getString("Address"));
                        txtAge.setText(userdata.getString("Age"));
                        txtEmail.setText(userdata.getString("Email"));
                        txtDOB.setText(userdata.getString("DOM"));
                        txtGender.setSelectedItem(userdata.getString("Gender"));
                        txtAdminRole.setText(userdata.getString("Admin_role"));
                        JOptionPane.showMessageDialog(null, "Admin search successfully",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Failed to search Admin ",
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
                AdminDashboard object = new AdminDashboard();
                object.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        AddAdmin addAdmin= new AddAdmin();
    }
}
