package main.java.use_case.getweather;

import java.util.List;

public interface GetWeatherInputBoundary {

    /**
     * executes code for get weather use case and returns current weather
     */
    List<String> execute();
}
