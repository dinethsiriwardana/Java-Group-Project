package com.tecmis.database;

import java.sql.*;

public class Database {
    private static Connection conn;

    private static Connection connection;

    public static void main(String[] args) throws Exception {
        getDatabaseConnection();
    }

    public static Connection getConnection() {
        if (conn == null) {
            try {
                // Load the MySQL JDBC driver
                Class.forName("org.mariadb.jdbc.Driver");
                // Create a connection to the database
                conn = DriverManager.getConnection(

                "jdbc:mariadb://191.96.56.1:3306/u812963415_javag2", "u812963415_javag2", "qEc:0f=5");

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static Connection getDatabaseConnection() throws Exception{
        // Load the MySQL JDBC driver
        Class.forName("org.mariadb.jdbc.Driver");
        // Create a connection to the database
        connection = DriverManager.getConnection(
                "jdbc:mariadb://191.96.56.1:3306/u812963415_javag2", "u812963415_javag2", "qEc:0f=5");
        return connection;
    }



    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

       }



}