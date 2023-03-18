import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import com.tecmis.database.Database;

import javax.swing.*;

public class TechnicalOfficerForm extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JPanel panel;
    private JButton updateButton;
    private JButton cancelButton;
    private JTextField passwordField;
    private JTextField departmentField;
    private JTextArea addressArea;
    private JTextField userIdField;
    private JComboBox<String> departmentBox;


    public TechnicalOfficerForm(){
        add(panel);
        setVisible(true);
        setTitle("Technical Officer Profile Update");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        setPreferredSize(new Dimension(800,600));
        setResizable(false);

        departmentBox.addItem("IT");
        departmentBox.addItem("Engineering");
        departmentBox.addItem("Research and Development");

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateUserDetails();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void updateUserDetails() {
        int userId = Integer.parseInt(userIdField.getText());
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String password = passwordField.getText();
        String department = departmentBox.getSelectedItem().toString();
        String address = addressArea.getText();

        String sql = "UPDATE users SET name=?, email=?, phone=?, password=?, department=?, address=? WHERE id=?";
        try{
            Connection conn = Database.getDatabaseConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phone);
            statement.setString(4, password);
            statement.setString(5, department);
            statement.setString(6, address);
            statement.setInt(7, userId);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "User details updated successfully!");
        } catch (SQLException ex) {
            System.out.println("Error updating user details: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        TechnicalOfficerForm techOfficer = new TechnicalOfficerForm();
    }
}

