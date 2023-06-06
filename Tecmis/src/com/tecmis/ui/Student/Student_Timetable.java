package com.tecmis.ui.Student;

import com.tecmis.database.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.*;

public class Student_Timetable extends JFrame{
    private JLabel THeader;
    private JLabel lbl1;
    private JButton downloadButton1;
    private JLabel lbl2;
    private JButton downloadButton2;
    private JLabel lbl3;
    private JButton downloadButton3;
    private JLabel lbl4;
    private JButton downloadButton4;
    private JPanel pnlTimetable;


    public Student_Timetable() throws Exception {
        add(pnlTimetable);
        setVisible(true);
        setTitle("Student !!!");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1500,1500);
        setPreferredSize(new Dimension(220,400));
        setResizable(true);
        Connection conn = Database.getDatabaseConnection();

        downloadButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT File_path FROM Timetable WHERE Timetable_ID = 'T/ID/005'");

                    if (resultSet.next()) {
                        byte[] fileBytes = resultSet.getBytes("File_path");
                        String fileName = "timetable.pdf";

                        // Download the file
                        File selectedFile = chooseFileLocation(fileName);
                        if (selectedFile != null) {
                            String filePath = selectedFile.getAbsolutePath();

                            // Download the file
                            downloadFile(fileBytes, filePath);

                            // Open the downloaded file
                            openFile(filePath);
                        } else {
                            System.out.println("No file location selected.");
                        }
                    } else {
                        System.out.println("No timetable file found.");
                    }
                }
                catch (Exception exception){
                    throw new RuntimeException(exception);
                }
            }
        });

        downloadButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                File selectedFile = chooseFile();
                if (selectedFile != null) {
                    try  {
                        // Prepare the SQL statement
                        String sql = "INSERT INTO Timetable (DepartmentName, Level, File_path) VALUES (?, ?, ?)";
                        PreparedStatement statement = conn.prepareStatement(sql);

                        // Set the values for the statement
                        statement.setString(1, "Your Department");
                        statement.setInt(2, 1);

                        // Set the file as a binary stream
                        FileInputStream fis = new FileInputStream(selectedFile);
                        statement.setBinaryStream(3, fis, (int) selectedFile.length());

                        // Execute the statement
                        int rowsAffected = statement.executeUpdate();

                        if (rowsAffected > 0) {
                            System.out.println("File uploaded successfully.");
                        } else {
                            System.out.println("File upload failed.");
                        }

                    } catch (SQLException | IOException eaa) {
                        eaa.printStackTrace();
                    }
                } else {
                    System.out.println("No file selected for upload.");
                }
            }
        });
    }

    private static File chooseFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }

    private static File chooseFileLocation(String fileName) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(fileName + ".pdf"));

        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }

    private static void downloadFile(byte[] fileBytes, String fileName) {
        try {
            // Save the file to disk
            File file = new File(fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(fileBytes);
            fos.close();

            System.out.println("File downloaded successfully.");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void openFile(String fileName) {
        if (Desktop.isDesktopSupported()) {
            try {
                File file = new File(fileName);
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Desktop is not supported.");
        }
    }

    public static void main(String[] args) throws Exception {
        Student_Timetable timetable=new Student_Timetable();
    }
}
