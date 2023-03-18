package com.tecmis.ui;

import com.tecmis.database.Auth;
import com.tecmis.database.UserLogin;
import com.tecmis.dto.User;
import com.tecmis.ui.lecture.LectureForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginForm extends JFrame {
    private JPanel pnlLogin;
    private JTextField txtUsername;
    private JTextField txtPwd;
    private JComboBox comboAccountType;
    private JButton btnReset;
    private JButton btnLogin;
    public LoginForm(){
        add(pnlLogin);
        setVisible(true);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250,400);
        setPreferredSize(new Dimension(220,400));
        setResizable(false);


        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            String username = txtUsername.getText();
            String password = txtPwd.getText();
            String acctype = comboAccountType.getModel().getSelectedItem().toString();

            UserLogin login = new UserLogin();

//                Student
//                Lecturer
//                Technical Officer
//                Admin
                try {
//                    boolean auth = login.userLogin(acctype,username,password);
//                    boolean auth = login.userLogin("Lecturer","lec001","lec001");
//                    acctype = "Lecturer";
//                    System.out.println(auth + acctype);
//                    if (auth && acctype == "Lecturer"){
//                        setVisible(false);
//                        // Create and show the LectureEditUser frame
//                        LectureForm lectureform = new LectureForm(username);
//                        lectureform.setVisible(true);
//                        // When the LectureEditUser frame is closed, show the LectureForm frame again
//                        lectureform.addWindowListener(new WindowAdapter() {
//                            @Override
//                            public void windowClosed(WindowEvent e) {
//                                super.windowClosed(e);
//                                setVisible(true);
//                            }
//                        });
//                    }

                    // TODO - Remove this Code after Finished

                    if (acctype == "Lecturer"){

                        Auth auth = Auth.getInstance();
                        auth.setUsername("lec001");
                        setVisible(false);
                        // Create and show the LectureEditUser frame
                        LectureForm lectureform = new LectureForm();
                        lectureform.setVisible(true);
                        // When the LectureEditUser frame is closed, show the LectureForm frame again
                        lectureform.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                super.windowClosed(e);
                                setVisible(true);
                            }
                        });
                    } else if (acctype == "Admin") {
//                        LectureForm lectureform = new LectureForm("admin001");
//                        lectureform.setVisible(true);
//                        // When the LectureEditUser frame is closed, show the LectureForm frame again
//                        lectureform.addWindowListener(new WindowAdapter() {
//                            @Override
//                            public void windowClosed(WindowEvent e) {
//                                super.windowClosed(e);
//                                setVisible(true);
//                            }
//                        });

                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
    }





}
