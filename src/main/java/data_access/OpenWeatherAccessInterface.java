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
    List<String> currentDisplayInfoForCity(String city);

    /**
     * executes code for calling the OpenWeatherMap API to get current weather type
     * this can be used for setting the background image and weather view popup icon based on the current weather type
     *
     * @param city, the city to get weather information for
     * @return the current weather info for the city
     * the return value is guaranteed to be one of: "Clear", "Clouds", "Atmosphere", "Snow", "Rain", "Drizzle" or "Thunderstorm"
     */
    String currentWeatherTypeForCity(String city);

    /**
     * executes code for calling the OpenWeatherMap API to get forecast information for a city
     * @param city, the city to get weather information for
     * @return the weather forecast info for the city
     */
    String forecastInfoForCity(String city);

    /**
     * executes code for calling the OpenWeatherMap API to get time information for a city
     * @param city, the city to get weather information for
     * @return the current time, sunrise time and sunset time for the city (in unix epoch time)
     * the returned list has 3 elements; at index 0 is the current time, at index 1 is the sunrise time and at index 2 is the sunset time
     */
    List<Long> getTimesForCity(String city);

    /**
     * executes code for calling the OpenWeatherMap API to get JSON
     * @param city, the city to get weather information in JSON format for
     * @return the JSON with the weather for the city
     */
    String JSONForCity(String city);

}
