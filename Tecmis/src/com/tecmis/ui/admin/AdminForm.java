package com.tecmis.ui.admin;

import com.tecmis.database.Notices;
import com.tecmis.ui.lecture.LectureForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminForm extends JFrame{


    private JButton btnAddUser;
    private JButton btnAddLecturer ;
    private JButton btnNoticeDetails;
    private JButton btnAddTechnicalOfficer;
    private JButton btnAddStudent;
    private JPanel pnlAdmin;
    private JLabel lblWelcomText;
    private JButton btnAddAdmin;
    private JButton btnCourseDetails;
    private JButton timeTableButton;
    private JLabel lblNotices;

    private String username;
    static AdminForm adminForm;

    public AdminForm() {

        add(pnlAdmin);
        setVisible(true);
        setTitle("Admin");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setPreferredSize(new Dimension(220, 400));
        setResizable(true);


    }
    public static void main(String[] args) {
        AdminForm adminForm=new AdminForm();

    }



}
