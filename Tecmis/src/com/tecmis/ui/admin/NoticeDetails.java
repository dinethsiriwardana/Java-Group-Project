package com.tecmis.ui.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoticeDetails extends JFrame {
    private JPanel pnlNotice;
    private JTextField textNoticeId;
    private JTextField textDate;
    private JTextField textTitle;
    private JTextField textNoticeDes;
    private JTable table1;
    private JButton createButton;
    private JButton deleteButton;
    private JButton updateButton;


    public NoticeDetails(){
        add(pnlNotice);
        setVisible(true);
        setTitle("Notice Details!!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(false);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        NoticeDetails noticedeatils=new NoticeDetails();
    }
}
