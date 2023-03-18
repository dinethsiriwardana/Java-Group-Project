package com.tecmis.ui.admin;

import com.tecmis.database.NoticeDetailsAdmin;

import javax.swing.*;
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
    private JTable noticeTable;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton searchButton;
    private JTextField txtToId;
    private JTextField txtAdminId;
    private JTextField txtLecId;


    public NoticeDetails() throws Exception {
        add(pnlNotice);
        setVisible(true);
        setTitle("Admin !!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(true);
        NoticeDetailsAdmin noticeDetail=new NoticeDetailsAdmin();
        noticeTable.setModel(noticeDetail.showNotice());

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NoticeDetailsAdmin noticeDetail=new NoticeDetailsAdmin();
                noticeDetail.setNoticeID(txtNoticeId.getText());
                noticeDetail.setDate(txtDate.getText());
                noticeDetail.setTitle(txtTitle.getText());
                noticeDetail.setNoticeDes(txtNoticeDes.getText());
                noticeDetail.setToID(txtToId.getText());
                noticeDetail.setAdminID(txtAdminId.getText());
                noticeDetail.setLecturerID(txtLecId.getText());

                try{

                    boolean added=NoticeDetailsAdmin.addNotice(noticeDetail);
                    txtNoticeId.setText("");
                    txtDate.setText("");
                    txtTitle.setText("");
                    txtNoticeDes.setText("");
                    txtToId.setText("");
                    txtAdminId.setText("");
                    txtLecId.setText("");

                    if(added) {
                        JOptionPane.showMessageDialog(null, "Notice added successfully!!",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Failed to add notice: please try again!!1",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                }catch(SQLException ex ){
                    JOptionPane.showMessageDialog(null, "Failed to add Notice!!",
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
                noticeDetail.setToID(txtToId.getText());
                noticeDetail.setAdminID(txtAdminId.getText());
                noticeDetail.setLecturerID(txtLecId.getText());

                try {
                    boolean updated=NoticeDetailsAdmin.updateNotice(noticeDetail);
                    txtNoticeId.setText("");
                    txtDate.setText("");
                    txtTitle.setText("");
                    txtNoticeDes.setText("");
                    txtToId.setText("");
                    txtAdminId.setText("");
                    txtLecId.setText("");

                    if(updated) {
                        JOptionPane.showMessageDialog(null, "Notice update successfully!!",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Failed to update notice: notice not found",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to update Notice!!",
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
                noticeDetail.setToID(txtToId.getText());
                noticeDetail.setAdminID(txtAdminId.getText());
                noticeDetail.setLecturerID(txtLecId.getText());

                try {
                    boolean deleted=NoticeDetailsAdmin.deleteNotice(noticeDetail);
                    txtNoticeId.setText("");
                    txtDate.setText("");
                    txtTitle.setText("");
                    txtNoticeDes.setText("");
                    txtToId.setText("");
                    txtAdminId.setText("");
                    txtLecId.setText("");

                    if(deleted) {
                        JOptionPane.showMessageDialog(null, "Notice delete successfully!!",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Failed to delete notice: notice not found!!",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to delete Notice!!",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                NoticeDetailsAdmin noticeDetail=new NoticeDetailsAdmin();
                noticeDetail.setNoticeID(txtNoticeId.getText());
                noticeDetail.setDate(txtDate.getText());
                noticeDetail.setTitle(txtTitle.getText());
                noticeDetail.setNoticeDes(txtNoticeDes.getText());
                noticeDetail.setToID(txtToId.getText());
                noticeDetail.setAdminID(txtAdminId.getText());
                noticeDetail.setLecturerID(txtLecId.getText());

                try {
                    boolean searched=NoticeDetailsAdmin.searchNotice(noticeDetail);
                    txtNoticeId.setText("");
                    txtDate.setText("");
                    txtTitle.setText("");
                    txtNoticeDes.setText("");
                    txtToId.setText("");
                    txtAdminId.setText("");
                    txtLecId.setText("");
                    if(searched) {
                        JOptionPane.showMessageDialog(null, "Notice search successfully",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Failed to search notice: notice not found!!",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to search Notice!!",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }

        });
    }

    public static void main(String[] args) throws Exception {
        NoticeDetails noticedeatils=new NoticeDetails();
    }
}
