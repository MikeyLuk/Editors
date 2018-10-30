package com.andymitchell.divedb.data.role;

import com.andymitchell.divedb.logic.role.Role;
import com.andymitchell.divedb.logic.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class SqlRoleRepository implements RoleRepository {
    private static final String TABLE_NAME = "role";
    private final RoleMapper roleMapper = new RoleMapper();

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public SqlRoleRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Role findByRole(String role) {
        String query = "SELECT * from " + TABLE_NAME + " where role = :role";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("role", role);
        return jdbcTemplate.queryForObject(query, namedParameters, roleMapper);

    }

}
