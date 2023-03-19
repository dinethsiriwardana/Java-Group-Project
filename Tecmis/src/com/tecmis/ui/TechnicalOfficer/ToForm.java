package com.tecmis.ui;

import com.tecmis.database.Notices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToForm extends JFrame{


    private JButton btnManageMaterials;
    private JButton btnStudentDetails;
    private JButton btnStudentEligibility;
    private JButton btnMedicalRecord;
    private JPanel pnlLecturer;
    private JLabel lblWelcomText;
    private JButton btnUploadMarks;
    private JList list1;
    private JLabel lblNotices;

    public ToForm() {
        add(pnlLecturer);
        setVisible(true);
        setTitle("Lecturer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(false);


    }


    public static void main(String[] args) {
        ToForm to = new ToForm();
        Notices notices = new Notices();
        JList<String> jlist = notices.main();
        to.list1.setModel(jlist.getModel());

    }



}