package com.example;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoonMissionRepositoryImpl implements MoonMissionRepository {
    private final DataSource dataSource;

    public MoonMissionRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<String> listMoonMissions() {
        String sql = "select * from moon_mission";
        List<String> moonMissions = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                moonMissions.add(rs.getString("spacecraft"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return moonMissions;
    }
    @Override
    public List<MoonMission> getMoonMissionById(String id) {
        List<MoonMission> moonMissions = new ArrayList<>();
        String sql = "select * from moon_mission where mission_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    MoonMission m = new MoonMission(
                            rs.getInt("mission_id"),
                            rs.getString("spacecraft"),
                            rs.getDate("launch_date"),
                            rs.getString("carrier_rocket"),
                            rs.getString("operator"),
                            rs.getString("mission_type"),
                            rs.getString("outcome"));
                    moonMissions.add(m);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return moonMissions;
    }

    @Override
    public int missionsCountByYear(int year) {
        int count = 0;
        String sql = "select count(*) as mission_count from moon_mission where year(launch_date) = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, year);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt("mission_count");
                }
            }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return count;
        }
}
