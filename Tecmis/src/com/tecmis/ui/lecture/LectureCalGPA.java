package com.tecmis.ui.lecture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LectureCalGPA extends JFrame{
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
            super.mouseClicked(e);
            String[] students = {
                    "TG/2020/001", "TG/2020/0010", "TG/2020/002", "TG/2020/003",
                    "TG/2020/004", "TG/2020/005", "TG/2020/006", "TG/2020/007",
                    "TG/2020/008", "TG/2020/009"
            };

            // Column names
            String[] columnNames = {"Student ID", "Column1", "Column2", "Column3", "Column4", "Column5"};

            // Create the DefaultTableModel
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            // Populate the table with student data
            for (String student : students) {
                List<String> values = Arrays.asList("A", "B", "C+", "A");
                Collections.shuffle(values);  // Randomize the values

                Object[] rowData = {student, values.get(0), values.get(1), values.get(2), values.get(3), "NotCalculate"};
                model.addRow(rowData);
            }

            table1.setModel(model);

        }
    });


}

    public static void main(String[] args) {
        LectureCalGPA lectureCalGPA = new LectureCalGPA();
    }
}
