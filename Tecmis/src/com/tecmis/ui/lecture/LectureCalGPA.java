package com.tecmis.ui.lecture;

import com.tecmis.database.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LectureCalGPA extends JFrame{
    private JPanel pnlLecStuResult;
    private JTable table1;
    private JButton btnGPACal;
public LectureCalGPA() {

    add(pnlLecStuResult);
    setVisible(true);
    setTitle("Student Result Manage");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(1000, 600);
    setPreferredSize(new Dimension(220, 400));
    setResizable(false);
    btnGPACal.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            Connection conn;
            try {
                conn = Database.getDatabaseConnection();



                String query = "SELECT (SUM(m1.credit) + SUM(m2.credit) + SUM(m3.credit) + SUM(m4.credit)) / 4 AS total_credit " +
                        "FROM ICT01_marks m1 " +
                        "JOIN ICT02_marks m2 ON m1.SID = m2.SID " +
                        "JOIN ICT03_marks m3 ON m1.SID = m3.SID " +
                        "JOIN ICT04_marks m4 ON m1.SID = m4.SID " +
                        "WHERE m1.SID = ?";

                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, "TG/2020/008");
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    double totalCredit = rs.getDouble("total_credit");
                    System.out.println("Total Credit: " + totalCredit);
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);

            }


        }
    });


}

    public static void main(String[] args) {
        LectureCalGPA lectureCalGPA = new LectureCalGPA();
    }
}
