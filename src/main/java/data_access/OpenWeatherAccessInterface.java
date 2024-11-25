package main.java.data_access;

import com.github.prominence.openweathermap.api.model.forecast.Forecast;
import com.github.prominence.openweathermap.api.model.forecast.WeatherForecast;
import com.github.prominence.openweathermap.api.model.weather.Weather;

import java.util.List;

public interface OpenWeatherAccessInterface {

    /**
     * executes code for calling the OpenWeatherMap API to get current information for a city
     *
     * @param city, the city to get weather information for
     * @return the current weather info for the city
     */
    List<String> currentInfoForCity(String city);

    /**
     * executes code for calling the OpenWeatherMap API to get forecast information for a city
     * @param city, the city to get weather information for
     * @return the weather forecast info for the city
     */
    String forecastInfoForCity(String city);

}
