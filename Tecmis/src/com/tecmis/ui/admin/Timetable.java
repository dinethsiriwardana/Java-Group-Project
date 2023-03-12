package com.tecmis.ui.admin;

import javax.swing.*;
import java.awt.*;

public class Timetable extends JFrame {
    private JPanel pnlUser;
    private JTextField textTime_ID;
    private JTextField textDay;
    private JTextField textHours;
    private JTextField textLocation;
    private JTable table1;
    private JButton createButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JPanel pnlTimetable;
    private JComboBox comboBoxType;

    public Timetable(){
        add(pnlTimetable);
        setVisible(true);
        setSize(1000,600);
        setTitle("Timetable!!!");
        setPreferredSize(new Dimension(220,400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

    }

    public static void main(String[] args) {
        Timetable timetable=new Timetable();
    }
}
