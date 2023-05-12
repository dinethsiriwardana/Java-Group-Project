package com.tecmis.ui.admin;



import com.tecmis.database.ManageTimetable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Timetable extends JFrame {
    private JTextField txtTime_ID;
    private JButton addButton;
    private JButton deleteButton;
    private JButton uploadButton1;
    private JPanel pnlTimetable;
    private JComboBox txtLevel;
    private JButton uploadButton;
    private JComboBox txtDepartment;
    private JTable timeTable;
    private JTextField txtPDF;
    private JButton backButton;

    public Timetable() {
        add(pnlTimetable);
        setVisible(true);
        setSize(1000, 600);
        setTitle("Timetable!!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ManageTimetable managetables = new ManageTimetable();
        try {
            timeTable.setModel(managetables.showTimetable());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminForm object = new AdminForm();
                object.setVisible(true);
            }
        });
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static void main(String[] args) {

        Timetable timetable=new Timetable();
    }
}
