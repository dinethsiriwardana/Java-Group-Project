package com.tecmis.database;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Notices extends Database{




    public JList<String> main() {
        JList<String> jlist;
        List<String> data = new ArrayList<>();
        try {



            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Notice");

//            data.add("<html><br><html>");
            while (rs.next()) {


                String Date = rs.getString("Date");
                String Title = rs.getString("Title");
                String Notice_Des = rs.getString("Notice_Des");


                String Full_Notice = "<HTML><br><div style='font-size: 16px;'><B>&nbsp;" + Date +" - "+ Title + "</B></div><div style='font-size: 12px;'>&nbsp;&nbsp;" + Notice_Des  + "</div><br>";
                System.out.println(Full_Notice);
                data.add(Full_Notice);
                data.add(Full_Notice);
                data.add(Full_Notice);

                data.add(Full_Notice);

            }

           jlist = new JList<>(data.toArray(new String[0]));

            conn.close();
            return jlist;

        } catch (SQLException e) {
            data.add(e.getMessage().toString());
            jlist = new JList<>(data.toArray(new String[0]));
            return jlist;
        }

    }


}
