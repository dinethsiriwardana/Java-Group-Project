package com.tecmis.database;

import com.tecmis.dto.Attendance;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetAttendance {

    public DefaultTableModel getAttendance() throws Exception {

            String[] subjects = {
                    "ICT01_t_attendance",
                    "ICT02_t_attendance",
                    "ICT02_p_attendance",
                    "ICT03_t_attendance",
                    "ICT03_p_attendance",
                    "ICT04_t_attendance",

            };

            Connection conn = Database.getDatabaseConnection();


            Statement stmt = conn.createStatement();
            Attendance attendance = new Attendance();

            for (String subjectName : subjects) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + subjectName);

                attendance.addDataToModel(rs);

            }
        return attendance.getModel();

    }
}
