package com.andymitchell.divedb.presentation.api;

import com.andymitchell.divedb.logic.CalculatorService;
import com.andymitchell.divedb.logic.weather.Weather;
import com.andymitchell.divedb.logic.weather.WeatherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class CalculatorAPIController {

    @Resource
    private CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "firstDiveDepthMeters", defaultValue = "0") double firstDiveDepthMeters,
                             @RequestParam(value = "firstDiveLengthMinutes", defaultValue = "0") int firstDiveLengthMinutes,
                             @RequestParam(value = "secondDiveDepthMeters", defaultValue = "0") double secondDiveDepthMeters,
                             @RequestParam(value = "secondDiveLengthMinutes", defaultValue = "0") int secondDiveLengthMinutes) {

        return  calculatorService.planDive(firstDiveDepthMeters, firstDiveLengthMinutes,
                secondDiveDepthMeters, secondDiveLengthMinutes);
    }

    @RestController
    @RequestMapping("/weather")
    public static class WeatherAPIController {

        @Resource
        private WeatherService weatherService;

        @GetMapping("/location/{location}")
        public String getWeather(@PathVariable("location") String location) {

            Weather weather = weatherService.getWeather(location);
            String outputString = "The weather in " + weather.getLocation() + " is:\n";
            outputString += "Description: " + weather.getWeatherDescription() + "\n";
            outputString += "Temperature: " + weather.getTemperatureInCelsius() + "°C\n";
            outputString += "Max Temperature: " + weather.getMaxTemperatureInCelsius()  + "°C\n";
            outputString += "MinTemperature: " + weather.getMinTemperatureInCelsius()  + "°C\n";
            outputString += "Humidity: " + weather.getPercentHumidity()  + "%\n";

            return outputString;
        }
    }
}
