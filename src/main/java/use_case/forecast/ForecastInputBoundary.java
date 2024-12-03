package main.java.use_case.forecast;

import java.util.List;

/**
 * Forecast input boundary.
 */
public interface ForecastInputBoundary {
    /**
     * Forecast.
     * @return the forecast.
     */
    List<String> forecast();
}
