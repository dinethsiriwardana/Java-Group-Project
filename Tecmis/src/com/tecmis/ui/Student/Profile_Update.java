package com.tecmis.ui.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile_Update {
    private JLabel UpdateProHeader;
    private JLabel lblStuID;
    private JTextField textStuFName;
    private JTextField textStuID;
    private JLabel lblFName;
    private JLabel lblLName;
    private JTextField textStuLName;
    private JLabel lblDOB;
    private JTextField textStuDOB;
    private JLabel lblStuEmail;
    private JTextField textStuEmail;
    private JButton updateButton;
    private JLabel lblImage;

    public Profile_Update() {
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id = textStuID.getText();
                String fName = textStuFName.getText();
                String lName = textStuLName.getText();
                String dob = textStuDOB.getText();
                String email = textStuEmail.getText();


                boolean isUpdated = updateProfileInfo(id, fName, lName, dob, email);


                if (isUpdated) {
                    JOptionPane.showMessageDialog(null, "Profile information updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update profile information.");
                }
            }
        });
    }

    private boolean updateProfileInfo(String id, String fName, String lName, String dob, String email) {

        return true;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Profile_Update");
        frame.setContentPane(new Profile_Update().UpdateProHeader);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
