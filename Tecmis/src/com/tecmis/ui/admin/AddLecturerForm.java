package com.tecmis.ui.admin;

import com.tecmis.database.ManageUsers;
import com.tecmis.dto.LecturerData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JTable table1;

    private JTextField txtUsername;
    private JTextField txtPassword;


    public AddLecturerForm() {
        add(pnlAdmin);
        setVisible(true);
        setTitle("Add Lecturer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setPreferredSize(new Dimension(220, 400));
        setResizable(false);

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LecturerData lecturerUser = new LecturerData();
                lecturerUser.setId(txtID.getText());
                lecturerUser.setFirstName(txtFirstName.getText());
                lecturerUser.setLastName(txtLastName.getText());
                lecturerUser.setMobile(txtMobile.getText());
                lecturerUser.setAddress(txtAddress.getText());
                lecturerUser.setAge(parseInt(txtAge.getText()));
                lecturerUser.setEmail(txtEmail.getText());
                lecturerUser.setDom(txtDOB.getText());
                lecturerUser.setGender(txtGender.getModel().getSelectedItem().toString());
                lecturerUser.setPosition(txtPosition.getModel().getSelectedItem().toString());
                lecturerUser.setPassword(txtPassword.getText());
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
                LecturerData lecturerUser = new LecturerData();
                lecturerUser.setId(txtID.getText());
                lecturerUser.setFirstName(txtFirstName.getText());
                lecturerUser.setLastName(txtLastName.getText());
                lecturerUser.setMobile(txtMobile.getText());
                lecturerUser.setAddress(txtAddress.getText());
                lecturerUser.setAge(parseInt(txtAge.getText()));
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
                    JOptionPane.showMessageDialog(null, "User updated successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                } else
                {
                    JOptionPane.showMessageDialog(null, "Failed to update user",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });



    }

    public static void main(String[] args) {

        AddLecturerForm addlec=new AddLecturerForm();
    }
}







