package com.tecmis.ui.admin;

import com.tecmis.database.ManageAdminNotice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeDetails extends JFrame {
    private JPanel pnlNotice;
    private JTextField txtNoticeId;
    private JTextField txtDate;
    private JTextField txtTitle;

    private JTable noticeTable;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton searchButton;
    private JTextArea txtDes;
    private JButton backButton;


    public NoticeDetails() throws Exception {
        add(pnlNotice);
        setVisible(true);
        setTitle("Admin !!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(true);
        ManageAdminNotice noticeDetail=new ManageAdminNotice();
        noticeTable.setModel(noticeDetail.showNotice());

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageAdminNotice noticeDetail=new ManageAdminNotice();
                noticeDetail.setNoticeID(txtNoticeId.getText());
                noticeDetail.setDate(txtDate.getText());
                noticeDetail.setTitle(txtTitle.getText());
                noticeDetail.setNoticeDes(txtDes.getText());


                try{

                    boolean added= ManageAdminNotice.addNotice(noticeDetail);
                    txtNoticeId.setText("");
                    txtDate.setText("");
                    txtTitle.setText("");
                    txtDes.setText("");


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
                ManageAdminNotice noticeDetail = new ManageAdminNotice();
                noticeDetail.setNoticeID(txtNoticeId.getText());
                noticeDetail.setDate(txtDate.getText());
                noticeDetail.setTitle(txtTitle.getText());
                noticeDetail.setNoticeDes(txtDes.getText());


                try {
                    boolean updated= ManageAdminNotice.updateNotice(noticeDetail);
                    txtNoticeId.setText("");
                    txtDate.setText("");
                    txtTitle.setText("");
                    txtDes.setText("");


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
                ManageAdminNotice noticeDetail = new ManageAdminNotice();
                noticeDetail.setNoticeID(txtNoticeId.getText());
                noticeDetail.setDate(txtDate.getText());
                noticeDetail.setTitle(txtTitle.getText());
                noticeDetail.setNoticeDes(txtDes.getText());


                try {
                    boolean deleted= ManageAdminNotice.deleteNotice(noticeDetail);
                    txtNoticeId.setText("");
                    txtDate.setText("");
                    txtTitle.setText("");
                    txtDes.setText("");

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

                ManageAdminNotice noticeDetail=new ManageAdminNotice();
                noticeDetail.setNoticeID(txtNoticeId.getText());
                noticeDetail.setDate(txtDate.getText());
                noticeDetail.setTitle(txtTitle.getText());
                noticeDetail.setNoticeDes(txtDes.getText());


                try {
                    ResultSet searched= ManageAdminNotice.searchNotice(noticeDetail);
                    if(searched.next()) {
                        txtNoticeId.setText(searched.getString("Notice_Id"));
                        txtDate.setText(searched.getString("Date"));
                        txtTitle.setText(searched.getString("Title"));
                        txtDes.setText(searched.getString("Notice_Des"));
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
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminForm object = new AdminForm();
                object.setVisible(true);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        NoticeDetails noticedeatils=new NoticeDetails();
    }
}
