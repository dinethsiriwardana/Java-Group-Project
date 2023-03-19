package com.tecmis.ui.Student;

import com.tecmis.database.NoticeDetailsAdmin;

import javax.swing.*;
import java.awt.*;

public class StudentNotice extends JFrame{
    private JTextField txtID;
    private JTextField txtDate;
    private JTextField txtTitle;
    private JTextArea txtNoticeDes;
    private JPanel pnlStudentNotice;
    private JTable noticeTable;

    public StudentNotice(){
        add(pnlStudentNotice);
        setVisible(true);
        setTitle("Student !!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1500,1500);
        setPreferredSize(new Dimension(220,400));
        setResizable(true);
        NoticeDetailsAdmin noticeDetail=new NoticeDetailsAdmin();
        try {
            noticeTable.setModel(noticeDetail.showNotice());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        StudentNotice studentnotice = new StudentNotice();
    }


}
