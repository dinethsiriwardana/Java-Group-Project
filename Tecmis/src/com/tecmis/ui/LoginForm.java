package com.tecmis.ui;

import com.tecmis.database.Auth;
import com.tecmis.database.UserLogin;
import com.tecmis.ui.Student.StudentForm;
import com.tecmis.ui.TechnicalOfficer.TechnicalOfficerDashBoard;
import com.tecmis.ui.TechnicalOfficer.TechnicalOfficerProfile;
import com.tecmis.ui.TechnicalOfficer.ToForm;
import com.tecmis.ui.admin.AdminDashboard;
import com.tecmis.ui.lecture.LectureEditUser;
import com.tecmis.ui.lecture.LectureForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

public class LoginForm extends JFrame {
    private JPanel pnlLogin;
    private JTextField txtUsername;
    private JTextField txtPwd;
    private JComboBox comboAccountType;
    private JButton btnReset;
    private JButton btnLogin;
    private JPasswordField passwordField1;

    public LoginForm() {
        add(pnlLogin);
        setVisible(true);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 400);
        setPreferredSize(new Dimension(220, 400));
//        setResizable(false);


        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String username = txtUsername.getText();
                String password = passwordField1.getText();
                String acctype = comboAccountType.getModel().getSelectedItem().toString();

                UserLogin login = new UserLogin();
                System.out.println("Logging ....");
                try {
                    boolean isCorrect = login.userLogin(acctype, username, password);

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
                            StudentForm studentForm = new StudentForm();
                            studentForm.setVisible(true);
                            studentForm.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent e) {
                                    super.windowClosed(e);
                                    setVisible(true);
                                }
                            });
                        } else if (acctype == "Technical Officer") {
                            setVisible(false);
                            TechnicalOfficerDashBoard toForm = new TechnicalOfficerDashBoard();
                            toForm.setVisible(true);
                            toForm.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent e) {
                                    super.windowClosed(e);
                                    setVisible(true);
                                }
                            });
                        }else if (acctype == "Admin") {
                            setVisible(false);
                            AdminDashboard adminForm = new AdminDashboard();
                            adminForm.setVisible(true);
                            adminForm.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent e) {
                                    super.windowClosed(e);
                                    setVisible(true);
                                }
                            });
                        }
                    }else {
                        URL imageUrl = LectureEditUser.class.getResource("/com/tecmis/assets/fac_logo.png");
                        Icon icon = new ImageIcon(imageUrl);
                        JOptionPane.showMessageDialog(null, "Incorrect Detalis", "Error", JOptionPane.ERROR_MESSAGE, icon);

                    }


                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
    }


}
