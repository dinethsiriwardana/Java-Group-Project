package com.tecmis.ui.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintainUser extends JFrame {
    private JPanel pnlUser;
    private JTextField textID;
    private JTextField textFirstName;
    private JTextField textLastName;
    private JTextField textMobile;
    private JTextArea textAddress;
    private JTextField textAge;
    private JTextField textEmail;
    private JTextField textDOB;
    private JComboBox comboBoxGender;
    private JTable table1;
    private JButton createUserButton;
    private JButton deleteUserButton;
    private JButton updateUserButton;


    public MaintainUser(){
        add(pnlUser);
        setVisible(true);
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

    public static void main(String[] args) {
        MaintainUser user=new MaintainUser();
    }
}
