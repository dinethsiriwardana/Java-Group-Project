package com.tecmis.ui.TechnicalOfficer;

import javax.swing.*;
import java.awt.*;

public class TechnicalOfficerTimetableForm extends JFrame {
    private JPanel PanalTechnicalOfficer;
    private JButton downloadButton1;
    private JButton downloadButton2;
    private JButton downloadButton3;
    private JButton downloadButton;
    private JComboBox comboBox1;

    public TechnicalOfficerTimetableForm(){
        add(PanalTechnicalOfficer);
        setVisible(true);
        setTitle("Technical Officer Timetable");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(800,1600));
        setResizable(false);
    }

    public static void main(String[] args) {
        TechnicalOfficerTimetableForm techOfficerMedical = new TechnicalOfficerTimetableForm();
    }
}
