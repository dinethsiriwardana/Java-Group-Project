package com.tecmis.ui.admin;

import javax.swing.*;
import java.awt.*;

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

    }

    public static void main(String[] args) {
        AdminForm adminForm=new AdminForm();
    }
}
