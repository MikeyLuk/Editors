package com.andymitchell.divedb.data.user;

import com.andymitchell.divedb.logic.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setActive(rs.getInt("active"));
        user.setEmail(rs.getString("email"));
        user.setName(rs.getString("name"));
        user.setLastName(rs.getString("last_name"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
