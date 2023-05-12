package com.tecmis.ui.admin;

import com.tecmis.database.ManageCourse;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CourseDetails extends JFrame {

    private JTextField txtID;
    private JTextField txtCourseName;
    private JTextField txtCredit;
    private JTextField txtCourseDepID;
    private JTable courseTable;
    private JButton ADDButton;
    private JButton DELETEButton;
    private JButton UPDATEButton;
    private JPanel panelCourse;
    private JTextField txtCourseLecID;
    private JButton searchButton;

    private JComboBox txtQuiz;
    private JComboBox txtAsses;
    private JButton backButton;


    public CourseDetails()  {
        add(panelCourse);
        setVisible(true);
        setTitle("Admin !!!");
        setSize(1000, 600);
        setPreferredSize(new Dimension(220, 400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ManageCourse manageCourse = new ManageCourse();
        courseTable.setModel(manageCourse.showCourses());

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageCourse manageCourse = new ManageCourse();
                manageCourse.setCourseId(txtID.getText());
                manageCourse.setCourseName(txtCourseName.getText());
                manageCourse.setCredit(Integer.parseInt(txtCredit.getText()));
                manageCourse.setDepID(txtCourseDepID.getText());
                manageCourse.setLecID(txtCourseLecID.getText());
                manageCourse.setQuiz(txtQuiz.getModel().getSelectedItem().toString());
                manageCourse.setAsses(txtAsses.getModel().getSelectedItem().toString());

                try {
                    boolean added = ManageCourse.addCourse(manageCourse);
                    txtID.setText("");
                    txtCourseName.setText("");
                    txtCredit.setText("");
                    txtCourseDepID.setText("");
                    txtCourseLecID.setText("");
                    txtQuiz.setSelectedItem("");
                    txtAsses.setSelectedItem("");

                    if (added) {
                        JOptionPane.showMessageDialog(null, "Course added successfully",
                                "Success", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to added course:course not found",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }


                } catch (Exception ex) {
                    System.out.println(ex);
                }


            }
        });


        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageCourse manageCourse = new ManageCourse();
                manageCourse.setCourseId(txtID.getText());
                manageCourse.setCourseName(txtCourseName.getText());
                if (!txtCredit.getText().isEmpty()) {
                    manageCourse.setCredit(Integer.parseInt(txtCredit.getText()));
                }
                manageCourse.setDepID(txtCourseDepID.getText());
                manageCourse.setLecID(txtCourseLecID.getText());
                manageCourse.setQuiz(txtQuiz.getModel().getSelectedItem().toString());
                manageCourse.setAsses(txtAsses.getModel().getSelectedItem().toString());
                try {
                    boolean updated = ManageCourse.updateCourse(manageCourse);
                    txtID.setText("");
                    txtCourseName.setText("");
                    txtCredit.setText("");
                    txtCourseDepID.setText("");
                    txtCourseLecID.setText("");
                    txtQuiz.setSelectedItem("");
                    txtAsses.setSelectedItem("");

                    if (updated) {
                        JOptionPane.showMessageDialog(null, "Course update successful",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{

                        JOptionPane.showMessageDialog(null, "Failed to update course: Course not found",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, "Failed to update course",
                            "ERROR", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageCourse manageCourse = new ManageCourse();
                manageCourse.setCourseId(txtID.getText());
                manageCourse.setCourseName(txtCourseName.getText());
                if (!txtCredit.getText().isEmpty()) {
                    manageCourse.setCredit(Integer.parseInt(txtCredit.getText()));
                }
                manageCourse.setDepID(txtCourseDepID.getText());
                manageCourse.setLecID(txtCourseLecID.getText());
                manageCourse.setQuiz(txtQuiz.getModel().getSelectedItem().toString());
                manageCourse.setAsses(txtAsses.getModel().getSelectedItem().toString());

                try {
                    boolean deleted = ManageCourse.deleteCourse(manageCourse);
                    txtID.setText("");
                    txtCourseName.setText("");
                    txtCredit.setText("");
                    txtCourseDepID.setText("");
                    txtCourseLecID.setText("");
                    txtQuiz.setSelectedItem("");
                    txtAsses.setSelectedItem("");
                    if (deleted) {
                        JOptionPane.showMessageDialog(null, "Course delete successfully",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to delete course: Course not found",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to delete course",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageCourse manageCourse =new ManageCourse();
                manageCourse.setCourseId(txtID.getText());
                manageCourse.setCourseName(txtCourseName.getText());
                if (!txtCredit.getText().isEmpty()) {
                    manageCourse.setCredit(Integer.parseInt(txtCredit.getText()));
                }
                manageCourse.setDepID(txtCourseDepID.getText());
                manageCourse.setLecID(txtCourseLecID.getText());
                manageCourse.setAsses(txtQuiz.getModel().getSelectedItem().toString());
                manageCourse.setAsses(txtAsses.getModel().getSelectedItem().toString());

                try {
                    boolean searched = ManageCourse.searchCourse(manageCourse);
                    txtID.setText("");
                    txtCourseName.setText("");
                    txtCredit.setText("");
                    txtCourseDepID.setText("");
                    txtCourseDepID.setText("");
                    txtQuiz.setSelectedItem("");
                    txtAsses.setSelectedItem("");
                    if (searched) {
                        JOptionPane.showMessageDialog(null, "Course search successfully",
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Failed to search course: course not found",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, "Failed to search course",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminForm object = new AdminForm();
                object.setVisible(true);
            }
        });
    }

            public static void main(String[] args) throws Exception {
                CourseDetails coursedeatil = new CourseDetails();



        }


    }

