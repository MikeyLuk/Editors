package com.andymitchell.divedb.data.dives;

import com.andymitchell.divedb.data.StatisticMapper;
import com.andymitchell.divedb.logic.statistics.DiveStatistic;
import com.andymitchell.divedb.logic.dives.Dive;
import com.andymitchell.divedb.logic.dives.DiveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Primary
@Repository
public class SqlDiveRepository implements DiveRepository {

    private Logger logger = LoggerFactory.getLogger(SqlDiveRepository.class);

    public static final String TABLE_NAME = "diveapp.dives";
    private final DiveRowMapper rowMapper = new DiveRowMapper();

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public SqlDiveRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Dive save(Dive dive) {
        String query = "INSERT INTO " + TABLE_NAME + " VALUES(null, :date, :location, :durationInMinutes, " +
                ":maxDepthInMeters, :waterConditions, :performedSafetyStop)";
        KeyHolder key = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(dive);
        jdbcTemplate.update(query, namedParameters, key);
        dive.setId(key.getKey().intValue());
        return dive;
    }

    @Override
    public List<Dive> getAllDives() {
        return jdbcTemplate.query("SELECT * FROM " + TABLE_NAME, rowMapper);
    }

    @Override
    public List<Dive> getDivesFromDate(LocalDate date) {
        String query = "SELECT * from " + TABLE_NAME + " where d_date = :date";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("date", date);
        return jdbcTemplate.query(query, namedParameters, rowMapper);
    }

    @Override
    public List<Dive> getDivesFromLocation(String location) {
        String query = "SELECT * from " + TABLE_NAME + " where d_location LIKE :location";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("location",
                "%" + location + "%");
        return jdbcTemplate.query(query, namedParameters, rowMapper);
    }

    @Override
    public List<Dive> getDivesFromDateAndLocation(LocalDate date, String location) {

        String query = "SELECT * from " + TABLE_NAME + " where d_location = :location AND d_date = :date";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("location", location)
                .addValue("date", date);
        return jdbcTemplate.query(query, namedParameters, rowMapper);
    }

    @Override
    public Dive getDiveFromId(int id) {
        String query = "SELECT * from " + TABLE_NAME + " where d_id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
    }

    @Override
    public List<Dive> deleteAllDives() {
        List<Dive> diveList = getAllDives();
        String query = "DELETE FROM " + TABLE_NAME;
        jdbcTemplate.update(query, new EmptySqlParameterSource());
        return diveList;
    }

    @Override
    public Dive deleteDiveFromId(int id) {
        Dive diveToBeDeleted = getDiveFromId(id);

        String query = "DELETE FROM " + TABLE_NAME + " WHERE d_id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        jdbcTemplate.update(query, namedParameters);

        return diveToBeDeleted;
    }

    @Override
    public List<Dive> updateMultipleDives(List<Dive> updatedDiveList) {
        List<Dive> returnDiveList = null;
        String query = "UPDATE " + TABLE_NAME + " SET d_date = :date, d_location = :location, " +
                "d_duration_in_minutes = :durationInMinutes, d_max_depth_in_meters = :maxDepthInMeters, " +
                "d_water_conditions = :waterConditions, d_performed_safety_stop = :performedSafetyStop" +
                " WHERE d_id = :id";
        SqlParameterSource[] namedParameters = new BeanPropertySqlParameterSource[updatedDiveList.size()];

        for (int i = 0; i < updatedDiveList.size(); i++) {
            namedParameters[i] = new BeanPropertySqlParameterSource(updatedDiveList.get(i));
        }

        int[] rowsAltered = jdbcTemplate.batchUpdate(query, namedParameters);
        if (rowsAltered.length > 0) {
            returnDiveList = updatedDiveList;
        }
        return returnDiveList;
    }

    @Override
    public Dive updateDiveFromId(int id, Dive dive) {
        dive.setId(id);
        Dive oldDive = getDiveFromId(id);
        String query = "UPDATE " + TABLE_NAME + " SET d_date = :date, d_location = :location, " +
                "d_duration_in_minutes = :durationInMinutes, d_max_depth_in_meters = :maxDepthInMeters, " +
                "d_water_conditions = :waterConditions, d_performed_safety_stop = :performedSafetyStop" +
                " WHERE d_id = :id";
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(dive);
        KeyHolder key = new GeneratedKeyHolder();
        jdbcTemplate.update(query, namedParameters, key);
        logger.info("Updated dive " + id + " from" + oldDive +" to " + dive);
        return getDiveFromId(id);
    }

    @Override
    public DiveStatistic getDiveStatistic() {
        return StatisticMapper.mapToDiveStatistic(getAllDives());
    }

}
