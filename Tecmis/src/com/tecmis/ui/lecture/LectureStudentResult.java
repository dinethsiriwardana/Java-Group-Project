package com.tecmis.ui.lecture;

import com.tecmis.dto.ManageSubject;
import com.tecmis.dto.SubjectBulkResult;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;

public class LectureStudentResult extends JFrame {
    private JButton btnuploadMarks;
    private JComboBox comboBox1;
    private JButton btnDownload;
    private JPanel pnlLecStuResult;
    private JTable table1;

    private SubjectBulkResult subjectBulkResult = new SubjectBulkResult();

    private ManageSubject manageSubject = new ManageSubject();

    public LectureStudentResult() {

        add(pnlLecStuResult);
        setVisible(true);
        setTitle("Student");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setPreferredSize(new Dimension(220, 400));
        setResizable(false);
        btnDownload.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    String fileName = "ICT01.csv";
                    InputStream inputStream = getClass().getResourceAsStream("/com/tecmis/assets/csv/"+fileName);
                    byte[] buffer = new byte[inputStream.available()];
                    inputStream.read(buffer);
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setSelectedFile(new File(fileName)); // Set the default name to the resource file name
                    fileChooser.setDialogTitle("Save file");
                    int userSelection = fileChooser.showSaveDialog(null);
                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        File fileToSave = fileChooser.getSelectedFile();
                        FileOutputStream outputStream = new FileOutputStream(fileToSave);
                        outputStream.write(buffer);
                        JOptionPane.showMessageDialog(null, "File downloaded successfully.\nPlease Fill it and upload");
                        outputStream.close();
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        btnuploadMarks.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    JFileChooser fileChooser = new JFileChooser();
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
                    fileChooser.setFileFilter(filter); // Set the filter to only show CSV files
                    int userSelection = fileChooser.showOpenDialog(null);
                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        File fileToOpen = fileChooser.getSelectedFile();
                        BufferedReader reader = new BufferedReader(new FileReader(fileToOpen));
                        String line;
                        String[] header = reader.readLine().split(",");
                        subjectBulkResult.setModel(header);
                        manageSubject.setTabletitles(header);
                        while ((line = reader.readLine()) != null) {
                            String[] values = line.split(",");
                            System.out.println(Arrays.toString(values));
                            subjectBulkResult.addbulkDataToModel(values);
                        }
                        reader.close();
                        table1.setModel(subjectBulkResult.getModel());
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }

            }
        });
    }

    public static void main(String[] args) {
        LectureStudentResult lectureStudentResult = new LectureStudentResult();
    }
}
