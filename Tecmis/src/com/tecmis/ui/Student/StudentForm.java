package com.tecmis.ui.Student;

import com.tecmis.database.Notices;
import com.tecmis.ui.lecture.LectureEditUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;


public class StudentForm extends JFrame{


    private JButton btnTimeTable;
    private JButton btnCourseDetails;
    private JButton btnStudentAttendance;
    private JButton btnStudentResult;
    private JButton btnMedicalRecord;
    private JPanel pnlStudent;
    private JLabel lblWelcomText;
    private JButton noticeButton;
    private JList list1;
    private JLabel setting;
    private JLabel lblNotices;

    public StudentForm() {
        add(pnlStudent);
        setVisible(true);
        setTitle("Student");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(false);
        onLoad();

        btnTimeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        btnCourseDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    setVisible(false);
                    // Create and show the LectureEditUser frame
                    Course_Details coursedetails = new Course_Details();

                    coursedetails.setVisible(true);
                    // When the LectureEditUser frame is closed, show the LectureForm frame again
                    coursedetails.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            super.windowClosed(e);
                            setVisible(true);
                        }
                    });
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnTimeTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    setVisible(false);
                    // Create and show the LectureEditUser frame
                    Student_Timetable studenttimetable = new Student_Timetable();


                    studenttimetable.setVisible(true);
                    // When the LectureEditUser frame is closed, show the LectureForm frame again
                    studenttimetable.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            super.windowClosed(e);
                            setVisible(true);
                        }
                    });
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnStudentAttendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    setVisible(false);
                    // Create and show the LectureEditUser frame
                    Student_Attendance studentattendance = new Student_Attendance();


                    studentattendance.setVisible(true);
                    // When the LectureEditUser frame is closed, show the LectureForm frame again
                    studentattendance.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            super.windowClosed(e);
                            setVisible(true);
                        }
                    });
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
//        btnStudentResult.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
//                Student_Marks studentmarks = new Student_Marks();
//                studentmarks.setVisible(true);
//            }
//        });
        btnMedicalRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible(false);
                    // Create and show the LectureEditUser frame
                    Medical_Details medicaldetails = new Medical_Details();

                    medicaldetails.setVisible(true);
                    // When the LectureEditUser frame is closed, show the LectureForm frame again
                    medicaldetails.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            super.windowClosed(e);
                            setVisible(true);
                        }
                    });
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        btnStudentAttendance.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        setting.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    setVisible(false);
                    // Create and show the LectureEditUser frame
                    Profile_Update profileUpdate = new  Profile_Update();
                    profileUpdate.setVisible(true);
                    // When the LectureEditUser frame is closed, show the LectureForm frame again
                    profileUpdate.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            super.windowClosed(e);
                            setVisible(true);
                        }
                    });
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



    }

    public void onLoad(){

        Notices notices = new Notices();
        JList<String> jlist = notices.main();
        list1.setModel(jlist.getModel());

    }










}
