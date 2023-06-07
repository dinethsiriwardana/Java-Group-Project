package com.tecmis.ui.admin;

import com.tecmis.database.ManageUsers;
import com.tecmis.dto.TechnicalOfficerData;
import com.tecmis.util.Security;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddTechnicalOfficer extends JFrame{
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
    private JPanel pnlTechnicalOfficer;
    private JTextField txtUserName;
    private JTextField txtPassword;
    private JButton searchButton;
    private JTable toTable;
    private JButton backButton;


    public AddTechnicalOfficer(){
        add(pnlTechnicalOfficer);
        setVisible(true);
        setTitle("Admin !!!");
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        TechnicalOfficerData toUser=new TechnicalOfficerData();
        Security security=new Security();
        try {
            toTable.setModel(toUser.showTechnicalOfficer());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TechnicalOfficerData toUser=new TechnicalOfficerData();
                toUser.setId(txtID.getText());
                toUser.setUserName(txtUserName.getText());
                try {
                    toUser.setPassword(security.encryption(txtPassword.getText()));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                toUser.setFirstName(txtFirstName.getText());
                toUser.setLastName(txtLastName.getText());
                toUser.setMobile(txtMobile.getText());
                toUser.setAddress(txtAddress.getText());
                toUser.setAge((txtAge.getText()));
                toUser.setEmail(txtEmail.getText());
                toUser.setDom(txtDOB.getText());
                toUser.setGender(txtGender.getModel().getSelectedItem().toString());




                ManageUsers manageUser = new ManageUsers();
                boolean isAdded = manageUser.addTo(toUser);
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

                    DefaultTableModel model=toUser.showTechnicalOfficer();
                    toTable.setModel(model);

                    JOptionPane.showMessageDialog(null, "Technical officer added successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Failed to add Technical officer ",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtID.getText().isEmpty() || txtUserName.getText().isEmpty() || txtPassword.getText().isEmpty() ||
                   txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() || txtMobile.getText().isEmpty() || txtAge.getText().isEmpty() || txtEmail.getText().isEmpty() || txtDOB.getText().isEmpty() || txtGender.getModel().getSelectedItem().toString().isEmpty() )

                {
                 JOptionPane.showMessageDialog(null, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);}

                else {
                    TechnicalOfficerData updateTo = new TechnicalOfficerData();
                    updateTo.setId(txtID.getText());
                    updateTo.setUserName(txtUserName.getText());
                    updateTo.setPassword(txtPassword.getText());
                    updateTo.setFirstName(txtFirstName.getText());
                    updateTo.setLastName(txtLastName.getText());
                    updateTo.setMobile(txtMobile.getText());
                    updateTo.setAddress(txtAddress.getText());
                    updateTo.setAge(txtAge.getText());
                    updateTo.setEmail(txtEmail.getText());
                    updateTo.setDom(txtDOB.getText());
                    updateTo.setGender(txtGender.getModel().getSelectedItem().toString());

                    ManageUsers manageUser = new ManageUsers();
                    boolean isUpdated = manageUser.upTo(updateTo);
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

                        DefaultTableModel model = toUser.showTechnicalOfficer();
                        toTable.setModel(model);
                        JOptionPane.showMessageDialog(null, "Technical officer updated successfully",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update Technical officer ",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TechnicalOfficerData deleteTo=new TechnicalOfficerData();
                deleteTo.setId(txtID.getText());
                deleteTo.setUserName(txtUserName.getText());
                deleteTo.setPassword(txtPassword.getText());
                deleteTo.setFirstName(txtFirstName.getText());
                deleteTo.setLastName(txtLastName.getText());
                deleteTo.setMobile(txtMobile.getText());
                deleteTo.setAddress(txtAddress.getText());
                deleteTo.setAge((txtAge.getText()));
                deleteTo.setEmail(txtEmail.getText());
                deleteTo.setDom(txtDOB.getText());
                deleteTo.setGender(txtGender.getModel().getSelectedItem().toString());




                ManageUsers manageUser = new ManageUsers();
                boolean isDeleted = manageUser.delTo(deleteTo);
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

                    DefaultTableModel model=toUser.showTechnicalOfficer();
                    toTable.setModel(model);
                    JOptionPane.showMessageDialog(null, "Technical officer delete successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Failed to delete Technical officer ",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TechnicalOfficerData searchTo=new TechnicalOfficerData();
                searchTo.setId(txtID.getText());
                searchTo.setUserName(txtUserName.getText());
                searchTo.setPassword(txtPassword.getText());
                searchTo.setFirstName(txtFirstName.getText());
                searchTo.setLastName(txtLastName.getText());
                searchTo.setMobile(txtMobile.getText());
                searchTo.setAddress(txtAddress.getText());
                searchTo.setAge((txtAge.getText()));
                searchTo.setEmail(txtEmail.getText());
                searchTo.setDom(txtDOB.getText());
                searchTo.setGender(txtGender.getModel().getSelectedItem().toString());

                ManageUsers manageUser = new ManageUsers();
                ResultSet serachTec = manageUser.serchTo(searchTo);
                try {
                    if (serachTec.next()) {
                        txtID.setText(serachTec.getString("ID"));
                        txtUserName.setText(serachTec.getString("username"));
                        txtPassword.setText(serachTec.getString("password"));
                        txtFirstName.setText(serachTec.getString("Fname"));
                        txtLastName.setText(serachTec.getString("Lname"));
                        txtMobile.setText(serachTec.getString("Mobile"));
                        txtAddress.setText(serachTec.getString("Address"));
                        txtAge.setText(serachTec.getString("Age"));
                        txtEmail.setText(serachTec.getString("Email"));
                        txtDOB.setText(serachTec.getString("DOM"));
                        txtGender.setSelectedItem(serachTec.getString("Gender"));

                        JOptionPane.showMessageDialog(null, "Technical officer search successfully",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        
                        JOptionPane.showMessageDialog(null, "Failed to search Technical officer ",
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

        AddTechnicalOfficer addTo=new AddTechnicalOfficer();
    }
}
