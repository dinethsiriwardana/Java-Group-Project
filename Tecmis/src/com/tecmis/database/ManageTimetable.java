package com.tecmis.database;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ManageTimetable {
    private String id;
    private String departmentName;
    private String level;
    private byte pdf;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public static void addTimetable() {
        // Create a file chooser dialog
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Timetable File");

        // Show the dialog and wait for the user to select a file
        int result = fileChooser.showOpenDialog(new JFrame());
        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File selectedFile = fileChooser.getSelectedFile();

            // Create a new file to save the timetable in the project directory
            String fileName = selectedFile.getName();
            File timetableFile = new File(fileName);

            // Copy the selected file to the new file
            try (InputStream in = new FileInputStream(selectedFile);
                 OutputStream out = new FileOutputStream(timetableFile)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error saving timetable file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Read the timetable data from the file and add it to the timetable table
            try (BufferedReader reader = new BufferedReader(new FileReader(timetableFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Parse the line and add it to the timetable table
                    // ...
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error reading timetable file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
