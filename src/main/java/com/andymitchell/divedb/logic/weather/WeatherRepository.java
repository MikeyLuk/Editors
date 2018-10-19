package com.andymitchell.divedb.logic.weather;

public interface WeatherRepository {
    Weather getWeather (String location);
}
