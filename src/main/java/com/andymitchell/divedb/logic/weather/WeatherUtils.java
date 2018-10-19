package com.andymitchell.divedb.logic.weather;

public class WeatherUtils {
    public static Double convertKelvinToCelsius(Double kelvinValue) {
        if (kelvinValue == null) return null;
        return kelvinValue - 273.15;
    }

    public static String capitaliseFirstLetter(String input) {
        if (input == null || input.length() < 1) {
            return input;
        }

        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public static Double roundToTwoDP(Double input) {
        if (input == null) return null;
        return (double) Math.round(input * 100d) / 100d;
    }
}
