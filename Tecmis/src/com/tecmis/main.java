//package com.tecmis;
//
//import java.sql.Connection;
//
//public class main {
//    public static void main(String[] args) {
//        try {
//            // Get a connection to the database
//            Connection connection = Database.getConnection();
//
//            // Create a statement object to execute SQL queries
//            Statement statement = connection.createStatement();
//
//
//            // Execute a query and get the results
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");
//
//            // Process the results
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                System.out.println("ID: " + id + ", Name: " + name);
//            }
//
//            // Close the connection when done
//            DatabaseConnection.closeConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
