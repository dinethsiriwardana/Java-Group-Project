package com.tecmis.ui.TechnicalOfficer;

import com.tecmis.dto.TechnicalOfficer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TechnicalOfficerDashBoard  extends JFrame{
    private JPanel pnlTo;
    private JLabel lblWelcomText;
    private JLabel lblSetting;
    private JButton ToMedical;
    private JButton ToNotice;
    private JButton ToTimetable;
    private JButton ToProfile;
    private JButton ToAttendance;

    public TechnicalOfficerDashBoard(){
        add(pnlTo);
        setVisible(true);
        setTitle("TechnicalOffiserDashBoard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setPreferredSize(new Dimension(220,400));



        ToAttendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                TechnicalOfficerAttendanceForm obj1 = null;
                try {
                    obj1 = new TechnicalOfficerAttendanceForm();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                obj1.setVisible(true);
            }
        });
        ToMedical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                TechnicalOfficerMedicalForm obj2 = null;
                try {
                    obj2 = new TechnicalOfficerMedicalForm();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                obj2.setVisible(true);

            }
        });
        ToProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                TechnicalOfficerProfile toProfile = new TechnicalOfficerProfile();
                toProfile.setVisible(true);


            }
        });
    }

    public static void main(String[] args) {
        TechnicalOfficerDashBoard to=new TechnicalOfficerDashBoard();
    }
}
