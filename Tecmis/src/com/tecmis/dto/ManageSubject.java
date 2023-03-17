package com.tecmis.dto;

import java.lang.*;
import java.util.*;

public class ManageSubject {


    private double[] quiz = {};
    private double[] assessment = {};
    private double mid_exam;
    private double end_exam_t;
    private double end_exam_p;
    private double quizfullmarks;
    private double assessmentfullmarks;
    private double endfullmarks;
    private String grade;

    private String[] tabletitles;

    private int credit;

    private double gpa;

    public void setTabletitles(String[] tabletitles) {
        this.tabletitles = tabletitles;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getEnd_exam_t() {
        return end_exam_t;
    }

    public void setEnd_exam_t(double end_exam_t) {
        this.end_exam_t = end_exam_t;
    }

    public double getEnd_exam_p() {
        return end_exam_p;
    }

    public void setEnd_exam_p(double end_exam_p) {
        this.end_exam_p = end_exam_p;
    }




    public double[] getQuiz() {
        return quiz;
    }

    public double[] getAssessment() {
        return assessment;
    }

    public double getMid_exam() {
        return mid_exam;
    }



    public void setQuiz(double[] quiz) {
        this.quiz = quiz;
    }

    public void addToAssessment(double val) {
        assessment[assessment.length-1] = val;
    }

    public void addToQuiz(double val) {
        quiz[quiz.length-1] = val;
    }

    public void setAssessment(double[] assessment) {
        this.assessment = assessment;
    }

    public void setMid_exam(double mid_exam) {
        this.mid_exam = mid_exam;
    }



    public double getQuizTotal(int no_of_total_quiz,int no_of_counted_quiz){
       if (quiz.length == no_of_total_quiz){
            Double[] iObj = Arrays.stream(quiz).boxed().toArray(Double[]::new);
            Arrays.sort(iObj, Comparator.reverseOrder());
            double[] sortedquiz = Arrays.stream(iObj).mapToDouble(Double::doubleValue).toArray();
            for(int i = 0; i < no_of_counted_quiz;i++){
                quizfullmarks = quizfullmarks + sortedquiz[i];
            }
        }else {
            throw new IllegalArgumentException("The number of insert quizzes taken is not equal to the total number of quizzes.");
        }
        return quizfullmarks;
    }

    public double getAssessmentTotal(int no_of_total_assessment,int no_of_counted_assessment){

        if (assessment.length == no_of_total_assessment){
            Double[] iObj = Arrays.stream(assessment).boxed().toArray(Double[]::new);
            Arrays.sort(iObj, Comparator.reverseOrder());
            double[] sortedquiz = Arrays.stream(iObj).mapToDouble(Double::doubleValue).toArray();
            for(int i = 0; i < no_of_counted_assessment;i++){
                assessmentfullmarks = assessmentfullmarks + sortedquiz[i];
            }
        }else {
            throw new IllegalArgumentException("The number of insert quizzes taken is not equal to the total number of quizzes.");
        }

        return assessmentfullmarks;
    }

    public double getEndfullmarks(){
        this.endfullmarks = quizfullmarks + assessmentfullmarks + mid_exam + end_exam_p + end_exam_t;
        return endfullmarks;
    }

    public double getGPA(){

        return  gpa;
    }

    public String getGrade(){


        if (endfullmarks >= 85) {
            grade = "A-";
            if (endfullmarks >= 95) {
                grade = "A+";
            } else if (endfullmarks > 90) {
                grade = "A";
            }
        }  else if (endfullmarks >= 70) {
            grade = "B-";
            if (endfullmarks >= 80) {
                grade = "B+";
            } else if (endfullmarks > 75) {
                grade = "B";
            }
        }  else if (endfullmarks >= 50) {
            grade = "C-";
            if (endfullmarks >= 65) {
                grade = "C+";
            } else if (endfullmarks > 60) {
                grade = "C";
            }
        } else if (endfullmarks >= 35) {
            grade = "E";
            if (endfullmarks >= 49) {
                grade = "D+";
            } else if (endfullmarks > 40) {
                grade = "D";
            }
        } else{
            grade = "F";
        }
        return grade ;
    }



}

//class a{
//    public static void main(String[] args) {
//        ManageSubject ms = new ManageSubject();
//        System.out.println(ms.getQuizTotal(3,3));
//
//    }
//}
