package com.andymitchell.divedb.data.weather;

import com.andymitchell.divedb.data.weather.models.FullWeatherAPIResponse;
import com.andymitchell.divedb.logic.weather.Weather;
import com.andymitchell.divedb.logic.weather.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;

import static com.andymitchell.divedb.data.weather.WeatherMapper.transformAPIWeatherToWeather;

@Repository
@PropertySource("classpath:weatherAPI.properties")
public class WeatherAPIRepository implements WeatherRepository {

    @Value("${api.weather.baseurl}")
    private String BASE_URL;
    @Value("${api.weather.apikey.param}")
    private String APPID;
    @Value("${api.weather.apikey.value}")
    private String API_KEY;

    private static final String PATH = "weather";
    private static final String QUERY = "q";

    private RestTemplate restTemplate;

    @Autowired
    public WeatherAPIRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Weather getWeather(String location) {
        URI uri = new DefaultUriBuilderFactory()
                .uriString(BASE_URL)
                .path(PATH)
                .queryParam(QUERY,location)
                .queryParam(APPID,API_KEY)
                .build();

        return transformAPIWeatherToWeather(restTemplate.getForObject(uri, FullWeatherAPIResponse.class));
    }
}
