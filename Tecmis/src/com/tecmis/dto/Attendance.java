package com.tecmis.dto;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Attendance {
    private String sid;
    private String date;
    private int attend;
    private String exDetails;

    DefaultTableModel model;

    public Attendance() {
        // Initialize the model object
        String[] columnNames = {"SID", "Date", "Attendance", "Extra Details"};

        model = new DefaultTableModel(columnNames, 0);
    }

    public void addDataToModel(ResultSet rs) throws SQLException {
        while (rs.next()) {
            Object[] row = new Object[4];

            row[0] = rs.getString("SID");
            row[1] = rs.getDate("date");
            row[2] = rs.getString("attend");
            row[3] = rs.getString("exDetails") ;

            this.model.addRow(row);

        }
    }

    public DefaultTableModel getModel(){
        return model;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAttend() {
        return attend;
    }

    public void setAttend(int attend) {
        this.attend = attend;
    }

    public String getExDetails() {
        return exDetails;
    }

    public void setExDetails(String exDetails) {
        this.exDetails = exDetails;
    }
}

