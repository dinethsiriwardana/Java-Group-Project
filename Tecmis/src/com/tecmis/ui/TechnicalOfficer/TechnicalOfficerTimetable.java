package com.tecmis.ui.TechnicalOfficer;

import javax.swing.*;
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

        downloadButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        downloadButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        downloadButton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        downloadButton4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        TechnicalOfficerTimetable timetable = new TechnicalOfficerTimetable();

    }
}
