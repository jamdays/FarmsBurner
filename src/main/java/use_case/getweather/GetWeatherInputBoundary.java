package main.java.use_case.getweather;

import java.util.List;

/**
 * Get weather input boundary.
 */
public interface GetWeatherInputBoundary {

    /**
     * Executes code for get weather use case and returns current weather.
     * @return the weather conditions at the city
     * @throws InvalidCityException if the city is invalid
     */
    List<String> execute() throws InvalidCityException;
}
