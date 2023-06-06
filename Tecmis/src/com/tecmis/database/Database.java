package com.tecmis.database;

import java.sql.*;

public class Database {
    private static Connection conn;



    public static Connection getDatabaseConnection() throws Exception {
        // Load the MySQL JDBC driver
        Class.forName("org.mariadb.jdbc.Driver");
        // Create a connection to the database
        conn = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/u812963415_javag2", "root", "Rsm1129#");
        return conn;
    }



}
