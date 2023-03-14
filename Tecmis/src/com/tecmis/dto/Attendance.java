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

    public Attendance(String[] columnNames) {
        model = new DefaultTableModel(columnNames, 0);
    }

    public void addbulkDataToModel(ResultSet rs) throws SQLException {
        while (rs.next()) {
            Object[] row = new Object[4];

            row[0] = rs.getString("SID");
            row[1] = rs.getDate("date");
            row[2] = rs.getString("attend");
            row[3] = rs.getString("exDetails") ;

            this.model.addRow(row);

        }
    }
    public void addSummeryDataToModel(ResultSet rs) throws SQLException {
        while (rs.next()) {
            Object[] row = new Object[2];

            row[0] = rs.getString("SID");
            row[1] = rs.getInt("total_count");
            this.model.addRow(row);

        }
    }
    public void addSubjectDataToModel(String subname) throws SQLException {

            Object[] row = new Object[4];

            row[0] = subname;
            row[1] = ("======");


            this.model.addRow(row);


    }

    public DefaultTableModel getModel(){
        return model;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getSid() {
        return sid;
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

