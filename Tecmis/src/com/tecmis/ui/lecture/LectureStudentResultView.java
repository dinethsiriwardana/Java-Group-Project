package com.tecmis.ui.lecture;

import com.tecmis.database.Database;

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
        setTitle("Student");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setPreferredSize(new Dimension(220, 400));
        setResizable(false);

        connection = Database.getDatabaseConnection();
        btnUploadMarks.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("ss");
                try {
                    Statement   stmt = connection.createStatement();
                // Execute the SQL query and retrieve the result set
                    ResultSet rs = stmt.executeQuery("SELECT * FROM ICT01_marks");

                    // Create a DefaultTableModel object and add the column names to it
                    DefaultTableModel model = new DefaultTableModel();
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        model.addColumn(metaData.getColumnLabel(i));
                    }

                // Iterate through the rows of the result set and add each row to the DefaultTableModel object
                    while (rs.next()) {
                        Object[] rowData = new Object[columnCount];
                        for (int i = 1; i <= columnCount; i++) {
                            rowData[i-1] = rs.getObject(i);
                        }
                        model.addRow(rowData);
                    }
                    table1.setModel(model);
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());
                }


            }
        });
    }


    public static void main(String[] args) throws Exception {
        LectureStudentResultView lectureStudentResultView = new LectureStudentResultView();
    }

}
