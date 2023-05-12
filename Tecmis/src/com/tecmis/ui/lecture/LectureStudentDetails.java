package com.tecmis.ui.lecture;


import com.tecmis.database.ReadBulkUserSql;
import com.tecmis.database.ReadBulkUsers;

import com.tecmis.dto.UserTableModel;

import javax.swing.*;

import javax.swing.table.TableColumnModel;


public class LectureStudentDetails extends JFrame {
    private JTable table1;
    private JPanel pnlLecStudentDetails;
    private JScrollPane scrPane;

    private static String username;
    LectureStudentDetails lecsd;

    public LectureStudentDetails() {

        add(pnlLecStudentDetails);
        setVisible(true);
        setTitle("Lecturer Student Details");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1200, 600);


//        setResizable(false);

        try {
            dataLoad();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    void dataLoad() throws Exception {


        UserTableModel userTableHeader = new UserTableModel();
        ReadBulkUsers readBulkUsers = new ReadBulkUsers();
        ReadBulkUserSql readBulkUserSql = new ReadBulkUserSql();


        readBulkUsers.setColumns(userTableHeader.getStudentColumns());
        readBulkUsers.setQuery(readBulkUserSql.getStudentSqlQ());

        table1.setModel(readBulkUsers.getDataToTable());

        TableColumnModel columnModel = table1.getColumnModel();
        userTableHeader.setPreferredWidths(columnModel);

    }


}

