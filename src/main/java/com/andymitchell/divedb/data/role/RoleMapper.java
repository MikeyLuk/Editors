package com.andymitchell.divedb.data.role;

import com.andymitchell.divedb.logic.role.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        Role role = new Role();
        role.setId(rs.getInt("role_id"));
        role.setRole(rs.getString("role"));
        return role;
    }
}
