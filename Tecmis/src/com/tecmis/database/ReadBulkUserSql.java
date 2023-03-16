package com.tecmis.database;

import com.tecmis.dto.UserTableModel;

public class ReadBulkUserSql extends UserTableModel {
    public String getStudentSqlQ() {
        return "SELECT " + String.join(",", student_columns) + " FROM Student";
    }

    public String getAdminSqlQ() {
        return "SELECT " + String.join(",", admin_columns) + " FROM Admin";
    }

    public String getToSqlQ() {
        return "SELECT " + String.join(",", to_columns) + " FROM TechnicalOfficer";
    }

    public String getLecSqlQ() {
        return "SELECT " + String.join(",", lec_columns) + " FROM Lecturer";
    }

}
