package com.tecmis.database;

import java.sql.*;

public class Database {
    private static Connection conn;



    public static Connection getDatabaseConnection() throws Exception {
<<<<<<< Updated upstream
        // Load the MySQL JDBC driver
        Class.forName("org.mariadb.jdbc.Driver");
        // Create a connection to the database
        conn = DriverManager.getConnection(
                "jdbc:mariadb://191.96.56.1:3306/u812963415_javag2", "u812963415_javag2", "qEc:0f=5");
=======
          // Load the MySQL JDBC driver
//        Class.forName("org.mariadb.jdbc.Driver");
//        // Create a connection to the database
//        conn = DriverManager.getConnection(
//                "jdbc:mariadb://191.96.56.1:3306/u812963415_javag2", "u812963415_javag2", "qEc:0f=5");

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/u812963415_javag2","root","Danuki@123");

>>>>>>> Stashed changes
        return conn;
    }



}
