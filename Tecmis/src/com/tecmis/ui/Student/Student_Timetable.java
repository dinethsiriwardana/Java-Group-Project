package com.tecmis.ui.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student_Timetable extends JFrame{
    private JLabel THeader;
    private JLabel lbl1;
    private JButton downloadButton1;
    private JLabel lbl2;
    private JButton downloadButton2;
    private JLabel lbl3;
    private JButton downloadButton3;
    private JLabel lbl4;
    private JButton downloadButton4;
    private JPanel pnlTimetable;


    public Student_Timetable() {
        add(pnlTimetable);
        setVisible(true);
        setTitle("Student !!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,1500);
        setPreferredSize(new Dimension(220,400));
        setResizable(true);

    }

    public static void main(String[] args) {
        Student_Timetable timetable=new Student_Timetable();
    }
}
