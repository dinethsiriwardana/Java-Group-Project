package com.tecmis.dto;

import javax.swing.*;
import javax.swing.table.TableColumnModel;

public class UserTableModel {


    protected final String[] student_columns = {"ID", "Fname", "Lname", "Mobile", "Address", "Age", "Email", "DOM", "Gender", "Level"};
    protected final String[] admin_columns = {"ID", "Fname", "Lname", "Mobile", "Address", "Age", "Email", "DOM", "Gender", "Admin_role"};
    protected final String[] to_columns = {"ID", "Fname", "Lname", "Mobile", "Address", "Age", "Email", "DOM", "Gender", "Department"};
    protected final String[] lec_columns = {"ID", "Fname", "Lname", "Mobile", "Address", "Age", "Email", "DOM", "Gender", "Position"};

    public String[] getStudentColumns() {
        return student_columns;
    }

    public String[] getAdminColumns() {
        return admin_columns;
    }

    public String[] getToColumns() {
        return to_columns;
    }

    public String[] getLecColumns() {
        return lec_columns;
    }


    public void setPreferredWidths(TableColumnModel columnModel) {

        columnModel.getColumn(0).setPreferredWidth(50); // ID
        columnModel.getColumn(1).setPreferredWidth(50); // Fname
        columnModel.getColumn(2).setPreferredWidth(50); // Lname
        columnModel.getColumn(3).setPreferredWidth(50); // Mobile
        columnModel.getColumn(4).setPreferredWidth(350); // Address
        columnModel.getColumn(5).setPreferredWidth(20); // Age
        columnModel.getColumn(6).setPreferredWidth(100); // Email
        columnModel.getColumn(7).setPreferredWidth(100); // DOM
        columnModel.getColumn(8).setPreferredWidth(10); // Gender
        columnModel.getColumn(9).setPreferredWidth(10); // Level
    }

}
