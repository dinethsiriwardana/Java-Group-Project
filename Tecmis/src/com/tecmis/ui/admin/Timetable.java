package com.tecmis.ui.admin;

import com.tecmis.database.ManageTimetable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Timetable extends JFrame {
    private JPanel pnlUser;
    private JTextField txtTime_ID;
    private JTable table1;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JPanel pnlTimetable;
    private JComboBox txtLevel;
    private JButton uploadButton;
    private JComboBox txtDepartment;

    public Timetable(){
        add(pnlTimetable);
        setVisible(true);
        setSize(1000,600);
        setTitle("Timetable!!!");

        setDefaultCloseOperation(EXIT_ON_CLOSE);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ManageTimetable.addTimetable();
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        Timetable timetable=new Timetable();
    }
}
