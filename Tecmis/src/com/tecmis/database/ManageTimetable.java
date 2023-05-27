package com.tecmis.database;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ManageTimetable {
    private String id;
    private String departmentName;
    private String level;

    private byte[] file_path;

    public byte[] getFile_path() {
        return file_path;
    }

    public void setFile_path(byte[] file_path) {
        this.file_path = file_path;
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

    public static ManageTimetable getTimetable(ManageTimetable managetable) {
        return managetable;
    }

    private static final String[] time_table_columns = {"Timetable_ID", "DepartmentName", "Level", "File_path"};
    static Connection conn;

    public static DefaultTableModel showTimetable() throws Exception {
        Statement smt = null;
        DefaultTableModel model=null;
        try {
            conn = Database.getDatabaseConnection();
            smt = conn.createStatement();
            ResultSet rs = smt.executeQuery("SELECT " + String.join(",", time_table_columns) + " FROM Timetable");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            model = new DefaultTableModel(time_table_columns, 0);

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

        } catch (Exception e) {
            System.out.println("Error in getting connection " + e.getMessage());
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error in closing the Connection..."+ e.getMessage());
            }
        }
        return model;
    }

    public void uploadTimetable(String timetableId, String department, String level, String filePath) {

        Connection conn = null;
        try {
            conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Timetable (Timetable_ID, DepartmentName, Level, File_path) VALUES (?, ?, ?, ?)");
            stmt.setString(1, timetableId);
            stmt.setString(2, department);
            stmt.setString(3, level);
            FileInputStream inputStream = new FileInputStream(new File(filePath));
            stmt.setBinaryStream(4, inputStream, (int) new File(filePath).length());
            stmt.executeUpdate(); // execute the update statement to insert the data
            JOptionPane.showMessageDialog(null, "File uploaded successfully.");



        } catch (SQLException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error uploading file: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void downlaodTimetable(){
        try {
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT File_path FROM Timetable WHERE Timetable_ID = ?");
            stmt.setString(1, "T12");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Blob fileData = rs.getBlob("File_path");
                InputStream inputStream = fileData.getBinaryStream();

                // Create a file chooser to select the destination for saving the downloaded file
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save File");
                int result = fileChooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File saveFile = fileChooser.getSelectedFile();
                    FileOutputStream outputStream = new FileOutputStream(saveFile);

                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    outputStream.close();
                    inputStream.close();

                    JOptionPane.showMessageDialog(null, "File downloaded successfully.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Timetable not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            conn.close();
        } catch (SQLException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error uploading file: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public static void deleteTimetable(ManageTimetable managetable) throws SQLException{
        try{
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Timetable WHERE Timetable_ID=?");
            stmt.setString(1, managetable.getId());
            int rowsDeleted = stmt.executeUpdate(); // execute the statement and get the number of rows deleted


            if (rowsDeleted == 0) {
                throw new SQLException("No rows deleted. Timetable with ID " + managetable.getId() + " not found.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            conn.close();
        }

    }


    

}

