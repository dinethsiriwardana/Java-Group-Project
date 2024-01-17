package com.tecmis.dto;

import com.tecmis.database.Database;

import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentGPA {

    public DefaultTableModel calGpa() throws Exception {
        Connection conn = Database.getDatabaseConnection();

        String studentQuery = "SELECT ID FROM Student WHERE Level = 1";
        PreparedStatement studentStmt = conn.prepareStatement(studentQuery);
        ResultSet studentRs = studentStmt.executeQuery();

        List<String> studentIDs = new ArrayList<>();
        while (studentRs.next()) {
            studentIDs.add(studentRs.getString("ID"));
        }

        // Create the table model with columns "Student ID" and "GPA"
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Student ID", "GPA"}, 0);

        for (String studentID : studentIDs) {
            String query = "SELECT (SUM(m1.credit) + SUM(m2.credit) + SUM(m3.credit) + SUM(m4.credit)) / 4 AS total_credit " +
                    "FROM ICT01_marks m1 " +
                    "JOIN ICT02_marks m2 ON m1.SID = m2.SID " +
                    "JOIN ICT03_marks m3 ON m1.SID = m3.SID " +
                    "JOIN ICT04_marks m4 ON m1.SID = m4.SID " +
                    "WHERE m1.SID = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, studentID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                double totalCredit = rs.getDouble("total_credit");

                BigDecimal bd = new BigDecimal(totalCredit);
                bd = bd.setScale(2, RoundingMode.HALF_UP);

                // Add the student ID and GPA to the table model
                tableModel.addRow(new Object[]{studentID, bd});

                // Update the GPA row in the Student table
                updateStudentGPA(conn, studentID, bd);
            }
        }

        conn.close();

        return tableModel;
    }

    private void updateStudentGPA(Connection conn, String studentID, BigDecimal gpa) throws Exception {
        String updateQuery = "UPDATE Student SET GPA = ? WHERE ID = ?";
        PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
        updateStmt.setBigDecimal(1, gpa);
        updateStmt.setString(2, studentID);
        updateStmt.executeUpdate();
    }
}
