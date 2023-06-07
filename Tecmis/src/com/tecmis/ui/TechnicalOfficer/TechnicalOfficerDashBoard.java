package com.tecmis.ui.TechnicalOfficer;

import com.tecmis.dto.TechnicalOfficer;
import com.tecmis.ui.lecture.LectureStudentResult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


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
        ToNotice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    setVisible(false);

                    TechnicalOfficerNotice technicalOfficerNotice = new TechnicalOfficerNotice();
                    technicalOfficerNotice.setVisible(true);
                    technicalOfficerNotice.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            super.windowClosed(e);
                            setVisible(true);
                        }
                    });
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ToTimetable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    setVisible(false);

                    TechnicalOfficerTimetable technicalOfficerTimetable = new TechnicalOfficerTimetable();
                    technicalOfficerTimetable.setVisible(true);
                    technicalOfficerTimetable.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            super.windowClosed(e);
                            setVisible(true);
                        }
                    });
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        TechnicalOfficerDashBoard to=new TechnicalOfficerDashBoard();
    }
}
