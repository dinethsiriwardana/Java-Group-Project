package com.tecmis.ui.admin;

import com.tecmis.database.Course;
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


    public CourseDetails() throws Exception {
        add(panelCourse);
        setVisible(true);
        setTitle("Admin !!!");
        setSize(1000, 600);
        setPreferredSize(new Dimension(220, 400));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Course course = new Course();
        courseTable.setModel(course.showCourses());

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Course course = new Course();
                course.setCourseId(txtID.getText());
                course.setCourseName(txtCourseName.getText());
                course.setCredit(Integer.parseInt(txtCredit.getText()));
                course.setDepID(txtCourseDepID.getText());
                course.setLecID(txtCourseLecID.getText());
                course.setQuiz(txtQuiz.getModel().getSelectedItem().toString());
                course.setAsses(txtAsses.getModel().getSelectedItem().toString());

                try {
                    boolean added = Course.addCourse(course);
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

                }
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to add course",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }


            }
        });


        UPDATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Course course = new Course();
                course.setCourseId(txtID.getText());
                course.setCourseName(txtCourseName.getText());
                if (!txtCredit.getText().isEmpty()) {
                    course.setCredit(Integer.parseInt(txtCredit.getText()));
                }
                course.setDepID(txtCourseDepID.getText());
                course.setLecID(txtCourseLecID.getText());
                course.setQuiz(txtQuiz.getModel().getSelectedItem().toString());
                course.setAsses(txtAsses.getModel().getSelectedItem().toString());
                try {
                    boolean updated = Course.updateCourse(course);
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
                Course course = new Course();
                course.setCourseId(txtID.getText());
                course.setCourseName(txtCourseName.getText());
                if (!txtCredit.getText().isEmpty()) {
                    course.setCredit(Integer.parseInt(txtCredit.getText()));
                }
                course.setDepID(txtCourseDepID.getText());
                course.setLecID(txtCourseLecID.getText());
                course.setQuiz(txtQuiz.getModel().getSelectedItem().toString());
                course.setAsses(txtAsses.getModel().getSelectedItem().toString());

                try {
                    boolean deleted = Course.deleteCourse(course);
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
                Course course=new Course();
                course.setCourseId(txtID.getText());
                course.setCourseName(txtCourseName.getText());
                if (!txtCredit.getText().isEmpty()) {
                    course.setCredit(Integer.parseInt(txtCredit.getText()));
                }
                course.setDepID(txtCourseDepID.getText());
                course.setLecID(txtCourseLecID.getText());
                course.setAsses(txtQuiz.getModel().getSelectedItem().toString());
                course.setAsses(txtAsses.getModel().getSelectedItem().toString());

                try {
                    boolean searched = Course.searchCourse(course);
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

