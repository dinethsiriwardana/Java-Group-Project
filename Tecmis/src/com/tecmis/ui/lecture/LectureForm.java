package com.tecmis.ui.lecture;

import com.tecmis.database.Notices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LectureForm extends JFrame  {


    private JButton btnManageMaterials;
    private JButton btnStudentDetails;
    private JButton btnStudentEligibility;
    private JButton btnStudentResult;
    private JButton btnMedicalRecord;
    private JPanel pnlLecturer;
    private JLabel lblWelcomText;
    private JButton btnUploadMarks;
    private JList list1;
    private JLabel lblSetting;
    private JLabel lblNotices;

    private String username;

    static LectureForm lecForm;

    public LectureForm(String username) {
        this.username = username;
        add(pnlLecturer);
        setVisible(true);
        setTitle("Lecturer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(false);
        lecForm = this;



        onLoad();



        btnManageMaterials.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        lblSetting.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        lblSetting.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    setVisible(false);
                    // Create and show the LectureEditUser frame
                    LectureEditUser lecedit = new  LectureEditUser(username);
                    lecedit.setVisible(true);
                    // When the LectureEditUser frame is closed, show the LectureForm frame again
                    lecedit.addWindowListener(new WindowAdapter() {
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

        onLoad();
    }

    public static void main(String[] args) {

    }

 public void onLoad(){

     Notices notices = new Notices();
     JList<String> jlist = notices.main();
     lecForm.list1.setModel(jlist.getModel());

 }



}
