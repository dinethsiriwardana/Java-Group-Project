package com.tecmis.ui.TechnicalOfficer;

import com.tecmis.database.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class TechnicalOfficerMedicalForm extends JFrame {
    private JPanel PanalTechnicalOfficer;

    private JButton addButton;
    private JButton clearButton;
    private JTextField tctSid;
    private JTextField txtCid;
    private JTextField txtDate;
    private JTextField txtMid;
    private JComboBox comboBox1;
    private JButton BackBtn;

    //    TechnicalOfficerMedicalForm technicalOfficerMedicalForm ;
    Connection conn;

    public TechnicalOfficerMedicalForm() throws Exception {
        add(PanalTechnicalOfficer);
        setVisible(true);
        setTitle("Technical Officer Medical Add/Update");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setPreferredSize(new Dimension(800, 1600));
        setResizable(true);

        conn = Database.getDatabaseConnection();

        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    String table;

                    switch (comboBox1.getModel().getSelectedItem().toString()) {
                        case "ICT01 T":
                            table = "ICT01_t_attendance";
                            break;
                        case "ICT02 T":
                            table = "ICT02_t_attendance";
                            break;
                        case "ICT02 P":
                            table = "ICT02_p_attendance";
                            break;
                        case "ICT03 T":
                            table = "ICT03_t_attendance";
                            break;
                        case "ICT03 P":
                            table = "ICT03_p_attendance";
                            break;
                        case "ICT04 T":
                            table = "ICT04_t_attendance";
                            break;
                        case "ICT04 P":
                            table = "ICT04_p_attendance";
                            break;
                        default:
                            table = "invalid option";
                            break;
                    }
                    String sql = "UPDATE " + table + " SET attend = 2, exDetails = 'Medical No " + txtMid.getText() + "' WHERE SID = '" + tctSid.getText() + "' AND date = '" + txtDate.getText() + "'";
                    System.out.println(sql);
                    Statement stmt = conn.createStatement();
                    int rowsAffected = stmt.executeUpdate(sql);
                    System.out.println("Rows updated: " + rowsAffected);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

        BackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                TechnicalOfficerDashBoard obj3 = new TechnicalOfficerDashBoard();
                obj3.setVisible(true);
            }
        });
;
        clearButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tctSid.setText("");
                tctSid.setText("");
                txtDate.setText("");
                //comboBox1.setText("");
                txtMid.setText("");

            }
        });
    }


    public static void main(String[] args) throws Exception {
        TechnicalOfficerMedicalForm techOfficerMedical = new TechnicalOfficerMedicalForm();
    }
}
