package com.tecmis.ui.admin;

import javax.swing.*;
import java.awt.*;

public class Timetable extends JFrame {
    private JPanel pnlUser;
    private JTextField txtTime_ID;
    private JTable table1;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JPanel pnlTimetable;
    private JComboBox txtLevel;
    private JButton downloadButton;
    private JComboBox txtDepartment;

    public Timetable(){
        add(pnlTimetable);
        setVisible(true);
        setSize(1000,600);
        setTitle("Timetable!!!");
        setPreferredSize(new Dimension(220,400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {
        Timetable timetable=new Timetable();
    }
}
