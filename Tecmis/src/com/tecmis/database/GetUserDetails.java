package com.tecmis.database;

import java.sql.*;
import java.util.*;


public class GetUserDetails {


    Database database = new Database();
    Connection conn = database.getConnection();
    public  HashMap<String, String> getUserDetails() throws SQLException {


        Statement stmt = conn.createStatement();

        String query = "SELECT * FROM Lecturer WHERE username = 'lec001'";
        ResultSet rs = stmt.executeQuery(query);

        HashMap<String, String> lecturerData = new HashMap<String, String>();
                if (rs.next()) {

            lecturerData.put("Fname", rs.getString("Fname"));
            lecturerData.put("Lname", rs.getString("Lname"));
            lecturerData.put("Mobile", rs.getString("Mobile"));
            lecturerData.put("Address", rs.getString("Address"));
            lecturerData.put("Age", rs.getString("Age"));
            lecturerData.put("Email", rs.getString("Email"));
            lecturerData.put("DOM", rs.getString("DOM"));
            lecturerData.put("Gender", rs.getString("Gender"));
            lecturerData.put("Position", rs.getString("Position"));
        }
    return  lecturerData;

    }

}
