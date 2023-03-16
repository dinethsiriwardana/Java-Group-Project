package com.tecmis.database;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ReadBulkUsers {

    private String[] columns;
    private String query;

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public DefaultTableModel getDataToTable() throws Exception {

        Connection conn = Database.getDatabaseConnection();

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(query);

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        DefaultTableModel model = new DefaultTableModel(columns, 0);


        while (rs.next()) {

            Object[] row = new Object[columnCount];

            for (int i = 1; i <= columnCount; i++) {

                row[i - 1] = rs.getObject(i);
            }
            model.addRow(row);
        }
        return model;
    }
}
