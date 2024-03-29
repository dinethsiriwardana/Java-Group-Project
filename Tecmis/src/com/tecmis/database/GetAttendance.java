package com.tecmis.database;

import com.tecmis.dto.Attendance;
import com.tecmis.dto.SubjectModel;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class GetAttendance {

    String[] subjects = new String[0];
    String[] columnNames = new String[0];
    Connection conn;
    Statement stmt;
    Attendance attendance;
    String selecetrange;
    String[] searchType = new String[]{"All Attendance", "More that 80%", "More than with Medical", "Less than 80%"};
    String where;
    SubjectModel subjectModel;

    public DefaultTableModel getAttendance(String type, String where, String subject ) throws Exception {
        this.where = where;

        conn = Database.getDatabaseConnection();

        stmt = conn.createStatement();

        subjectModel = new SubjectModel();


        subjects = new String[]{
                "ICT01_t_attendance",
                "ICT02_t_attendance",
                "ICT02_p_attendance",
                "ICT03_t_attendance",
                "ICT03_p_attendance",
                "ICT04_t_attendance",
        };
       Map<String, String> attendanceMap = Map.of(
                "ICT01 Theory", "ICT01_t_attendance",
                "ICT02 Theory", "ICT02_t_attendance",
                "ICT02 Practical", "ICT02_p_attendance",
                "ICT03 Theory", "ICT03_t_attendance",
                "ICT03 Practical", "ICT03_p_attendance",
                "ICT04 Theory", "ICT04_t_attendance",
                "ICT04 Practical", "ICT04_p_attendance"
        );
        this.where = Objects.equals(where, "") ? "" : "where SID = '" + this.where + "'";
//        All Attendance, More that 80%, More than with Medical, Less than 80%

        if (type == "All Attendance") {

            columnNames = new String[]{"Subject","SID", "Date", "Attendance", "Extra Details"};
            attendance = new Attendance(columnNames);
            if (Objects.equals(subject, "All Subject")) {
                for (String subjectName : subjectModel.getSubjectNameMap().values()) {
                    runbulksql(subjectName);
                }
            }else{
                runbulksql(attendanceMap.get(subject));
            }
        }else{

            switch (type){
                case "More that 80%":
                    selecetrange = "attend IN (1) GROUP BY SID HAVING total_count / 15.0 * 100.0 > 80.0";
                    break;
                case "More than with Medical":
                    selecetrange = "attend IN (1,2) GROUP BY SID HAVING total_count / 15.0 * 100.0 > 80.0";
                    break;
                case "Less than 80%":
                    selecetrange = "attend IN (1,2) GROUP BY SID HAVING total_count / 15.0 * 100.0 < 80.0";
                    break;

            }

            columnNames = new String[]{"Subject","SID", "Total Count"};
            attendance = new Attendance(columnNames);

            if (Objects.equals(subject, "All Subject")) {
                for (String subjectName : subjectModel.getSubjectNameMap().values()) {
                    runSummerysql(subjectName);
                }
            }else{
                runSummerysql(attendanceMap.get(subject));
            }
        }

        return attendance.getModel();


    }

    private void runbulksql(String subjectName) throws SQLException {


            attendance.addSubjectDataToModel(subjectModel.getSingleSubjectCodeMap(subjectName));
            String sql = "SELECT * FROM " + subjectName + " " + where;
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            attendance.addbulkDataToModel(rs);


    }
    private void runSummerysql(String subjectName) throws SQLException {
        String andWhere = where == "" ? "WHERE " : where + " AND ";

        attendance.addSubjectDataToModel(subjectModel.getSingleSubjectCodeMap(subjectName));
        String sql = "SELECT SID, COUNT(*) AS total_count FROM " + subjectName + " " + andWhere + selecetrange;
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        attendance.addSummeryDataToModel(rs);


    }
}
