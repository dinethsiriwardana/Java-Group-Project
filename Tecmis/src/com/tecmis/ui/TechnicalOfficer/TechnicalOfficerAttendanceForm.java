package com.tecmis.ui.TechnicalOfficer;

import javax.swing.*;
import java.awt.*;

public class TechnicalOfficerAttendanceForm extends JFrame {
    private JPanel PanalTechnicalOfficer;
    private JTextField textField1;
    private JButton seachButton;
    private JButton addButton;
    private JButton updateButton;

    public TechnicalOfficerAttendanceForm(){
        add(PanalTechnicalOfficer);
        setVisible(true);
        setTitle("Technical Officer Attendance Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(800,1600));
        setResizable(false);
    }

    public static void main(String[] args) {
        TechnicalOfficerAttendanceForm techOfficerAttendance = new TechnicalOfficerAttendanceForm();
    }
}
