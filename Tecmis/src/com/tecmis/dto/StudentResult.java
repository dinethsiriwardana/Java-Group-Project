package com.tecmis.dto;


import com.tecmis.database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class StudentResult {

   private List<Double> quiz;
   private List<Double> assigment;



   //   private
   public static void main(String[] args) {


      String subject = "ICT02";

      try (Connection conn = Database.getDatabaseConnection()) {
         // Get details about the subject from Courses_test table
         PreparedStatement courseStmt = conn.prepareStatement(
                 "SELECT No_of_Quiz, Quiz_to_End, Quiz_Percentage FROM Courses_test WHERE Course_ID = ?");
         courseStmt.setString(1, subject);
         ResultSet courseRs = courseStmt.executeQuery();
         if (courseRs.next()) {
            int numQuizzes = courseRs.getInt("No_of_Quiz");
            int quizzesToEnd = courseRs.getInt("Quiz_to_End");
            double quizPercentage = courseRs.getDouble("Quiz_Percentage");

            // Get quiz marks from ICT012_marks table
            PreparedStatement quizStmt = conn.prepareStatement(
                    "SELECT * FROM "+subject+"_marks");
            ResultSet quizRs = quizStmt.executeQuery();
            double[] quizMarks = new double[numQuizzes];
            for (int i = 0; i < numQuizzes; i++) {
               if (quizRs.next()) {
                  quizMarks[i] = quizRs.getDouble("quiz_" + (i + 1));
                  System.out.println(quizMarks[i]);
               } else {
                  throw new SQLException("Not enough quiz marks found for " + subject);
               }
            }

            // Calculate quiz total marks
            double quizTotalMarks = getQuizTotal(quizzesToEnd, quizMarks);
            String updatesql = "UPDATE "+subject+"_marks SET quiz_full = ? WHERE SID = ?";
            // Insert quiz total marks into ICT012_marks table
            PreparedStatement updateStmt = conn.prepareStatement(updatesql);

            updateStmt.setDouble(1, quizTotalMarks * quizPercentage / 100);
            updateStmt.setString(2, subject + "_marks");
            updateStmt.executeUpdate();
            System.out.println("Quiz total marks for " + subject + " inserted successfully.");
         } else {
            throw new SQLException("Subject " + subject + " not found in Courses_test table.");
         }

      } catch (SQLException e) {
         throw new RuntimeException(e);
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   private static double getQuizTotal(int quizzesToEnd, double[] quizMarks) {
      if (quizMarks.length == 0) {
         return 0;
      } else if (quizMarks.length <= quizzesToEnd) {
         return Arrays.stream(quizMarks).sum();
      } else {
         Double[] sortedQuizMarks = Arrays.stream(quizMarks).boxed()
                 .sorted(Comparator.reverseOrder()).toArray(Double[]::new);
         double bestQuizTotal = Arrays.stream(sortedQuizMarks).limit(quizzesToEnd).mapToDouble(Double::doubleValue).sum();
         double remainingQuizTotal = Arrays.stream(sortedQuizMarks).skip(quizzesToEnd).mapToDouble(Double::doubleValue).average().orElse(0);
         return bestQuizTotal + remainingQuizTotal;
      }
   }
}
