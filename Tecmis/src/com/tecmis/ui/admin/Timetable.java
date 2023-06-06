package com.tecmis.ui.admin;


import com.tecmis.database.Database;
import com.tecmis.database.ManageTimetable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Timetable extends JFrame {
    private JTextField txtTime_ID;

    private JButton deleteButton;
    private JButton btn_up;
    private JPanel pnlTimetable;
    private JComboBox txtLevel;
    private JButton downloadButton;
    private JComboBox txtDepartment;
    private JTable timeTable;
    private JTextField txtFilePath;
    private JButton backButton;
    private JButton btn_browse;

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
                AdminDashboard object = new AdminDashboard();
                object.setVisible(true);
            }
        });

        btn_up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timetableId = txtTime_ID.getText();
                String department = txtDepartment.getSelectedItem().toString();
                String level = txtLevel.getSelectedItem().toString();
                String filePath = txtFilePath.getText();

                managetables.uploadTimetable(timetableId, department, level, filePath);
                try {
                    DefaultTableModel model = managetables.showTimetable();
                    timeTable.setModel(model);
                    txtTime_ID.setText("");
                    txtDepartment.setSelectedItem("");
                    txtLevel.setSelectedItem("");
                    txtFilePath.setText("");

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

                int result = JOptionPane.showConfirmDialog(null, "Do you want to download the file?", "File Download", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    File file = new File(filePath);
                    if (file.exists()) {
                        try {
                            Desktop.getDesktop().open(file);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Failed to open file", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "File does not exist", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        });
        btn_browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    txtFilePath.setText(selectedFile.getAbsolutePath());

                }

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageTimetable manageTimetable = new ManageTimetable();
                manageTimetable.setId(txtTime_ID.getText());
                manageTimetable.setDepartmentName(txtDepartment.getSelectedItem().toString());
                manageTimetable.setLevel(txtLevel.getSelectedItem().toString());
                manageTimetable.setFile_path(txtFilePath.getText().getBytes());

                try {
                    ManageTimetable.deleteTimetable(manageTimetable);
                    DefaultTableModel model = manageTimetable.showTimetable();
                    timeTable.setModel(model);


                    txtTime_ID.setText("");
                    txtDepartment.setSelectedItem("");
                    txtLevel.setSelectedItem("");
                    txtFilePath.setText("");

                    JOptionPane.showMessageDialog(null, "Timetable delete successfully");


                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Timetable to delete course",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

        });
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = timeTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a timetable to download.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                String timetableId = timeTable.getValueAt(selectedRow, 0).toString(); // Assuming timetable ID is stored in the first column
                String filePath = timeTable.getValueAt(selectedRow, 3).toString(); // Assuming file path is stored in the fourth column
                ManageTimetable manageTimetable = new ManageTimetable();
                manageTimetable.downlaodTimetable();


                // Prompt the user to enter the timetable ID
                timetableId = JOptionPane.showInputDialog(null, "Enter Timetable ID:");

                // Check if the user entered a timetable ID
                if (timetableId != null && !timetableId.isEmpty()) {
                    //managetables.uploadTimetable(timetableId,department,level,filePath);
                    // Add code for downloading the timetable
                } else {
                    // Display an error message or handle the case where no timetable ID was provided
                }
            }
        });

    }




    public static void main(String[] args) {
        Timetable timetable=new Timetable();
    }
}



