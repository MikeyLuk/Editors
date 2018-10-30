package com.andymitchell.divedb.data.authentication;

import com.andymitchell.divedb.logic.authentication.AuthenticationRepository;
import com.andymitchell.divedb.logic.authentication.Token;
import com.andymitchell.divedb.logic.dives.Dive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class SQLAuthenticationRepository implements AuthenticationRepository {

    private static final String TABLE_NAME = "tokens";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public SQLAuthenticationRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Token createToken() {
        Token token = new Token();

        String tokenName = UUID.randomUUID().toString();
        String query = "INSERT INTO " + TABLE_NAME + " VALUES(null, :token)";
        KeyHolder key = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("token", tokenName);
        jdbcTemplate.update(query, namedParameters, key);
        if (key != null) {
            token.setId(key.getKey().intValue());
            token.setName(tokenName);
        }
        return token;
    }
}
