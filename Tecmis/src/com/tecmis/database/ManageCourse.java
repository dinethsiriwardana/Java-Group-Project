package com.tecmis.database;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public  class ManageCourse {
    private String courseId;

    private String courseName;
    private int credit;
    private String depID;
    private String lecID;
    private String quiz;
    private String asses;

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public String getAsses() {
        return asses;
    }

    public void setAsses(String asses) {
        this.asses = asses;
    }

    private static final String[] courses_columns = {"Course_ID", "Course_Name", "Credit", "Dep_ID", "Lec_ID", "No_of_Quiz", "No_of_Assessments"};


    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getLecID() {
        return lecID;
    }

    public void setLecID(String lecID) {
        this.lecID = lecID;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
    static Connection conn = null;
    static Statement stmt = null;
    static PreparedStatement pst=null;
    static DefaultTableModel model = null;

    public  DefaultTableModel showCourses() {


        try {
            conn = Database.getDatabaseConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT " + String.join(",", courses_columns) + " FROM Courses");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            model = new DefaultTableModel(courses_columns, 0);

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

        } catch (Exception e) {
            System.out.println("Error in getting connection " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error in closing the Connection..." + e.getMessage());
            }
        }
    return model;
    }



    public static boolean addCourse(ManageCourse manageCourse)  {
        boolean added=false;

       String query="INSERT INTO Courses (Course_Id, Course_Name, Credit, Dep_Id, Lec_Id, No_of_Quiz,No_of_Assessments) VALUES (?, ?, ?, ?, ?,?,?)";

        try {
             conn = Database.getDatabaseConnection();
             pst = conn.prepareStatement(query);

            pst.setString(1, manageCourse.getCourseId());
            pst.setString(2, manageCourse.getCourseName());
            pst.setInt(3,    manageCourse.getCredit());
            pst.setString(4, manageCourse.getDepID());
            pst.setString(5, manageCourse.getLecID());
            pst.setString(6, manageCourse.getQuiz());
            pst.setString(7, manageCourse.getAsses());

            int rowsAdded=pst.executeUpdate();


            if (rowsAdded > 0) {
                added=true;
                System.out.println("Course add successful!!");

            } else {
                System.out.println("Course not add!!");
            }

        } catch (Exception e) {
            System.out.println("Error in getting connection"+e.getMessage());
            return  false;
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error in closeing the connection"+e.getMessage());
            }
        }
        return added;
    }

    public static void updateCourse(ManageCourse manageCourse) throws SQLException {


        try {
             conn = Database.getDatabaseConnection();
             pst = conn.prepareStatement(
                    "UPDATE Courses SET Course_Name=?, Credit=?,Dep_ID=?,Lec_ID=?,No_of_Quiz=?,No_of_Assessments=? WHERE Course_Id=?");
            pst.setString(1, manageCourse.getCourseName());
            pst.setInt(2, manageCourse.getCredit());
            pst.setString(3, manageCourse.getDepID());
            pst.setString(4,manageCourse.getLecID());
            pst.setString(5,manageCourse.getQuiz());
            pst.setString(6,manageCourse.getAsses());
            pst.setString(7,manageCourse.getCourseId());

            int rowsUpdated = pst.executeUpdate();


            if (rowsUpdated > 0) {

                System.out.println("Course Update successful!!");
            } else {
                System.out.println("Course not update!!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }finally {
            conn.close();
        }

    }




    public static boolean deleteCourse(ManageCourse manageCourse) throws SQLException {
        boolean deleted = false;
        try {
            conn = Database.getDatabaseConnection();
            pst = conn.prepareStatement("DELETE FROM Courses WHERE Course_Id = ?");
            pst.setString(1, manageCourse.getCourseId());

            int rowsDeleted = pst.executeUpdate();

            if (rowsDeleted > 0) {
                deleted = true;
                System.out.println("Course delete successful!!");
            } else {
                System.out.println("Course not found!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            conn.close();
        }
        return deleted;
    }



    public static ResultSet searchCourse(ManageCourse manageCourse) throws SQLException {
        ResultSet rs=null;
        try {
             conn = Database.getDatabaseConnection();
             pst= conn.prepareStatement("SELECT * FROM Courses WHERE Course_Id=?");
             pst.setString(1, manageCourse.getCourseId());
             rs = pst.executeQuery();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }



}