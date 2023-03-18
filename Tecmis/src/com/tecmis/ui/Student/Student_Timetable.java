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

            byte[] pdfData = retrievePdfFromDatabase("pdf1");


            savePdfToFile(pdfData, "pdf1.pdf");
        }
    });

    downloadButton2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            byte[] pdfData = retrievePdfFromDatabase("pdf2");


            savePdfToFile(pdfData, "pdf2.pdf");
        }
    });

    downloadButton3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            byte[] pdfData = retrievePdfFromDatabase("pdf3");


            savePdfToFile(pdfData, "pdf3.pdf");
        }
    });

    downloadButton4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            byte[] pdfData = retrievePdfFromDatabase("pdf4");


            savePdfToFile(pdfData, "pdf4.pdf");
        }
    });

}
