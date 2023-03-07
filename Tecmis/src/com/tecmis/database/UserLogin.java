package com.tecmis.database;

import com.tecmis.util.Security;

import java.sql.*;

public class UserLogin {
    public boolean userLogin(String acctype, String username, String password) throws Exception {

        Database database = new Database();
        Connection conn = database.getConnection();

        Security security = new Security();
        String encryptedpwd = security.encryption(password);


        acctype = acctype == "Technical Officer" ? "TechnicalOfficer" : acctype;
        String sql = "SELECT * FROM "+acctype+" WHERE username = ? AND password = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, encryptedpwd);
        ResultSet resultSet = statement.executeQuery();

        return resultSet.next();
    }
}
