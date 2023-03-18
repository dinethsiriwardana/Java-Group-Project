package com.tecmis.ui.TechnicalOfficer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentMarks {
    private JLabel txtHeader;
    private JLabel lblID;
    private JLabel lblSub1;
    private JLabel lblSub2;
    private JLabel lblSub3;
    private JTextField textID;
    private JTextField textSub1;
    private JTextField textSub2;
    private JTextField textSub3;
    private JLabel lblSub4;
    private JTextField textSub4;
    private JButton calculateButton;
    private JLabel lblGpa;
    private JTextField textGPA;
    private JPanel PnlMrak;
    private JButton showResultsButton;
    private JLabel lblSub5;
    private JTextField textSub5;
    private JLabel lblSub6;
    private JTextField textSub6;

    public static void main(String[] args) {
        JFrame frame = new JFrame("StudentMarks");
        frame.setContentPane(new StudentMarks().PnlMrak);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public StudentMarks() {
    calculateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {



        }
    });
}
}
