package com.tecmis.ui.TechnicalOfficer;

import javax.swing.*;
import java.awt.*;

public class TechnicalOfficerForm extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel PanalTechnicalOfficer;
    private JButton submitButton;
    private JButton cancelButton;

    public TechnicalOfficerForm(){
        add(PanalTechnicalOfficer);
        setVisible(true);
        setTitle("Technical Officer Profile Update");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(800,1600));
        setResizable(false);
    }

    public static void main(String[] args) {
        TechnicalOfficerForm techOfficer = new TechnicalOfficerForm();
    }

}
