package com.tecmis.ui;
import com.tecmis.database.UserLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

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

                try {
                    boolean auth = login.userLogin(acctype,username,password);
                    System.out.println(auth);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
    }





}
