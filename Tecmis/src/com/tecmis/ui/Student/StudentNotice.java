package com.tecmis.ui.Student;

import com.tecmis.database.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class StudentNotice extends JFrame{
    private JPanel pnlStudentNotice;
    private JTable noticeTable;
    private static final String[] notice_columns = {"Notice_ID", "Date", "Title", "Notice_Des"};
    static StudentNotice studentnotice;
    public StudentNotice(){
        add(pnlStudentNotice);
        setVisible(true);
        setTitle("Student !!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,1500);
        setPreferredSize(new Dimension(220,400));
        setResizable(true);
        studentnotice=this;

        try {
            noticeTable.setModel(studentnotice.showNotice());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static DefaultTableModel showNotice() throws Exception {


        Connection conn = Database.getDatabaseConnection();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT " + String.join(",", notice_columns) + " FROM Notice");

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        DefaultTableModel model = new DefaultTableModel(notice_columns, 0);

        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            model.addRow(row);
        }
        return model;



    }

    public static void main(String[] args) {
        StudentNotice studentnotice = new StudentNotice();
    }


}
