package com.tecmis.ui.admin;

import com.tecmis.database.ManageUsers;
import com.tecmis.dto.LecturerData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLecturerForm extends JFrame {


    private JPanel pnlAdmin;
    private JTextField ID;
    private JTextField FirstName;
    private JTextField LastName;
    private JTextField Mobile;
    private JTextArea Address;
    private JTextField Age;
    private JTextField Email;
    private JTextField DOB;
    private JComboBox Gender;
    private JComboBox Position;
    private JButton ADDButton;
    private JButton DELETEButton;
    private JButton UPDATEButton;
    private JTable table1;

    public AddLecturerForm(){
        add(pnlAdmin);
        setVisible(true);
        setTitle("Add Lecturer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(220,400));
        setResizable(false);

        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LecturerData lecturerUser=new LecturerData();
                lecturerUser.setId(ID.getText());
                lecturerUser.setFirstName(FirstName.getText());
                lecturerUser.setLastName(LastName.getText());
                lecturerUser.setMobile(Mobile.getScrollOffset());
                lecturerUser.setAddress(Address.getText());
                lecturerUser.setAge(Age.getScrollOffset());
                lecturerUser.setEmail(Email.getText());
                lecturerUser.setDom(DOB.getText());
                lecturerUser.setGender(Gender.getModel().getSelectedItem().toString());
                lecturerUser.setPosition(Position.getModel().getSelectedItem().toString());

                ManageUsers manageUser=new ManageUsers();
                boolean isAdded=manageUser.addUser(lecturerUser);
                if(isAdded){
                    ID.setText("");
                    FirstName.setText("");
                    LastName.setText("");
                    Mobile.setText("");
                    Address.setText("");
                    Age.setText("");
                    Email.setText("");
                    DOB.setText("");
                    Gender.setText("");
                    Position.setText("");

                }
                else{
                    JOptionPane.showMessageDialog(null, "Please try again later ",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public static void main(String[] args) {

        AddLecturerForm addlec=new AddLecturerForm();
    }
}
