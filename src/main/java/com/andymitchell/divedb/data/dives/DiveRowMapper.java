package com.andymitchell.divedb.data.dives;

import com.andymitchell.divedb.logic.dives.Dive;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiveRowMapper implements RowMapper<Dive> {
    @Override
    public Dive mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dive dive = new Dive();

        dive.setId(rs.getInt("d_id"));
        dive.setDate(rs.getDate("d_date").toLocalDate());
        dive.setLocation(rs.getString("d_location"));
        dive.setDurationInMinutes(rs.getInt("d_duration_in_minutes"));
        dive.setMaxDepthInMeters(rs.getDouble("d_max_depth_in_meters"));
        dive.setWaterConditions(rs.getString("d_water_conditions"));
        dive.setPerformedSafetyStop(rs.getBoolean("d_performed_safety_stop"));
        dive.setUserId(rs.getInt("d_user_id"));
        return dive;
    }
}
