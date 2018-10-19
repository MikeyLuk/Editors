package com.andymitchell.divedb.data.weather;

import com.andymitchell.divedb.data.weather.models.FullWeatherAPIResponse;
import com.andymitchell.divedb.logic.weather.Weather;

import static com.andymitchell.divedb.logic.weather.WeatherUtils.capitaliseFirstLetter;
import static com.andymitchell.divedb.logic.weather.WeatherUtils.convertKelvinToCelsius;
import static com.andymitchell.divedb.logic.weather.WeatherUtils.roundToTwoDP;

public class WeatherMapper {
    public static Weather transformAPIWeatherToWeather(FullWeatherAPIResponse apiWeather) {
        Weather weather = new Weather();

        weather.setWeatherDescription(capitaliseFirstLetter(apiWeather.getWeather()[0].getDescription()));
        weather.setLocation(apiWeather.getName());
        weather.setTemperatureInCelsius(roundToTwoDP(convertKelvinToCelsius(apiWeather.getMain().getTemp())));
        weather.setMinTemperatureInCelsius((roundToTwoDP(convertKelvinToCelsius(apiWeather.getMain().getTemp_min()))));
        weather.setMaxTemperatureInCelsius((roundToTwoDP(convertKelvinToCelsius(apiWeather.getMain().getTemp_max()))));
        weather.setPercentHumidity(apiWeather.getMain().getHumidity());
        return weather;
    }
}
