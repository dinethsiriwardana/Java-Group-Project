package com.tecmis.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeDetailsAdmin {
    private String noticeID;
    private String date;
    private String title;
    private String noticeDes;

    public String getNoticeID() {
        return noticeID;
    }

    public void setNoticeID(String noticeID) {
        this.noticeID = noticeID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNoticeDes() {
        return noticeDes;
    }

    public void setNoticeDes(String noticeDes) {
        this.noticeDes = noticeDes;
    }
    public static void addNotice(NoticeDetailsAdmin noticedetail) throws SQLException {
        try {
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Notice (Notice_Id, Date,Title, Notice_Des) VALUES (?, ?, ?, ?)");
            stmt.setString(1, noticedetail.getNoticeID());
            stmt.setString(2, noticedetail.getDate());
            stmt.setString(3,noticedetail.getTitle());
            stmt.setString(4,noticedetail.getNoticeDes());
            stmt.executeUpdate();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void updateNotice(NoticeDetailsAdmin noticedetail) throws  SQLException{
        try{
            Connection conn=Database.getDatabaseConnection();
            PreparedStatement stmt=conn.prepareStatement("UPDATE from Notice SET  Date=?, Title=?, Notice_Des=?  WHERE Notice_Id=?");
            stmt.setString(1,noticedetail.getNoticeID());
            stmt.setString(2,noticedetail.getDate());
            stmt.setString(3,noticedetail.getTitle());
            stmt.setString(4,noticedetail.getNoticeDes());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteNotice(NoticeDetailsAdmin noticedetail) throws  SQLException{
        try{
            Connection conn=Database.getDatabaseConnection();
            PreparedStatement stmt=conn.prepareStatement("DELETE from  Notice WHERE Notice_Id=?");
            stmt.setString(1,noticedetail.getNoticeID());
            stmt.setString(2,noticedetail.getDate());
            stmt.setString(3,noticedetail.getTitle());
            stmt.setString(4,noticedetail.getNoticeDes());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void searchNotice(NoticeDetailsAdmin noticedetail) throws  SQLException{
        try {
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Notice WHERE Notice_Id=?");
            stmt.setString(1, noticedetail.getNoticeID());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // record found
                System.out.println("Record found");
            } else {
                // record not found
                System.out.println("Record not found");
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error searching notice record: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

 }
