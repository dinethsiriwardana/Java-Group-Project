package com.tecmis.ui.lecture;

import com.tecmis.database.Database;
import com.tecmis.dto.StudentGPA;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectureCalGPA extends JFrame {
    private JPanel pnlLecStuResult;
    private JTable table1;
    private JButton btnGPACal;

    public LectureCalGPA() {
        add(pnlLecStuResult);
        setVisible(true);
        setTitle("Student Result Manage");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000, 600);
        setPreferredSize(new Dimension(220, 400));
        setResizable(false);
        btnGPACal.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StudentGPA studentGPA = new StudentGPA();
                try {
                    table1.setModel(studentGPA.calGpa());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    public static void main(String[] args) {
        LectureCalGPA lectureCalGPA = new LectureCalGPA();
    }
}
