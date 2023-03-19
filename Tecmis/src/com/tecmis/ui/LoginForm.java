package com.tecmis.ui;

import com.tecmis.database.Auth;
import com.tecmis.database.UserLogin;
import com.tecmis.dto.User;
//import com.tecmis.ui.TechnicalOfficer.TechnicalOfficerForm;
import com.tecmis.ui.admin.AdminForm;
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

    public LoginForm() {
        add(pnlLogin);
        setVisible(true);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 400);
        setPreferredSize(new Dimension(220, 400));
        setResizable(false);


        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String username = txtUsername.getText();
                String password = txtPwd.getText();
                String acctype = comboAccountType.getModel().getSelectedItem().toString();

                UserLogin login = new UserLogin();
                Auth auth = Auth.getInstance();

//                Student
//                Lecturer
//                Technical Officer
//                Admin
                try {
                    boolean isCorrect = login.userLogin(acctype, username, password);
                    acctype = "Lecturer";
                    System.out.println(auth + acctype);
                    if (isCorrect) {

                        if (acctype == "Lecturer") {
                            setVisible(false);
                            LectureForm lectureform = new LectureForm();
                            lectureform.setVisible(true);
                            lectureform.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent e) {
                                    super.windowClosed(e);
                                    setVisible(true);
                                }
                            });
                        } else if (acctype == "Student") {
                            setVisible(false);
//                            LectureForm lectureform = new LectureForm();
//                            lectureform.setVisible(true);
//                            lectureform.addWindowListener(new WindowAdapter() {
//                                @Override
//                                public void windowClosed(WindowEvent e) {
//                                    super.windowClosed(e);
//                                    setVisible(true);
//                                }
//                            });
                        } else if (acctype == "Technical Officer") {
                            setVisible(false);
//                            TechnicalOfficerForm technicalOfficerForm = new TechnicalOfficerForm();
//                            technicalOfficerForm.setVisible(true);
//                            technicalOfficerForm.addWindowListener(new WindowAdapter() {
//                                @Override
//                                public void windowClosed(WindowEvent e) {
//                                    super.windowClosed(e);
//                                    setVisible(true);
//                                }
//                            });
                        }else if (acctype == "Admin") {
                            setVisible(false);
                            AdminForm adminForm = new AdminForm();
                            adminForm.setVisible(true);
                            adminForm.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent e) {
                                    super.windowClosed(e);
                                    setVisible(true);
                                }
                            });
                        }
                    }


                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
    }


}
