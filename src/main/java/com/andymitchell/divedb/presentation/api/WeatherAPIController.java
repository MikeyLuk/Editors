package com.andymitchell.divedb.presentation.api;

import com.andymitchell.divedb.logic.authentication.AuthenticationService;
import com.andymitchell.divedb.logic.weather.Weather;
import com.andymitchell.divedb.logic.weather.WeatherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/weather")
public class WeatherAPIController {

    @Resource
    private WeatherService weatherService;

    @Resource
    private AuthenticationService authenticationService;

    @GetMapping("/location/{location}")
    public String getWeather(@PathVariable("location") String location,
                             @RequestParam(name = "token") String token) {
        authenticationService.validateToken(token);

        Weather weather = weatherService.getWeather(location);
        String outputString = "The weather in " + weather.getLocation() + " is:\n";
        outputString += "Description: " + weather.getWeatherDescription() + "\n";
        outputString += "Temperature: " + weather.getTemperatureInCelsius() + "°C\n";
        outputString += "Max Temperature: " + weather.getMaxTemperatureInCelsius() + "°C\n";
        outputString += "MinTemperature: " + weather.getMinTemperatureInCelsius() + "°C\n";
        outputString += "Humidity: " + weather.getPercentHumidity() + "%\n";

        return outputString;
    }
}