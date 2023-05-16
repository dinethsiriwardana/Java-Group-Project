package com.tecmis.ui.lecture;

import com.tecmis.database.GetAttendance;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LectureStudentAttendance extends JFrame{
    private JPanel pnlLSA;
    private JComboBox comboType;
    private JTextField txtSearch;
    private JTable table1;
    private JScrollPane scrPane;
    private JLabel lblSearchbtn;
    private JComboBox comboSubject;
    private JCheckBox ChkbSummery;
    static LectureStudentAttendance  lecSA;

    public LectureStudentAttendance(){

        add(pnlLSA);
        setVisible(true);
        setTitle("Lecturer");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(750,900);
        setResizable(false);
        lecSA = this;


        lblSearchbtn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                GetAttendance getattendance = new GetAttendance();
                System.out.println("Getting Data");
                try {

                    String filter =  comboType.getModel().getSelectedItem().toString();
                    String search = txtSearch.getText();
                    String subject = comboSubject.getModel().getSelectedItem().toString();

                    DefaultTableModel model = getattendance.getAttendance(filter,search,subject);
                    lecSA.table1.setModel(model);

                }catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                System.out.println("Getting Data Done");

            }
        });
    }



}
