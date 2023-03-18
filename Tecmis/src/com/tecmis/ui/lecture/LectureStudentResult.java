package com.tecmis.ui.lecture;

import com.tecmis.database.Database;
import com.tecmis.dto.ManageSubject;
import com.tecmis.dto.SubjectBulkResult;
import com.tecmis.dto.SubjectDetails;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Arrays;

public class LectureStudentResult extends JFrame {
    private JButton btnuploadMarks;
    private JComboBox<String> comboBox1;
    private JButton btnDownload;
    private JPanel pnlLecStuResult;
    private JTable table1;
    private JButton btnTotalQuizMarks;
    private JButton btnUploadMarks;

    private final SubjectBulkResult subjectBulkResult = new SubjectBulkResult();

    private final ManageSubject manageSubject = new ManageSubject();

    private SubjectDetails subjectDetails = new SubjectDetails();


    public LectureStudentResult() {

        add(pnlLecStuResult);
        setVisible(true);
        setTitle("Student");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setPreferredSize(new Dimension(220, 400));
        setResizable(false);

        comboBox1.setModel(subjectDetails.getSubjectModel());
        btnDownload.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Connection conn = Database.getDatabaseConnection();

                    String sql = "SELECT * FROM "+comboBox1.getModel().getSelectedItem()+"_marks";
                    System.out.println(sql);
                    Statement statement = conn.createStatement();
                    ResultSet resultset = statement.executeQuery(sql);
                    String fileName = comboBox1.getModel().getSelectedItem()+".csv";
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setSelectedFile(new File(fileName)); // Set the default name to the resource file name
                    fileChooser.setDialogTitle("Save file");
                    int userSelection = fileChooser.showSaveDialog(null);
                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        File fileToSave = fileChooser.getSelectedFile();
                        String csvFilePath = fileToSave.getAbsolutePath();
                        FileWriter fileWriter = new FileWriter(csvFilePath);

                        // Get column names from ResultSetMetaData
                        ResultSetMetaData metadata = resultset.getMetaData();
                        int columnCount = metadata.getColumnCount();
                        for (int i = 1; i <= columnCount; i++) {
                            fileWriter.append(metadata.getColumnName(i));
                            if (i < columnCount) {
                                fileWriter.append(",");
                            }
                        }
                        fileWriter.append("\n");
                        while (resultset.next()) {
                            for (int i = 1; i <= columnCount; i++) {
                                String value = resultset.getString(i);
                                fileWriter.append(value);
                                if (i < columnCount) {
                                    fileWriter.append(",");
                                }
                            }
                            fileWriter.append("\n");
                        }
                        fileWriter.close();
                        JOptionPane.showMessageDialog(null, "File downloaded successfully.\nPlease Fill it and upload");
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

        btnUploadMarks.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel model =  subjectBulkResult.getModel();

                super.mouseClicked(e);
                int rows = model.getRowCount();
                int columns = model.getColumnCount();

                System.out.println("rows"+rows+" columns "+columns);

                Object[][] data = new Object[rows][columns];

//                System.out.println(Arrays.deepToString(data));

                for (int row = 0; row < rows; row++) {
                    for (int column = 0; column < columns; column++) {
//                        System.out.println(model.getValueAt(row, column));
                        data[row][column] = model.getValueAt(row, column);
                    }
                }
                // Construct SQL query to create table
                String[] columnNames = new String[columns];

                for (int column = 0; column < columns; column++) {
                    columnNames[column] = model.getColumnName(column);
                }

                try {
                    Connection conn = Database.getDatabaseConnection();
                    Statement stmt = conn.createStatement();
                    for (int row = 0; row < rows; row++) {
                        String[] values = new String[columns];
                        for (int column = 0; column < columns; column++) {
                            if (column == 0) {
                                values[column] = "'" + data[row][column].toString() + "'";
                            } else if (data[row][column] == null || data[row][column] == "") {
                                values[column] = "NULL";
                            } else {

                                values[column] = data[row][column].toString();
                            }
                        }
                        String insertSql = "INSERT INTO "+comboBox1.getModel().getSelectedItem()+" (" +
                                String.join(", ", columnNames) + ") " +
                                "VALUES (" + String.join(", ", values) + ")";
                        System.out.println(insertSql);
                        stmt.executeUpdate(insertSql);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    public static void main(String[] args) {
        LectureStudentResult lectureStudentResult = new LectureStudentResult();
    }
}
