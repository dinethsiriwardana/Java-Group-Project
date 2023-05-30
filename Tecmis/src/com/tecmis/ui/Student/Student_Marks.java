package com.tecmis.ui.Student;

import com.tecmis.database.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Student_Marks extends JFrame {
    private JPanel Jresult;
    private JTable marksTable;

    private static final String[] marks_columns = {"MarkID","StudentID","Eligibility","QUIZ01","QUIZ02","QUIZ03","Assesment01","Assesment02","TotalCA","Midterm","FinalTheory","FinalPractical","FinalMark","SGPA","CGPA","Grade","LecturerID"};
    static Student_Marks marks;

    public Student_Marks(){
    add(Jresult);
    setVisible(true);
    setTitle("Student Result!!!");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(1500,1500);
    setPreferredSize(new Dimension(220,400));
    setResizable(true);
        marks=this;
        try {
            marksTable.setModel(marks.showCourse());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static DefaultTableModel showCourse() throws Exception {


        Connection conn = Database.getDatabaseConnection();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT " + String.join(",", marks_columns) + " FROM Student_Marks");

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        DefaultTableModel model = new DefaultTableModel(marks_columns, 0);

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
        Student_Marks studentMarks= new Student_Marks();

    }
}
