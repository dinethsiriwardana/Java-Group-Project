package com.tecmis.database;

import com.tecmis.database.Database;

import javax.swing.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageTimetable {
    private String id;
    private String departmentName;
    private String level;
    private byte pdf;

    public byte getPdf() {
        return pdf;
    }

    public void setPdf(byte pdf) {
        this.pdf = pdf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    private static final String[] time_table_columns = {"Timetable_ID", "DepartmentName", "Level", "PDF"};

    public static DefaultTableModel showTimetable() throws Exception {
        Connection conn = Database.getDatabaseConnection();
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT " + String.join(",", time_table_columns) + " FROM Timetable");

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        DefaultTableModel model = new DefaultTableModel(time_table_columns, 0);

        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            model.addRow(row);
        }

        conn.close();
        stmt.close();
        rs.close();

        return model;
    }

    public static void addTimetable(ManageTimetable managetable) throws SQLException {
        try {
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Timetable (TimetableID, DepartmentName, Level, PDF) VALUES (?, ?, ?, ?)");
            stmt.setString(1, managetable.getId());
            stmt.setString(2, managetable.getDepartmentName());
            stmt.setString(3, managetable.getLevel());
            stmt.setByte(4, managetable.getPdf());
            stmt.executeUpdate(); // execute the update statement to insert the data
            conn.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
