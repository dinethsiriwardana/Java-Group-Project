package com.tecmis.ui.lecture;

import com.tecmis.database.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;

import java.sql.*;


public class LectureStudentDetails extends JFrame{
    private JTable table1;
    private JPanel pnlLecStudentDetails;

    private static String username;
    LectureStudentDetails lecsd;

    public LectureStudentDetails(){

        add(pnlLecStudentDetails);
        setVisible(true);
        setTitle("Lecturer Details");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1200,600);


        setResizable(false);

        try {
            dataLoad();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    void dataLoad() throws Exception {
        Database database = new Database();
        Connection conn = Database.getDatabaseConnection();

        Statement stmt = conn.createStatement();

        String[] columnNames = {"ID", "Fname", "Lname", "Mobile", "Address", "Age", "Email", "DOM", "Gender", "Level"};
        String sql = "SELECT " + String.join(",", columnNames) + " FROM Student";

        ResultSet rs = stmt.executeQuery(sql);

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);





        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {

                row[i - 1] = rs.getObject(i);
            }
            model.addRow(row);
        }

//        table1.getColumnModel().getColumn(4).setCellRenderer(new MultiLineTableCellRenderer());

        table1.setModel(model);
        TableColumnModel columnModel = table1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50); // ID
        columnModel.getColumn(1).setPreferredWidth(50); // Fname
        columnModel.getColumn(2).setPreferredWidth(50); // Lname
        columnModel.getColumn(3).setPreferredWidth(50); // Mobile
        columnModel.getColumn(4).setPreferredWidth(350); // Address
        columnModel.getColumn(5).setPreferredWidth(20); // Age
        columnModel.getColumn(6).setPreferredWidth(100); // Email
        columnModel.getColumn(7).setPreferredWidth(100); // DOM
        columnModel.getColumn(8).setPreferredWidth(10); // Gender
        columnModel.getColumn(9).setPreferredWidth(10); // Level

    }
}

