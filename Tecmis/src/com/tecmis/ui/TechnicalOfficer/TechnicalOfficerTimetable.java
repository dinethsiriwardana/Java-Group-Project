package com.tecmis.ui.TechnicalOfficer;

import com.tecmis.database.ManageTimetable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TechnicalOfficerTimetable extends JFrame {
    private JPanel pnlTimetable;
    private JLabel lbl2;
    private JButton downloadButton1;
    private JLabel lbl1;
    private JButton downloadButton2;
    private JLabel lbl3;
    private JButton downloadButton3;
    private JLabel lbl4;
    private JButton downloadButton4;
    private JLabel THeader;

    public TechnicalOfficerTimetable() throws Exception {
        add(pnlTimetable);
        setVisible(true);
        setTitle("Technical Officer Timetable");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1500,1500);
        setResizable(true);

        ManageTimetable manageTimetable = new ManageTimetable();

        downloadButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageTimetable.downlaodTimetable("ICTL1");
            }
        });


        downloadButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageTimetable.downlaodTimetable("ICTL2");

            }
        });


        downloadButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageTimetable.downlaodTimetable("ICTL3");

            }
        });


        downloadButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageTimetable.downlaodTimetable("ICTL4");

            }
        });
    }

    public static void main(String[] args) throws Exception {
        TechnicalOfficerTimetable timetable = new TechnicalOfficerTimetable();

    }
}
