package com.tecmis.ui.Student;

import com.tecmis.database.Auth;
import com.tecmis.database.GetAttendance;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Student_Attendance extends JFrame{
    private JLabel HeaderAttendance;
    private JTextField textStuID;
    private JButton searchButton;
    private JTextArea textArea1;
    private JPanel pnlStudentAttendance;
    private JTable table1;
    private JComboBox comboType;
    private JComboBox comboSubject;
    private JButton SEARCHButton;

    private static String username;



    public Student_Attendance() {

        Auth auth = Auth.getInstance();
        username = auth.getUsername();

        add(pnlStudentAttendance);
        setVisible(true);
        setTitle("Student !!!");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(550,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(true);


        GetAttendance getattendance = new GetAttendance();

        SEARCHButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Getting Data");
                try {

                    String filter =  comboType.getModel().getSelectedItem().toString();
                    String search = auth.getSID();
                    String subject = comboSubject.getModel().getSelectedItem().toString();

                    DefaultTableModel model = getattendance.getAttendance(filter,search,subject);
                    table1.setModel(model);

                }catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        Student_Attendance studentAttendance = new Student_Attendance();
    }



}
