package com.tecmis.ui.admin;



import com.tecmis.database.Course;
import com.tecmis.database.ManageTimetable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;


public class Timetable extends JFrame {
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

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageTimetable managetable = new ManageTimetable();
                JFileChooser fileChooser = new JFileChooser();
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
                    byte[] pdfData = Files.readAllBytes(pdfFile.toPath());
                    managetable.setPdf(pdfData);

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

// to view the document
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = timeTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a timetable to download", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ManageTimetable managetable = new ManageTimetable();
                managetable.setId((String) timeTable.getValueAt(selectedRow, 0)); // assumes the first column is the ID column

                try {
                    byte[] pdfData = ManageTimetable.getTimetable(managetable).getPdf();

                    // Choose a file to save the PDF
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Save PDF File");
                    int userSelection = fileChooser.showSaveDialog(null);
                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        File fileToSave = fileChooser.getSelectedFile();
                        FileOutputStream fos = new FileOutputStream(fileToSave);
                        fos.write(pdfData);
                        fos.close();

                        // Open the downloaded PDF using the Desktop class
                        Desktop.getDesktop().open(fileToSave);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to save PDF file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }

        });


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = timeTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a timetable to delete", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ManageTimetable managetable = new ManageTimetable();
                managetable.setId((String) timeTable.getValueAt(selectedRow, 0)); // assumes the first column is the ID column

                int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this timetable?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirmResult == JOptionPane.YES_OPTION) {
                    try {
                        ManageTimetable.deleteTimetable(managetable);
                        timeTable.setModel(managetable.showTimetable());
                        JOptionPane.showMessageDialog(null, "Timetable deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Failed to delete timetable: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
        });

    }
    public static void main(String[] args) {
        Timetable timetable=new Timetable();
    }
}
