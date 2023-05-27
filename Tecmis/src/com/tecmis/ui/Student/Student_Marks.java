package com.tecmis.ui.Student;

import javax.swing.*;
import java.awt.*;

public class Student_Marks extends JFrame {
    private JTextArea textArea1;
    private JPanel Jresult;

    public Student_Marks(){
    add(Jresult);
    setVisible(true);
    setTitle("Student Result!!!");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(1500,1500);
    setPreferredSize(new Dimension(220,400));
    setResizable(true);

    }
}
