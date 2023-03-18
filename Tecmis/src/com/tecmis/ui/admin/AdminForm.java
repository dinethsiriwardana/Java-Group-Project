package com.tecmis.ui.admin;

import com.tecmis.database.Notices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminForm extends JFrame{


    private JButton btnAddUser;
    private JButton btnAddLecturer;
    private JButton btnNoticeDetails;
    private JButton btnAddTechnicalOfficer;
    private JButton btnAddStudent;
    private JPanel pnlAdmin;
    private JLabel lblWelcomText;
    private JButton btnAddAdmin;
    private JList list1;
    private JButton btnCourseDetails;
    private JButton timeTableButton;
    private JLabel lblNotices;

    public AdminForm() {
        add(pnlAdmin);
        setVisible(true);
        setTitle("Admin");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,1500);
        setPreferredSize(new Dimension(220,400));
        setResizable(false);

        btnNoticeDetails.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }


    public static void main(String[] args) {
        AdminForm admin = new AdminForm();
        Notices notices = new Notices();
        JList<String> jlist = notices.main();
        admin.list1.setModel(jlist.getModel());

    }



}
