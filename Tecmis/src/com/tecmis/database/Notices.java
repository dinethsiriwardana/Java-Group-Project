package com.tecmis.database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Notices {




    public JList<String> main() {
        JList<String> jlist;
        List<String> data = new ArrayList<>();
        try {

            Database database = new Database();
            Connection conn = database.getConnection();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Notice");


            while (rs.next()) {


                String Date = rs.getString("Date");
                String Title = rs.getString("Title");
                String Notice_Des = rs.getString("Notice_Des");

                String Full_Notice = "<HTML><h2><B>" + Date +" - "+ Title + "</B></h3><h4><I>" + Notice_Des  + "</h4></I>";
                System.out.println(Full_Notice);
                data.add(Full_Notice);
            }

           jlist = new JList<>(data.toArray(new String[0]));

            database.closeConnection();
            return jlist;

        } catch (SQLException e) {
            data.add(e.getMessage().toString());
            jlist = new JList<>(data.toArray(new String[0]));
            return jlist;
        }

    }


}
