package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoonMissionRepositoryImpl implements MoonMissionRepository {
    Connection connection;
    PreparedStatement listMoonMissionsStatement;

    public MoonMissionRepositoryImpl(String jdbc, String username, String password) {
        try {
            connection = DriverManager.getConnection(jdbc, username, password);
            listMoonMissionsStatement = connection.prepareStatement("select * from moon_mission");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<String> listMoonMissions() {
        List<String> moonMissions = new ArrayList<>();
        try {
            ResultSet rs = listMoonMissionsStatement.executeQuery();
            while (rs.next()) {
                moonMissions.add(rs.getString("spacecraft"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return moonMissions;
    }
}
