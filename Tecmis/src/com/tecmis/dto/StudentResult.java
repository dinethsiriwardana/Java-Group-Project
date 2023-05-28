package com.tecmis.dto;


import com.tecmis.database.Database;

import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.*;

public class StudentResult {

   private List<Double> quiz;
   private List<Double> assigment;
   String subject;
   Connection conn = Database.getDatabaseConnection();

   HashMap<String, String> singlecourse = new HashMap<String, String>();
   SubjectDetails subjectDetails = new SubjectDetails();

   public StudentResult(String subject) throws Exception {
      System.out.println("Set Subject: "+ subject);
     this.subject = subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }

   public DefaultTableModel showResult() throws Exception {
      Statement stmt = conn.createStatement();

       singlecourse = subjectDetails.getSinglecourse("subject");

      String sql = "SELECT * FROM "+subject+"_marks";
      System.out.println(sql);
      ResultSet rs = stmt.executeQuery(sql);

      // Create a DefaultTableModel object and add the column names to it
      DefaultTableModel model = new DefaultTableModel();
      ResultSetMetaData metaData = rs.getMetaData();
      int columnCount = metaData.getColumnCount();
      for (int i = 1; i <= columnCount; i++) {
         model.addColumn(metaData.getColumnLabel(i));
      }

      // Iterate through the rows of the result set and add each row to the DefaultTableModel object
      while (rs.next()) {
         Object[] rowData = new Object[columnCount];
         for (int i = 1; i <= columnCount; i++) {
            rowData[i-1] = rs.getObject(i);
         }
         model.addRow(rowData);
      }


      return model;

   }
   public boolean calfinalAssessment() throws SQLException {

      PreparedStatement courseStmt = conn.prepareStatement(
              "SELECT No_of_Assessments, Assessments_to_End FROM Courses WHERE Course_ID = ?");
      courseStmt.setString(1, subject);
      ResultSet courseRs = courseStmt.executeQuery();

      if (courseRs.next()) {
         System.out.println(singlecourse.get("No_of_Assessments"));
         int no_of_assessments = courseRs.getInt("No_of_Assessments");
         int assessments_to_end = courseRs.getInt("Assessments_to_End");
         System.out.println("Course " + subject + " has "+ no_of_assessments + " no_of_assessments, and " +assessments_to_end+ " assessments_to_end");
         PreparedStatement quizStmt = conn.prepareStatement(
                 "SELECT * FROM "+subject+"_marks");
         ResultSet quizRs = quizStmt.executeQuery();
         double[] assessmentmarks = new double[no_of_assessments];
         while (quizRs.next()) {
            for (int i = 0; i < no_of_assessments; i++) {
               assessmentmarks[i] = quizRs.getDouble("assessment_" + (i + 1));
            }

            BigDecimal bd = new BigDecimal(getQuizTotal(assessments_to_end, assessmentmarks));
            bd = bd.setScale(2, RoundingMode.HALF_UP);

            double quizTotalMarks = bd.doubleValue();

            String updatesql = "UPDATE "+subject+"_marks SET assessments_full = ? WHERE SID = ?";

            PreparedStatement updateStmt = conn.prepareStatement(updatesql);
            updateStmt.setDouble(1, quizTotalMarks );
            updateStmt.setString(2, quizRs.getString("SID"));
            System.out.println(updateStmt);
            updateStmt.executeUpdate();
         }
         return true;

      } else {
//            throw new SQLException("Subject " + subject + " not found in Courses_test table.");
         return false;
      }
   }
   public boolean calfinalQuiz() throws SQLException {

         PreparedStatement courseStmt = conn.prepareStatement(
                 "SELECT No_of_Quiz, Quiz_to_End, Quiz_Percentage FROM Courses WHERE Course_ID = ?");
         courseStmt.setString(1, subject);
         ResultSet courseRs = courseStmt.executeQuery();

         if (courseRs.next()) {
            int numQuizzes = courseRs.getInt("No_of_Quiz");
            int quizzesToEnd = courseRs.getInt("Quiz_to_End");
            System.out.println("Course" + subject + "has "+ numQuizzes + "No_of_Quiz" +quizzesToEnd+ "Quiz_to_End");
            PreparedStatement quizStmt = conn.prepareStatement(
                    "SELECT * FROM "+subject+"_marks");
            ResultSet quizRs = quizStmt.executeQuery();
            double[] quizMarks = new double[numQuizzes];
            while (quizRs.next()) {
               for (int i = 0; i < numQuizzes; i++) {
                  quizMarks[i] = quizRs.getDouble("quiz_" + (i + 1));
               }

               BigDecimal bd = new BigDecimal(getQuizTotal(quizzesToEnd, quizMarks));
               bd = bd.setScale(2, RoundingMode.HALF_UP);

               double quizTotalMarks = bd.doubleValue();

               String updatesql = "UPDATE "+subject+"_marks SET quiz_full = ? WHERE SID = ?";

               PreparedStatement updateStmt = conn.prepareStatement(updatesql);
               updateStmt.setDouble(1, quizTotalMarks );
               updateStmt.setString(2, quizRs.getString("SID"));
               System.out.println(updateStmt);
               updateStmt.executeUpdate();
            }
            return true;

         } else {
//            throw new SQLException("Subject " + subject + " not found in Courses_test table.");
            return false;
         }

   }
   private static double getQuizTotal(int quizzesToEnd, double[] quizMarks) {
      if (quizMarks.length == 0) {
         return 0;
      } else if (quizMarks.length <= quizzesToEnd) {
         return Arrays.stream(quizMarks).sum()/quizzesToEnd;
      } else {
         Double[] sortedQuizMarks = Arrays.stream(quizMarks).boxed()
                 .sorted(Comparator.reverseOrder()).toArray(Double[]::new);
         double bestQuizTotal = Arrays.stream(sortedQuizMarks).limit(quizzesToEnd).mapToDouble(Double::doubleValue).sum();
         double remainingQuizTotal = Arrays.stream(sortedQuizMarks).skip(quizzesToEnd).mapToDouble(Double::doubleValue).average().orElse(0);

         return bestQuizTotal/quizzesToEnd;
      }
   }
}
