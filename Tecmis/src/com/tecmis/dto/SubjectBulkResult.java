package com.tecmis.dto;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

public class SubjectBulkResult {
    DefaultTableModel model;

    public void setModel(String[] header) {

        model = new DefaultTableModel(header, 0);
    }

    public void addbulkDataToModel(String[] values) throws SQLException {

        Object[] row = new Object[values.length];
        for(int i = 0; i < values.length;i++){
            row[i] = values[i];
        }
        this.model.addRow(row);


    }
    public DefaultTableModel getModel() {
        return model;
    }



    public static void main(String[] args) {

    }
}
