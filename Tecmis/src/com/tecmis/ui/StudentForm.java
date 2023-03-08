package com.tecmis.ui;

import com.tecmis.database.Notices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentForm extends JFrame{


    private JButton btnTimeTable;
    private JButton btnCourseDetails;
    private JButton btnStudentAttendance;
    private JButton btnStudentResult;
    private JButton btnMedicalRecord;
    private JPanel pnlLecturer;
    private JLabel lblWelcomText;
    private JList list1;
    private JLabel lblNotices;

    public StudentForm() {
        add(pnlLecturer);
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
    }


    public static void main(String[] args) {
        StudentForm studentForm = new StudentForm();
        Notices notices = new Notices();
        JList<String> jlist = notices.main();
        studentForm.list1.setModel(jlist.getModel());

    }



}
