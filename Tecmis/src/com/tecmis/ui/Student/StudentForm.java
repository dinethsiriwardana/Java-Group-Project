package com.tecmis.ui.Student;

import com.tecmis.database.Notices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private JLabel lblNotices;

    public StudentForm() {
        add(pnlStudent);
        setVisible(true);
        setTitle("Student");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(false);

        btnTimeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        noticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                StudentNotice notice = new StudentNotice();
                notice.setVisible(true);
            }
        });
        btnCourseDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Course_Details coursedetails = new Course_Details();
                coursedetails.setVisible(true);
            }
        });
        btnTimeTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Student_Timetable studenttimetable = new Student_Timetable();
                studenttimetable.setVisible(true);
            }
        });
        /*btnStudentAttendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Student_Attendance studentattendance = new Student_Attendance();
                studentattendance.setVisible(true);
            }
        });
        btnStudentResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Student_Marks studentmarks = new Student_Marks();
                studentmarks.setVisible(true);
            }
        });*/
        btnMedicalRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Medical_Details medicaldetails = new Medical_Details();
                medicaldetails.setVisible(true);
            }
        });
    }



    public static void main(String[] args) {
        StudentForm studentForm = new StudentForm();
        /*Notices notices = new Notices();
        JList<String> jlist = notices.main();
        studentForm.list1.setModel(jlist.getModel());*/

    }






}
