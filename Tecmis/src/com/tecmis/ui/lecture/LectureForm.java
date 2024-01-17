package com.tecmis.ui.lecture;

import com.tecmis.database.Auth;
import com.tecmis.database.Notices;
import com.tecmis.ui.LoginForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class LectureForm extends JFrame  {



    private JButton btnStudentDetails;
    private JButton btnStudentResult;
    private JButton btnMedicalRecord;
    private JPanel pnlLecturer;
    private JLabel lblWelcomText;
    private JButton btnUploadMarks;
    private JList list1;
    private JLabel lblSetting;
    private JLabel btnLogout;
    private JLabel lblNotices;

    private String username;

    static LectureForm lecForm;
    JProgressBar progressBar;

    public LectureForm() {
//        this.username = username;
        add(pnlLecturer);
        setVisible(true);
        setTitle("Lecturer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(false);

        lecForm = this;
        Auth auth = Auth.getInstance();

        onLoad();



        lblSetting.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    setVisible(false);
                    // Create and show the LectureEditUser frame
                    LectureEditUser lecedit = new  LectureEditUser();
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


        btnStudentDetails.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    setVisible(false);
                    // Create and show the LectureEditUser frame
                    LectureStudentDetails lefcstudentdetails = new  LectureStudentDetails();
                    lefcstudentdetails.setVisible(true);
                    // When the LectureEditUser frame is closed, show the LectureForm frame again
                    lefcstudentdetails.addWindowListener(new WindowAdapter() {
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
                    LectureStudentAttendance lectureStudentAttendance = new  LectureStudentAttendance();
                    lectureStudentAttendance.setVisible(true);
                    lectureStudentAttendance.addWindowListener(new WindowAdapter() {
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
        btnLogout.addMouseListener(new MouseAdapter() {
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
        btnUploadMarks.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    setVisible(false);

                    LectureStudentResult lectureStudentResult = new LectureStudentResult();
                    lectureStudentResult.setVisible(true);
                    lectureStudentResult.addWindowListener(new WindowAdapter() {
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


        btnStudentResult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try{
                    setVisible(false);

                    LectureStudentResultView lectureStudentResultView = new LectureStudentResultView();
                    lectureStudentResultView.setVisible(true);
                    lectureStudentResultView.addWindowListener(new WindowAdapter() {
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

}
