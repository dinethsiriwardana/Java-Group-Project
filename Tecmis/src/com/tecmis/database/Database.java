package com.tecmis.database;

import java.sql.*;

public class Database {

    public static Connection conn;

    public static void main(String[] args) throws Exception {
        getDatabaseConnection();
    }


    public static Connection getDatabaseConnection() throws Exception{
        // Load the MySQL JDBC driver
        Class.forName("org.mariadb.jdbc.Driver");
        // Create a connection to the database
        conn = DriverManager.getConnection(
                "jdbc:mariadb://191.96.56.1:3306/u812963415_javag2", "u812963415_javag2", "qEc:0f=5");
        return conn;
    }

}
