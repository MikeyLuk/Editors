package com.andymitchell.divedb.logic.weather;

public class Weather {
    private String location;
    private String weatherDescription;
    private Double temperatureInCelsius;
    private Double minTemperatureInCelsius;
    private Double maxTemperatureInCelsius;
    private Integer percentHumidity;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public Double getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    public void setTemperatureInCelsius(Double temperatureInCelsius) {
        this.temperatureInCelsius = temperatureInCelsius;
    }

    public Double getMinTemperatureInCelsius() {
        return minTemperatureInCelsius;
    }

    public void setMinTemperatureInCelsius(Double minTemperatureInCelsius) {
        this.minTemperatureInCelsius = minTemperatureInCelsius;
    }

    public Double getMaxTemperatureInCelsius() {
        return maxTemperatureInCelsius;
    }

    public void setMaxTemperatureInCelsius(Double maxTemperatureInCelsius) {
        this.maxTemperatureInCelsius = maxTemperatureInCelsius;
    }

    public Integer getPercentHumidity() {
        return percentHumidity;
    }

    public void setPercentHumidity(Integer percentHumidity) {
        this.percentHumidity = percentHumidity;
    }
}
