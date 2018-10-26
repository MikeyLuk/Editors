package com.andymitchell.divedb.data;

import com.andymitchell.divedb.logic.User;
import com.andymitchell.divedb.logic.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class SqlUserRepository implements UserRepository {
    private static final String TABLE_NAME = "user";
    private final UserMapper userMapper = new UserMapper();

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public SqlUserRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findByEmail(String email) {
        String query = "SELECT * from " + TABLE_NAME + " where email = :email";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("email", email);
        try {
            return jdbcTemplate.queryForObject(query, namedParameters, userMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public User save(User user) {
        String query = "INSERT INTO " + TABLE_NAME + " VALUES(null, :active, :email, :lastName, :name," +
                ":password)";
        KeyHolder key = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(user);
        jdbcTemplate.update(query, namedParameters, key);
        user.setId(key.getKey().intValue());
        return user;
    }
}
