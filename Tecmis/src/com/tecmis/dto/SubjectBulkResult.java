package com.tecmis.dto;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

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
//        System.out.println(Arrays.toString(row));
        this.model.addRow(row);


    }

    public DefaultTableModel getModel() {
        return model;
    }
}
