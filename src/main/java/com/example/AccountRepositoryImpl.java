package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    Connection connection;
    PreparedStatement findUsernamesStatement;
    PreparedStatement findPasswordsStatement;

    public AccountRepositoryImpl(String jdbc, String username, String password) {
        try {
            connection = DriverManager.getConnection(jdbc, username, password);
            findUsernamesStatement = connection.prepareStatement("select * from account");
            findPasswordsStatement = connection.prepareStatement("select * from account");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> findUsernames() {
        List<String> usernames = new ArrayList<>();
        try {
            ResultSet rs = findUsernamesStatement.executeQuery();
            while (rs.next()) {
                usernames.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usernames;
    }

    @Override
    public List<String> findPasswords() {
        List<String> passwords = new ArrayList<>();
        try {
            ResultSet rs = findPasswordsStatement.executeQuery();
            while (rs.next()) {
                passwords.add(rs.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return passwords;
    }
}
