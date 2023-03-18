package com.tecmis.ui.admin;



import com.tecmis.database.Course;
import com.tecmis.database.ManageTimetable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;


public class Timetable extends JFrame {
    private JPanel pnlUser;
    private JTextField txtTime_ID;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JPanel pnlTimetable;
    private JComboBox txtLevel;
    private JButton uploadButton;
    private JComboBox txtDepartment;
    private JTable timeTable;
    private JTextField txtPDF;

    public Timetable(){
        add(pnlTimetable);
        setVisible(true);
        setSize(1000,600);
        setTitle("Timetable!!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ManageTimetable managetables=new ManageTimetable();
        try {
            timeTable.setModel(managetables.showTimetable());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageTimetable managetable = new ManageTimetable();
                JFileChooser fileChooser=new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    txtPDF.setText(selectedFile.getAbsolutePath());
                }
                managetable.setId(txtTime_ID.getText());
                managetable.setDepartmentName(txtDepartment.getSelectedItem().toString());
                managetable.setLevel(txtLevel.getSelectedItem().toString());

                // read the selected file and set the bytes to the PDF property of the managetable object
                try {
                    File pdfFile = new File(txtPDF.getText());
                    byte[] pdfData= Files.readAllBytes(pdfFile.toPath());
                    managetable.setPdf(pdfData[0]);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to read PDF file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    ManageTimetable.addTimetable(managetable);
                    timeTable.setModel(managetable.showTimetable());
                    JOptionPane.showMessageDialog(null, "Timetable added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to add timetable: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });




        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        Timetable timetable=new Timetable();
    }
}
