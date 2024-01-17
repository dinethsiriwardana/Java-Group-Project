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

   HashMap<String, String> singlecourse = new HashMap<String, String>();
   SubjectDetails subjectDetails = new SubjectDetails();
   Connection conn;

   public StudentResult(String subject) throws Exception {
      System.out.println("Set Subject: "+ subject);
     this.subject = subject;
      Database database = new Database();
       conn = database.getDatabaseConnection();
   }

   public void setSubject(String subject) {
      System.out.println(subject);
      this.subject = subject;
   }



   public DefaultTableModel showResult() throws Exception {
      Statement stmt = conn.createStatement();

       singlecourse = subjectDetails.getSinglecourse(subject);

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
   public String calfinalAssessment() throws Exception {

      try {
         int no_of_assessments = Integer.parseInt(singlecourse.get("No_of_Assessments"));
         int assessments_to_end = Integer.parseInt(singlecourse.get("Assessments_to_End"));
         System.out.println(no_of_assessments);
         if (!(no_of_assessments == 0)) {

            PreparedStatement quizStmt = conn.prepareStatement(
                    "SELECT * FROM " + subject + "_marks");
            ResultSet quizRs = quizStmt.executeQuery();
            double[] assessmentmarks = new double[no_of_assessments];
            while (quizRs.next()) {
               for (int i = 0; i < no_of_assessments; i++) {
                  assessmentmarks[i] = quizRs.getDouble("assessment_" + (i + 1));
               }

               BigDecimal bd = new BigDecimal(getQuizTotal(assessments_to_end, assessmentmarks));
               bd = bd.setScale(2, RoundingMode.HALF_UP);

               double quizTotalMarks = bd.doubleValue();

               String updatesql = "UPDATE " + subject + "_marks SET assessments_full = ? WHERE SID = ?";

               PreparedStatement updateStmt = conn.prepareStatement(updatesql);
               updateStmt.setDouble(1, quizTotalMarks);
               updateStmt.setString(2, quizRs.getString("SID"));
               System.out.println(updateStmt);
               updateStmt.executeUpdate();
            }
               return "Done";

         } else {
//            throw new SQLException("Subject " + subject + " not found in Courses_test table.");
               return "No Assessments Foundes";

         }

      }catch (Exception e){
         System.out.println(e);
         return "Unknown Error";
      }
   }

   public void calFinalMarks(){
      int quizprentage = Integer.parseInt(singlecourse.get("Quiz_Percentage"));
      int assessmentsprentage = Integer.parseInt(singlecourse.get("Assessment_Percentage"));
      int no_of_assessments = Integer.parseInt(singlecourse.get("No_of_Assessments"));
      int Mid_to_End = Integer.parseInt(singlecourse.get("Mid_to_End"));
      int Final_theory = Integer.parseInt(singlecourse.get("Final_theory"));
      int Final_preactical = Integer.parseInt(singlecourse.get("Final_preactical"));
      try {
         PreparedStatement quizStmt = conn.prepareStatement(
                 "SELECT * FROM "+subject+"_marks");
         ResultSet quizRs = quizStmt.executeQuery();
         while (quizRs.next()) {
            double final_marks = 0.0;
            System.out.println("Student " + quizRs.getString("SID"));

            //QUIZ
            double final_quiz_marks =  quizRs.getDouble("quiz_full");
            final_quiz_marks = final_quiz_marks * quizprentage / 100;
            final_marks = final_quiz_marks + final_marks;
            System.out.println("final_quiz_marks - " + final_quiz_marks);


            if (!(no_of_assessments == 0)){
               double final_assessments_marks = quizRs.getDouble("assessments_full");
               final_assessments_marks = final_assessments_marks * assessmentsprentage /100;
               final_marks = final_assessments_marks + final_marks;
               System.out.println("final_assessments_marks - " + final_assessments_marks);

            }
            if (!(Mid_to_End == 0)){
               double final_mid_marks = quizRs.getDouble("mid");
               final_mid_marks = final_mid_marks * Mid_to_End /100;
               final_marks = final_mid_marks + final_marks;
               System.out.println("final_mid_marks - " + final_mid_marks);

            }
            if (!(Final_theory == 0)){
               double final_ftheory_marks = quizRs.getDouble("final_t");
               final_ftheory_marks = final_ftheory_marks * Final_theory /100;
               final_marks = final_ftheory_marks + final_marks;
               System.out.println("final_ftheory_marks - " + final_ftheory_marks);

            }
            if (!(Final_preactical == 0)){
               double final_fpractical_marks = quizRs.getDouble("final_p");
               final_fpractical_marks = final_fpractical_marks * Final_preactical /100;
               final_marks = final_fpractical_marks + final_marks;
               System.out.println("final_fpractical_marks - " + final_fpractical_marks);

            }


            System.out.println("final_marks "+final_marks);
            BigDecimal bd = new BigDecimal(final_marks); // Replace 'score' with the actual score
            bd = bd.setScale(2, RoundingMode.HALF_UP);

            String grade;
            double credit;

            if (final_marks >= 85 && final_marks <= 100) {
               grade = "A+";
               credit = 4.00;
            } else if (final_marks >= 70 && final_marks < 85) {
               grade = "A";
               credit = 4.00;
            } else if (final_marks >= 65 && final_marks < 70) {
               grade = "A-";
               credit = 3.70;
            } else if (final_marks >= 60 && final_marks < 65) {
               grade = "B+";
               credit = 3.30;
            } else if (final_marks >= 55 && final_marks < 60) {
               grade = "B";
               credit = 3.00;
            } else if (final_marks >= 50 && final_marks < 55) {
               grade = "B-";
               credit = 2.70;
            } else if (final_marks >= 45 && final_marks < 50) {
               grade = "C+";
               credit = 2.30;
            } else if (final_marks >= 40 && final_marks < 45) {
               grade = "C";
               credit = 2.00;
            } else if (final_marks >= 35 && final_marks < 40) {
               grade = "C-";
               credit = 1.70;
            } else if (final_marks >= 30 && final_marks < 35) {
               grade = "D+";
               credit = 1.30;
            } else if (final_marks >= 25 && final_marks < 30) {
               grade = "D";
               credit = 1.00;
            } else if (final_marks >= 0 && final_marks < 25) {
               grade = "E";
               credit = 0.00;
            } else {
               grade = "Invalid";
               credit = 0.00;
            }

            String updatesql = "UPDATE " + subject + "_marks SET total = ?, grade = ?, credit = ? WHERE SID = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updatesql);
            updateStmt.setBigDecimal(1, bd);
            updateStmt.setString(2, grade);
            updateStmt.setDouble(3, credit);
            updateStmt.setString(4, quizRs.getString("SID"));
            System.out.println(updateStmt);
            updateStmt.executeUpdate();

         }
      }catch (SQLNonTransientConnectionException e){
         System.out.println("SQLNonTransientConnectionException");
      }
      catch (Exception e){
         System.out.println(e);
      }


   }
   public String calfinalQuiz() throws SQLException {

      int numQuizzes = Integer.parseInt(singlecourse.get("No_of_Quiz"));
      int quizzesToEnd = Integer.parseInt(singlecourse.get("Quiz_to_End"));
      try{
         if (!(numQuizzes == 0)) {

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
            return "Done";
         } else {
            return "No Assessments Foundes";
         }
      }catch (Exception e){
         System.out.println(e);
         return "Unknown Error";
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
