package com.tecmis.ui.TechnicalOfficer;

import com.tecmis.database.Auth;
import com.tecmis.database.Notices;
import com.tecmis.ui.LoginForm;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ToForm extends JFrame{


    private JButton btnManageMaterials;
    private JButton btnStudentEligibility;
    private JButton btnMedicalRecord;
    private JPanel pnlLecturer;
    private JLabel lblWelcomText;
    private JList list1;
    private JLabel btnlogout;
    private JLabel setting;
    private JLabel lblNotices;
    static  ToForm toForm;

    public ToForm() {
        add(pnlLecturer);
        setVisible(true);
        setTitle("Tecnical Officer Notice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(true);
        Auth auth = Auth.getInstance();
        toForm = this;
        onLoad();


        btnlogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    setVisible(false);
                    auth.setUsername("");
                    LoginForm loginForm = new LoginForm();
                    loginForm.setVisible(true);
                    loginForm.addWindowListener(new WindowAdapter() {
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
        btnStudentEligibility.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    setVisible(false);
                    TechnicalOfficerAttendanceForm technicalOfficerAttendanceForm = new TechnicalOfficerAttendanceForm();
                    technicalOfficerAttendanceForm.setVisible(true);
                    technicalOfficerAttendanceForm.addWindowListener(new WindowAdapter() {
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
        btnMedicalRecord.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    setVisible(false);
                    TechnicalOfficerMedicalForm technicalOfficerMedicalForm = new TechnicalOfficerMedicalForm();
                    technicalOfficerMedicalForm.setVisible(true);
                    technicalOfficerMedicalForm.addWindowListener(new WindowAdapter() {
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
        setting.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    setVisible(false);
                    // Create and show the LectureEditUser frame
                    TechnicalOfficerProfile technicalOfficerForm = new  TechnicalOfficerProfile();
                    technicalOfficerForm.setVisible(true);
                    // When the LectureEditUser frame is closed, show the LectureForm frame again
                    technicalOfficerForm.addWindowListener(new WindowAdapter() {
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

    public static void main(String[] args) {
        ToForm toForm1 = new ToForm();
    }


}
