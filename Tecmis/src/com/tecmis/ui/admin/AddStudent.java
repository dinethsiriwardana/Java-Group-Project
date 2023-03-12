package com.tecmis.ui.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent extends JFrame{
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
    private JButton createButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JPanel pnlStudent;

public AddStudent(){
    add(pnlStudent);
    setVisible(true);
    setSize(1000,600);
    setTitle("Student Details!!!");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(220,400));
    setResizable(false);

    createButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}

    public static void main(String[] args) {
        AddStudent addstudent=new AddStudent();
    }

}
