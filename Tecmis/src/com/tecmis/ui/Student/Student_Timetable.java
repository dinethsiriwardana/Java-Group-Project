package com.tecmis.ui.Student;

import javax.swing.*;

public class Student_Timetable {
    private JLabel THeader;
    private JLabel lbl1;
    private JButton downloadButton1;
    private JLabel lbl2;
    private JButton downloadButton2;
    private JLabel lbl3;
    private JButton downloadButton3;
    private JLabel lbl4;
    private JButton downloadButton4;


    downloadButton1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            byte[] pdfData = retrievePdfFromDatabase("Level1");


            savePdfToFile(pdfData, "Level1.pdf");
        }
    });

    downloadButton2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            byte[] pdfData = retrievePdfFromDatabase("Level2");


            savePdfToFile(pdfData, "Level2.pdf");
        }
    });

    downloadButton3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            byte[] pdfData = retrievePdfFromDatabase("Level3");


            savePdfToFile(pdfData, "Level3.pdf");
        }
    });

    downloadButton4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            byte[] pdfData = retrievePdfFromDatabase("Level4");


            savePdfToFile(pdfData, "Level4.pdf");
        }
    });

}
