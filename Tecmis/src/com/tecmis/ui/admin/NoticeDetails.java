package com.tecmis.ui.admin;

import com.tecmis.database.NoticeDetailsAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class NoticeDetails extends JFrame {
    private JPanel pnlNotice;
    private JTextField txtNoticeId;
    private JTextField txtDate;
    private JTextField txtTitle;
    private JTextField txtNoticeDes;
    private JTable table1;
    private JButton addButton;
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


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NoticeDetailsAdmin noticeDetail=new NoticeDetailsAdmin();
                noticeDetail.setNoticeID(txtNoticeId.getText());
                noticeDetail.setDate(txtDate.getText());
                noticeDetail.setTitle(txtTitle.getText());
                noticeDetail.setNoticeDes(txtNoticeDes.getText());

                try{
                    NoticeDetailsAdmin.addNotice(noticeDetail);
                    txtNoticeId.setText("");
                    txtDate.setText("");
                    txtTitle.setText("");
                    txtNoticeDes.setText("");
                    JOptionPane.showMessageDialog(null, "Notice added successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);

                }catch(SQLException ex ){
                    JOptionPane.showMessageDialog(null, "Failed to add Notice",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NoticeDetailsAdmin noticeDetail = new NoticeDetailsAdmin();
                noticeDetail.setNoticeID(txtNoticeId.getText());
                noticeDetail.setDate(txtDate.getText());
                noticeDetail.setTitle(txtTitle.getText());
                noticeDetail.setNoticeDes(txtNoticeDes.getText());

                try {
                    NoticeDetailsAdmin.updateNotice(noticeDetail);
                    txtNoticeId.setText("");
                    txtDate.setText("");
                    txtTitle.setText("");
                    txtNoticeDes.setText("");
                    JOptionPane.showMessageDialog(null, "Notice update successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to update Notice",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NoticeDetailsAdmin noticeDetail = new NoticeDetailsAdmin();
                noticeDetail.setNoticeID(txtNoticeId.getText());
                noticeDetail.setDate(txtDate.getText());
                noticeDetail.setTitle(txtTitle.getText());
                noticeDetail.setNoticeDes(txtNoticeDes.getText());

                try {
                    NoticeDetailsAdmin.deleteNotice(noticeDetail);
                    txtNoticeId.setText("");
                    txtDate.setText("");
                    txtTitle.setText("");
                    txtNoticeDes.setText("");
                    JOptionPane.showMessageDialog(null, "Notice delete successfully",
                            "Success", JOptionPane.INFORMATION_MESSAGE);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to delete Notice",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    public static void main(String[] args) {
        NoticeDetails noticedeatils=new NoticeDetails();
    }
}
