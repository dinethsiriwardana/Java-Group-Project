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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750,900);


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
                    boolean issummery = ChkbSummery.isSelected();
                    System.out.println(issummery);
                    DefaultTableModel model = getattendance.getAttendance(filter,search,subject,issummery);
                    lecSA.table1.setModel(model);

                }catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                System.out.println("Getting Data Done");

            }
        });
    }

    public static void main(String[] args) throws Exception {
        lecSA = new LectureStudentAttendance();
    }

}
