package com.tecmis.ui.TechnicalOfficer;

import javax.swing.*;
import java.awt.*;

public class TechnicalOfficerMedicalForm extends JFrame {
    private JPanel PanalTechnicalOfficer;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton addButton;
    private JButton updateButton;

    public TechnicalOfficerMedicalForm(){
        add(PanalTechnicalOfficer);
        setVisible(true);
        setTitle("Technical Officer Medical Add/Update");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(800,1600));
        setResizable(false);
    }

    public static void main(String[] args) {
        TechnicalOfficerMedicalForm techOfficerMedical = new TechnicalOfficerMedicalForm();
    }
}
