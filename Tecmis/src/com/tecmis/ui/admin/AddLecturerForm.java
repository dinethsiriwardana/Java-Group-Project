package com.tecmis.ui.admin;

import com.tecmis.database.ManageUsers;
import com.tecmis.dto.LecturerData;
import com.tecmis.util.Security;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class AddLecturerForm extends JFrame {


    private JPanel pnlAdmin;
    private JTextField txtID;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtMobile;
    private JTextArea txtAddress;
    private JTextField txtAge;
    private JTextField txtEmail;
    private JTextField txtDOB;
    private JComboBox txtGender;
    private JComboBox txtPosition;
    private JButton ADDButton;
    private JButton DELETEButton;
    private JButton UPDATEButton;

    private JTextField txtUsername;
    private JTextField txtPassword;
    private JButton SEARCHButton;
    private JTable lecturerTable;
    private JButton backButton;


    public AddLecturerForm() {
        add(pnlAdmin);
        setVisible(true);
        setTitle("Add Lecturer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setPreferredSize(new Dimension(220, 400));
        LecturerData lecturerUser=new LecturerData();
        Security security=new Security();
        try {
            lecturerTable.setModel(lecturerUser.showLecturer());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LecturerData lecturerUser = new LecturerData();
                lecturerUser.setId(txtID.getText());
                lecturerUser.setFirstName(txtFirstName.getText());
                lecturerUser.setLastName(txtLastName.getText());
                lecturerUser.setMobile(txtMobile.getText());
                lecturerUser.setAddress(txtAddress.getText());
                lecturerUser.setAge((txtAge.getText()));
                lecturerUser.setEmail(txtEmail.getText());
                lecturerUser.setDom(txtDOB.getText());
                lecturerUser.setGender(txtGender.getModel().getSelectedItem().toString());
                lecturerUser.setPosition(txtPosition.getModel().getSelectedItem().toString());

                try {
                    lecturerUser.setPassword(security.encryption(txtPassword.getText()));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                lecturerUser.setUsername(txtUsername.getText());


                ManageUsers manageUser = new ManageUsers();
                boolean isAdded = manageUser.addUser(lecturerUser);
                if (isAdded) {
                    txtID.setText("");
                    txtFirstName.setText("");
                    txtLastName.setText("");
                    txtMobile.setText("");
                    txtAddress.setText("");
                    txtAge.setText("");
                    txtEmail.setText("");
                    txtDOB.setText("");
                    txtGender.setSelectedItem("");
                    txtPosition.setSelectedItem("");
                    txtPassword.setText("");
                    txtUsername.setText("");

                    DefaultTableModel model=lecturerUser.showLecturer();
                    lecturerTable.setModel(model);
                    JOptionPane.showMessageDialog(null, "Lecturer added successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Failed to add Lecturer ",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LecturerData lecturerUser = new LecturerData();
                lecturerUser.setId(txtID.getText());
                lecturerUser.setPassword(txtPassword.getText());
                lecturerUser.setUsername(txtUsername.getText());
                lecturerUser.setFirstName(txtFirstName.getText());
                lecturerUser.setLastName(txtLastName.getText());
                lecturerUser.setMobile(txtMobile.getText());
                lecturerUser.setAddress(txtAddress.getText());
                lecturerUser.setAge(txtAge.getText());
                lecturerUser.setEmail(txtEmail.getText());
                lecturerUser.setDom(txtDOB.getText());
                lecturerUser.setGender(txtGender.getModel().getSelectedItem().toString());
                lecturerUser.setPosition(txtPosition.getModel().getSelectedItem().toString());


                ManageUsers manageUser = new ManageUsers();
                boolean isDeleted = manageUser.deleteUser(lecturerUser);
                if (isDeleted) {
                    txtID.setText("");
                    txtPassword.setText("");
                    txtUsername.setText("");
                    txtFirstName.setText("");
                    txtLastName.setText("");
                    txtMobile.setText("");
                    txtAddress.setText("");
                    txtAge.setText("");
                    txtEmail.setText("");
                    txtDOB.setText("");
                    txtGender.setSelectedItem("");
                    txtPosition.setSelectedItem("");

                    DefaultTableModel model=lecturerUser.showLecturer();
                    lecturerTable.setModel(model);

                    JOptionPane.showMessageDialog(null, "Lecturer deleted successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                } else
                {
                    JOptionPane.showMessageDialog(null, "Failed to delete Lecturer",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LecturerData lecturerUser = new LecturerData();
                lecturerUser.setId(txtID.getText());
                lecturerUser.setFirstName(txtFirstName.getText());
                lecturerUser.setLastName(txtLastName.getText());
                lecturerUser.setMobile(txtMobile.getText());
                lecturerUser.setAddress(txtAddress.getText());
                lecturerUser.setAge((txtAge.getText()));
                lecturerUser.setEmail(txtEmail.getText());
                lecturerUser.setDom(txtDOB.getText());
                lecturerUser.setGender(txtGender.getModel().getSelectedItem().toString());
                lecturerUser.setPosition(txtPosition.getModel().getSelectedItem().toString());
                lecturerUser.setPassword(txtPassword.getText());
                lecturerUser.setUsername(txtUsername.getText());


                ManageUsers manageUser = new ManageUsers();
                boolean isUpdated = manageUser.updateUser(lecturerUser);
                if (isUpdated) {
                    txtID.setText("");
                    txtFirstName.setText("");
                    txtLastName.setText("");
                    txtMobile.setText("");
                    txtAddress.setText("");
                    txtAge.setText("");
                    txtEmail.setText("");
                    txtDOB.setText("");
                    txtGender.setSelectedItem("");
                    txtPosition.setSelectedItem("");
                    txtPassword.setText("");
                    txtUsername.setText("");

                    DefaultTableModel model=lecturerUser.showLecturer();
                    lecturerTable.setModel(model);

                    JOptionPane.showMessageDialog(null, "Lecturer update successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Failed to update Lecturer ",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LecturerData lecturerUser = new LecturerData();
                lecturerUser.setId(txtID.getText());
                lecturerUser.setFirstName(txtFirstName.getText());
                lecturerUser.setLastName(txtLastName.getText());
                lecturerUser.setMobile(txtMobile.getText());
                lecturerUser.setAddress(txtAddress.getText());
                lecturerUser.setAge((txtAge.getText()));
                lecturerUser.setEmail(txtEmail.getText());
                lecturerUser.setDom(txtDOB.getText());
                lecturerUser.setGender(txtGender.getModel().getSelectedItem().toString());
                lecturerUser.setPosition(txtPosition.getModel().getSelectedItem().toString());
                lecturerUser.setPassword(txtPassword.getText());
                lecturerUser.setUsername(txtUsername.getText());

                ManageUsers manageUser = new ManageUsers();
                ResultSet lecSearch = manageUser.serchUser(lecturerUser);
                try {
                    if (lecSearch.next()) {

                        txtID.setText(lecSearch.getString("ID"));
                        txtUsername.setText(lecSearch.getString("username"));
                        txtPassword.setText(lecSearch.getString("password"));
                        txtFirstName.setText(lecSearch.getString("Fname"));
                        txtLastName.setText(lecSearch.getString("Lname"));
                        txtMobile.setText(lecSearch.getString("Mobile"));
                        txtAddress.setText(lecSearch.getString("Address"));
                        txtAge.setText(lecSearch.getString("Age"));
                        txtEmail.setText(lecSearch.getString("Email"));
                        txtDOB.setText(lecSearch.getString("DOM"));
                        txtGender.setSelectedItem(lecSearch.getString("Gender"));
                        txtPosition.setSelectedItem(lecSearch.getString("Position"));

                        JOptionPane.showMessageDialog(null, "Lecturer search successfully",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Failed to search Lecturer ",
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

        AddLecturerForm addlec=new AddLecturerForm();
    }
}







