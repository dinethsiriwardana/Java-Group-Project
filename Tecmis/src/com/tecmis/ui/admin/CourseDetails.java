package com.tecmis.ui.admin;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseDetails extends JFrame {

    private JTextField textID;
    private JTextField textCourseName;
    private JTextField textCredit;
    private JTextField textCourseDepID;
    private JTable table1;
    private JButton ADDButton;
    private JButton DELETEButton;
    private JButton UPDATEButton;
    private JPanel panelCourse;
    private JTextField texCourseLecID;


    public CourseDetails(){
        add(panelCourse);
        setVisible(true);
        setTitle("Course Details...");
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


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
