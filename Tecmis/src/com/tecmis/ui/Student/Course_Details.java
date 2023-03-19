package com.tecmis.ui.Student;

import com.tecmis.database.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;


public class Course_Details  extends JFrame{
    private JLabel lblcourseHeader;
    private JTable courseTable;
    private JPanel pnlCourse;

    private static final String[] course_columns = {"Course_ID", "Course_Name", "Credit"};
    static Course_Details course;
    public Course_Details() {
        add(pnlCourse);
        setVisible(true);
        setTitle("Student !!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550,500);
        setPreferredSize(new Dimension(220,400));
        setResizable(true);
        course=this;
        try {
            courseTable.setModel(course.showCourse());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static DefaultTableModel showCourse() throws Exception {


        Connection conn = Database.getDatabaseConnection();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT " + String.join(",", course_columns) + " FROM Course");

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        DefaultTableModel model = new DefaultTableModel(course_columns, 0);

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
        Course_Details course=new Course_Details();
    }


    }

