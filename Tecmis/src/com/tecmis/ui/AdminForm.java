package com.tecmis.ui;

import com.tecmis.database.Notices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminForm extends JFrame{


    private JButton btnManageMaterials;
    private JButton btnStudentDetails;
    private JButton btnStudentEligibility;
    private JButton btnStudentResult;
    private JButton btnMedicalRecord;
    private JPanel pnlLecturer;
    private JLabel lblWelcomText;
    private JButton btnUploadMarks;
    private JList list1;
    private JLabel lblNotices;

    public AdminForm() {
        add(pnlLecturer);
        setVisible(true);
        setTitle("Lecturer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(false);

        btnManageMaterials.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }


    public static void main(String[] args) {
        AdminForm lec = new AdminForm();
        Notices notices = new Notices();
        JList<String> jlist = notices.main();
        lec.list1.setModel(jlist.getModel());

    }



}
