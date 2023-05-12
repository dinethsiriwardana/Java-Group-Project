package com.tecmis.database;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ManageAdminNotice {
    private String noticeID;
    private String date;
    private String title;
    private String noticeDes;
    private String toID;
    private String adminID;
    private String lecturerID;

    public String getToID() {
        return toID;
    }

    public void setToID(String toID) {
        this.toID = toID;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }

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
    private static final String[] notice_columns = {"Notice_ID", "Date", "Title", "Notice_Des"};
    static Connection conn = null;


    public static DefaultTableModel showNotice() throws Exception {
        Statement smt = null;
        DefaultTableModel model=null;
        try {
            conn = Database.getDatabaseConnection();
            smt = conn.createStatement();
            ResultSet rs = smt.executeQuery("SELECT " + String.join(",", notice_columns) + " FROM Notice");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            model = new DefaultTableModel(notice_columns, 0);

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }

        } catch (Exception e) {
            System.out.println("Error in getting connection " + e.getMessage());
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error in closing the Connection..."+ e.getMessage());
            }
        }
        return model;



    }
    public static boolean addNotice(ManageAdminNotice noticedetail) throws SQLException {
        boolean added=false;
        try {

            conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO Notice (Notice_Id, Date,Title, Notice_Des) VALUES (?, ?, ?, ?)");
            stmt.setString(1, noticedetail.getNoticeID());
            stmt.setString(2, noticedetail.getDate());
            stmt.setString(3,noticedetail.getTitle());
            stmt.setString(4,noticedetail.getNoticeDes());

            int rowsAdded = stmt.executeUpdate();
            stmt.close();
            conn.close();
            if (rowsAdded > 0) {
                added = true;
                System.out.println("Notice add successful!!");
            } else {
                System.out.println("No rows were added to the Notice table.");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return  added;
    }
    public static boolean updateNotice(ManageAdminNotice noticedetail) throws  SQLException {
        boolean updated = false;
        try {
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Notice SET Date=?, Title=?, Notice_Des=? WHERE Notice_Id=?");
            stmt.setString(1, noticedetail.getDate());
            stmt.setString(2, noticedetail.getTitle());
            stmt.setString(3, noticedetail.getNoticeDes());
            stmt.setString(4, noticedetail.getNoticeID());
            int rowsUpdated = stmt.executeUpdate();
            stmt.close();
            conn.close();
            if (rowsUpdated > 0) {
                updated = true;
                System.out.println("Notice update successful!!");
            } else {
                System.out.println("No rows were updated in the Notice table.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return updated;
    }

    public static boolean deleteNotice(ManageAdminNotice noticedetail) throws  SQLException{
        boolean deleted=false;
        try{
            Connection conn=Database.getDatabaseConnection();
            PreparedStatement stmt=conn.prepareStatement("DELETE from  Notice WHERE Notice_Id=?");
            stmt.setString(1,noticedetail.getNoticeID());


            int rowsDeleted=stmt.executeUpdate();
            stmt.close();
            conn.close();
            if (rowsDeleted > 0) {
                deleted= true;
                System.out.println("Notice add successful!!");
            } else {
                System.out.println("No rows were added to the Notice table.");
            }


        } catch (Exception e) {
            System.out.println(e);
        }finally {

        }
        return  deleted;
    }
    public static ResultSet searchNotice(ManageAdminNotice noticedetail) throws  SQLException{
        ResultSet rs=null;
        try {
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Notice WHERE Notice_Id=?");
            stmt.setString(1, noticedetail.getNoticeID());
            rs = stmt.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error searching notice record: " + e.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

}
