package com.tecmis.ui.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseDetails  extends JFrame {
    private JTextField textID;
    private JTextField textFirstName;
    private JTextField textLastName;
    private JTextField textMobile;
    private JTable table1;
    private JButton ADDButton;
    private JButton DELETEButton;
    private JButton UPDATEButton;
    private JTextField textLecturerId;
    private JPanel pnlCourse;
    private JPanel panelCourse;

    public CourseDetails(){

        add(panelCourse);
        setVisible(true);
        setTitle("View Course Details");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(false);


        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }



    public static void main(String[] args) {
        CourseDetails coursedetail=new CourseDetails();

    }
}
