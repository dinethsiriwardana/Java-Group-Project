package com.tecmis.ui.lecture;

import com.tecmis.database.Database;
import com.tecmis.database.GetAttendance;
import com.tecmis.dto.Attendance;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LectureStudentAttendance extends JFrame{
    private JPanel pnlLSA;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTable table1;
    private JScrollPane scrPane;

    public LectureStudentAttendance(){

        add(pnlLSA);
        setVisible(true);
        setTitle("Lecturer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750,900);


//        setPreferredSize(new Dimension(220,400));
//        setResizable(false);
    }

    public static void main(String[] args) throws Exception {
        LectureStudentAttendance  lecSA = new LectureStudentAttendance();
        GetAttendance getattendance = new GetAttendance();
        DefaultTableModel model = getattendance.getAttendance();
        TableColumnModel columnModel =  lecSA.table1.getColumnModel();
        String[] columnNames = {"SID", "Date", "Attendance", "Extra Details"};

//        model = new DefaultTableModel(columnNames, 0);
        lecSA.table1.setModel(model);





    }

}
