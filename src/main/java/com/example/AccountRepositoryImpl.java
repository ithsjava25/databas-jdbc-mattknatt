package com.example;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {
    private final DataSource dataSource;

    public AccountRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<String> findUsernames() {
        List<String> usernames = new ArrayList<>();
        String sql = "select * from account";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                usernames.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usernames;
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        String sql = "select * from account where name = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    Account account = new Account(
                            rs.getInt("user_id"),
                            rs.getString("name"),
                            rs.getString("password"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("ssn")
                    );
                    return Optional.of(account);
                }
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();
        String sql = "select * from account";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery() ){
            while (rs.next()) {
                Account a = new Account(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("ssn")
                );
                accounts.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }

    @Override
    public boolean createAccount(Account account) {
        String sql = "insert into account(name, password, first_name, last_name, ssn) values (?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, account.getName());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getFirst_name());
            ps.setString(4, account.getLast_name());
            ps.setString(5, account.getSsn());

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean updatePassword(int id, String password) {
        String sql = "update account set password=? where user_id=?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, password);
            ps.setInt(2, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean deleteAccount(int id) {
        String sql = "delete from account where user_id=?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

}
