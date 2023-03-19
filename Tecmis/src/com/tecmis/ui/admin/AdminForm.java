package com.tecmis.ui.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminForm extends  JFrame

{
    private JPanel pnlAdmin;
    private JButton addAdminButton;
    private JButton manageCourseButton;
    private JButton addLecturerButton;
    private JButton manageNoticeButton;
    private JButton addTechnicalOfficerButton;
    private JButton manageTimetableButton;
    private JButton addStudentButton;
    private JLabel lblWelcomText;
    private JLabel lblSetting;

    public  AdminForm() {
        add(pnlAdmin);

        setVisible(true);

        setTitle("Admin Form!!!");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(1000,600);

        setPreferredSize(new Dimension(220, 400));

        addAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddAdmin object=new AddAdmin();
                object.setVisible(true);

            }
        });
        addLecturerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddLecturerForm object=new AddLecturerForm();
                object.setVisible(true);
            }
        });
        addTechnicalOfficerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddTechnicalOfficer object=new AddTechnicalOfficer();
                object.setVisible(true);
            }
        });
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AddStudent object=new AddStudent();
                object.setVisible(true);

            }
        });
        manageCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                CourseDetails object= null;
                try {
                    object = new CourseDetails();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                object.setVisible(true);
            }
        });
        manageNoticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                NoticeDetails object= null;
                try {
                    object = new NoticeDetails();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);

                }
                setVisible(true);
            }
        });
        manageTimetableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Timetable object=new Timetable();
                object.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        AdminForm adminForm=new AdminForm();
    }
}
