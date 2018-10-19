package com.andymitchell.divedb.data.weather.models;

public class FullWeatherAPIResponse {
    String name;
    WeatherAPIMain main;
    WeatherAPI[] weather;

    public WeatherAPI[] getWeather() {
        return weather;
    }

    public void setWeather(WeatherAPI[] weather) {
        this.weather = weather;
    }

    public WeatherAPIMain getMain() {
        return main;
    }

    public void setMain(WeatherAPIMain main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
