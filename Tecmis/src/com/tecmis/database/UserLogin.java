package com.tecmis.database;

import com.tecmis.util.Security;

import java.sql.*;

public class UserLogin {

    private String username;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public boolean userLogin(String acctype, String username, String password) throws Exception {

        Security security = new Security();
        String encryptedpwd = security.encryption(password);
        Database database = new Database();
        Connection conn = database.getDatabaseConnection();

        acctype = acctype == "Technical Officer" ? "TechnicalOfficer" : acctype;

        String sql = "SELECT * FROM "+acctype+" WHERE username = ? AND password = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, encryptedpwd);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next() == true){
            System.out.println("Logged as "+ username + " As a " +  acctype);
            this.username = username;
            return true;
        }
        return resultSet.next();
    }
}
