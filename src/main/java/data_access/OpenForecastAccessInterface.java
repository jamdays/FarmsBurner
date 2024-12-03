package main.java.data_access;

import java.util.List;

/**
 * Open forecast access interface.
 */
public interface OpenForecastAccessInterface {
    /**
     * Executes code for calling the OpenWeatherMap API to get JSON.
     * @param city the city to get weather information in JSON format for
     * @return the List with the weather for the city
     */
    List<String> fiveDayForecast(String city);
}
