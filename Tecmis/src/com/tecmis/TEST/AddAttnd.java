package com.tecmis.TEST;

import com.tecmis.database.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddAttnd {
    public static void main(String[] args) throws Exception {
        Database database = new Database();
        Connection connection = database.getDatabaseConnection() ;


        PreparedStatement pst = null;

        try {


            // Insert attendance data for ICT01
            for (int i = 1; i <= 15; i++) {
                String date = "2023-03-" + String.format("%02d", i);
                for (int j = 1; j <= 10; j++) {
                    String sid = "TG/2020/" + String.format("%03d", j);
                    int attend = (int)(Math.random() * 3);
                    String exDetails = "";
                    if (attend == 2) {
                        exDetails = "Present";
                    } else if (attend == 0) {
                        exDetails = "Absent";
                    } else {
                        exDetails = "Medical";
                    }
                    String query = "INSERT INTO ICT01_attendance (SID, date, attend, exDetails) VALUES (?, ?, ?, ?)";
                    pst = con.prepareStatement(query);
                    pst.setString(1, sid);
                    pst.setDate(2, java.sql.Date.valueOf(date));
                    pst.setInt(3, attend);
                    pst.setString(4, exDetails);
                    pst.executeUpdate();
                }
            }

            // Insert attendance data for ICT02, ICT03, and ICT04
            for (int k = 2; k <= 4; k++) {
                String tableName = "ICT0" + k;
                for (int i = 1; i <= 15; i++) {
                    String date = "2023-03-" + String.format("%02d", i);
                    for (int j = 1; j <= 10; j++) {
                        String sid = "TG/2020/" + String.format("%03d", j);
                        int attend = (int)(Math.random() * 3);
                        String exDetails = "";
                        if (attend == 2) {
                            exDetails = "Present";
                        } else if (attend == 0) {
                            exDetails = "Absent";
                        } else {
                            exDetails = "Medical";
                        }
                        String query = "INSERT INTO " + tableName + "_attendance (SID, date, attend, exDetails) VALUES (?, ?, ?, ?)";
                        pst = con.prepareStatement(query);
                        pst.setString(1, sid);
                        pst.setDate(2, java.sql.Date.valueOf(date));
                        pst.setInt(3, attend);
                        pst.setString(4, exDetails);
                        pst.executeUpdate();
                    }
                }
                if (tableName.equals("ICT01")) {
                    continue;
                }
                for (int i = 1; i <= 10; i++) {
                    String sid = "TG/2020/" + String.format("%03d", i);
                    String query = "INSERT INTO " + tableName + "_p_marks (SID) VALUES (?)";
                    pst = con.prepareStatement(query);
                    pst.setString(1, sid);
                    pst.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
