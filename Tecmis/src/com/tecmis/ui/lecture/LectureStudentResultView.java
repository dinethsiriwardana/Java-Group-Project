package com.tecmis.ui.lecture;

import com.tecmis.database.Database;
import com.tecmis.dto.StudentResult;
import com.tecmis.dto.SubjectDetails;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.Arrays;


public class LectureStudentResultView extends JFrame{
    private JPanel pnlLecStuResult;
    private JComboBox comboBox1;
    private JButton btnUploadMarks;
    private JTable table1;
    Connection connection;

    public LectureStudentResultView() throws Exception {
        add(pnlLecStuResult);
        setVisible(true);
        setTitle("Student Result");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000, 600);
        setPreferredSize(new Dimension(220, 400));
        setResizable(false);

        SubjectDetails subjectDetails = new SubjectDetails();
        comboBox1.setModel(subjectDetails.getSubjectModel());

        btnUploadMarks.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("ss");

                try {
                    StudentResult studentResult = new StudentResult(comboBox1.getModel().getSelectedItem().toString());
                    table1.setModel(studentResult.showResult());

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }



            }
        });
    }


    public static void main(String[] args) throws Exception {
        LectureStudentResultView lectureStudentResultView = new LectureStudentResultView();
    }





}
