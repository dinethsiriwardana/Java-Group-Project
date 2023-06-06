package com.tecmis.ui.lecture;

import com.tecmis.dto.StudentResult;
import com.tecmis.dto.SubjectDetails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class LectureCalMarks extends JFrame{
    private JPanel pnlLecStuResult;
    private JButton btnCalQuiz;
    private JComboBox comboBox1;
    private JTable table1;
    private JButton btncalAsses;
    private JButton btncalGrade;

    public LectureCalMarks() throws Exception {
        add(pnlLecStuResult);
        setVisible(true);
        setTitle("Student Result Manage");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000, 600);
        setPreferredSize(new Dimension(220, 400));
        setResizable(false);
        SubjectDetails subjectDetails = new SubjectDetails();
        comboBox1.setModel(subjectDetails.getSubjectModel());
        StudentResult studentResult = new StudentResult(comboBox1.getModel().getSelectedItem().toString());
        table1.setModel(studentResult.showResult());

        btnCalQuiz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    String quizcalrespo = studentResult.calfinalQuiz();
                    if ( quizcalrespo == "Done"){
                        table1.setModel(studentResult.showResult());

                    }else {
                        JOptionPane.showMessageDialog(null, quizcalrespo, "Error", JOptionPane.ERROR_MESSAGE);

                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        comboBox1.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    studentResult.setSubject(comboBox1.getModel().getSelectedItem().toString());

                    table1.setModel(studentResult.showResult());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }


            }
        });

        btncalAsses.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    String assessmentcalrespo = studentResult.calfinalAssessment();
                    if ( assessmentcalrespo == "Done"){
                        table1.setModel(studentResult.showResult());

                    }else {
                        JOptionPane.showMessageDialog(null, assessmentcalrespo, "Error", JOptionPane.ERROR_MESSAGE);

                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        btncalGrade.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                try {

                    studentResult.setSubject(comboBox1.getModel().getSelectedItem().toString());
                    studentResult.calFinalMarks();
                    table1.setModel(studentResult.showResult());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new LectureCalMarks();
    }

}
