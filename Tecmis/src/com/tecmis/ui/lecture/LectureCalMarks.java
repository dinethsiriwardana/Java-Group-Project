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
                    studentResult.calfinalQuiz();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
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
                    throw new RuntimeException(ex);
                }
            }
        });

    }

    public static void main(String[] args) throws Exception {
        new LectureCalMarks();
    }

}
