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
    }


    public static void main(String[] args) {
        StudentForm studentForm = new StudentForm();
        Notices notices = new Notices();
        JList<String> jlist = notices.main();
        studentForm.list1.setModel(jlist.getModel());

    }






}
