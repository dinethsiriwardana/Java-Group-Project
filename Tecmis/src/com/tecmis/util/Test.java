package com.tecmis.util;

import com.tecmis.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class Test {
    public static void main(String[] args) throws Exception {


        Connection conn = Database.getDatabaseConnection();
        String query = "INSERT INTO ICT01_marks (SID, quiz_1, quiz_2, quiz_3, quiz_full, Assessment, mid, final_t, final_p, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        PreparedStatement statement = conn.prepareStatement(query);

        // Inserting 10 rows of data
        for(int i = 1; i <= 10; i++) {
            String sid = "TG/2020/00" + i;
            int quiz1 = (int) (Math.random() * 100) + 1;
            int quiz2 = (int) (Math.random() * 100) + 1;
            int quiz3 = (int) (Math.random() * 100) + 1;
            int assessments1 = (int) (Math.random() * 100) + 1;
            int assessments2 = (int) (Math.random() * 100) + 1;
            double assessments_full = (assessments1 + assessments2)/20.0;
            int largest = 0;
            int secondLargest = 0;
            if (quiz1 > quiz2 && quiz1 > quiz3) {
                largest = quiz1;
                secondLargest = Math.max(quiz2, quiz3);
            } else if (quiz2 > quiz1 && quiz2 > quiz3) {
                largest = quiz2;
                secondLargest = Math.max(quiz1, quiz3);
            } else {
                largest = quiz3;
                secondLargest = Math.max(quiz1, quiz2);
            }
            double quizFull = ((largest + secondLargest) / 20.0);
            int mid = (int) (Math.random() * 20) + 1;
            int finalT = (int) (Math.random() * 40) + 1;

            int finalP = (int) (Math.random() * 30) + 1;

            double total = quizFull + mid + finalT + finalP ;

//            System.out.println(quiz1 + " , " + quiz2+ " , " + quiz3+ " , (" + largest + " + "+secondLargest+" = " + quizFull+ " , " + mid + " , " + finalT+ " , " + finalP + " , " +  total);

            statement.setString(1, sid);
            statement.setInt(2, quiz1);
            statement.setInt(3, quiz2);
            statement.setInt(4, quiz3);
            statement.setDouble(5, quizFull);
            statement.setInt(6, assessments1);
            statement.setInt(7, mid);
            statement.setInt(8, finalT);
            statement.setInt(9, finalP);
            statement.setDouble(10, total);
//            System.out.println(statement);
            statement.executeUpdate();

            // Printing pass ranges

        }
    }
//    public static void main(String[] args) throws Exception {
//
//
//        Connection conn = Database.getDatabaseConnection();
//        String query = "INSERT INTO ICT02_marks (SID, quiz_1, quiz_2, quiz_3, quiz_full, assessment_1, mid, final_t, final_p, total,assessment_2,assessments_full) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        PreparedStatement statement = conn.prepareStatement(query);
//
//        // Inserting 10 rows of data
//        for(int i = 1; i <= 10; i++) {
//            String sid = "TG/2020/00" + i;
//            int quiz1 = (int) (Math.random() * 100) + 1;
//            int quiz2 = (int) (Math.random() * 100) + 1;
//            int quiz3 = (int) (Math.random() * 100) + 1;
//            int assessments1 = (int) (Math.random() * 100) + 1;
//            int assessments2 = (int) (Math.random() * 100) + 1;
//            double assessments_full = (assessments1 + assessments2)/20.0;
//            int largest = 0;
//            int secondLargest = 0;
//            if (quiz1 > quiz2 && quiz1 > quiz3) {
//                largest = quiz1;
//                secondLargest = Math.max(quiz2, quiz3);
//            } else if (quiz2 > quiz1 && quiz2 > quiz3) {
//                largest = quiz2;
//                secondLargest = Math.max(quiz1, quiz3);
//            } else {
//                largest = quiz3;
//                secondLargest = Math.max(quiz1, quiz2);
//            }
//            double quizFull = ((largest + secondLargest) / 20.0);
//            int mid = (int) (Math.random() * 20) + 1;
//            int finalT = (int) (Math.random() * 60) + 1;
//
//            int finalP = (int) (Math.random() * 30) + 1;
//
//            double total = quizFull + mid + finalT  ;
//
////            System.out.println(quiz1 + " , " + quiz2+ " , " + quiz3+ " , (" + largest + " + "+secondLargest+" = " + quizFull+ " , " + mid + " , " + finalT+ " , " + finalP + " , " +  total);
//
//            statement.setString(1, sid);
//            statement.setInt(2, quiz1);
//            statement.setInt(3, quiz2);
//            statement.setInt(4, quiz3);
//            statement.setDouble(5, quizFull);
//            statement.setInt(6, assessments1);
//            statement.setInt(7, mid);
//            statement.setInt(8, finalT);
//            statement.setInt(9, finalP);
//            statement.setDouble(10, total);
//            statement.setDouble(11, assessments2);
//            statement.setDouble(12, assessments_full);
////            System.out.println(statement);
//            statement.executeUpdate();
//
//            // Printing pass ranges
//
//        }
//    }
}

