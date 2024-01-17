package com.tecmis.ui.TechnicalOfficer;

import com.tecmis.database.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class TechnicalOfficerAttendanceForm extends JFrame {
    private JPanel PanalTechnicalOfficer;
    private JTextField txtSid;
    private JButton searchButton;
    private JButton addButton;
    private JButton updateButton;
    private JComboBox comboBox1;
    private JTextField txtDate;
    private JTextField txtAttend;
    private JTextField txtexDetails;
    private JButton BackButton;
    private JTextArea textArea1;
    Connection conn;


    public TechnicalOfficerAttendanceForm() throws Exception {
        add(PanalTechnicalOfficer);
        setVisible(true);
        setTitle("Technical Officer Attendance Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600,450);
        setResizable(true);

        conn = Database.getDatabaseConnection();


        updateButton.addMouseListener(new MouseAdapter() {
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
                    String sql = "UPDATE " + table + " SET attend = "+txtAttend.getText()+", exDetails = '' WHERE SID = '" + txtSid.getText() + "' AND date = '" + txtDate.getText() + "'";
                    System.out.println(sql);
                    Statement stmt = conn.createStatement();
                    int rowsAffected = stmt.executeUpdate(sql);
                    System.out.println("Rows updated: " + rowsAffected);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
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
                    String sql = "Insert Into " + table + " VALUE ('" + txtSid.getText() + "','" + txtDate.getText() + "'," +txtAttend.getText()+",'"+txtexDetails.getText()+"')";
                    System.out.println(sql);
                    Statement stmt = conn.createStatement();
                    int rowsAffected = stmt.executeUpdate(sql);
                    System.out.println("Rows updated: " + rowsAffected);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        updateButton.addMouseListener(new MouseAdapter() {
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
                    String sql = "UPDATE " + table + " SET attend = "+txtAttend.getText()+", exDetails = '' WHERE SID = '" + txtSid.getText() + "' AND date = '" + txtDate.getText() + "'";
                    System.out.println(sql);
                    Statement stmt = conn.createStatement();
                    int rowsAffected = stmt.executeUpdate(sql);
                    System.out.println("Rows updated: " + rowsAffected);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                TechnicalOfficerDashBoard obj2 = new TechnicalOfficerDashBoard();
                obj2.setVisible(true);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        TechnicalOfficerAttendanceForm technicalOfficerAttendanceForm = new TechnicalOfficerAttendanceForm();
    }
}