package main.java.use_case.forecast;

import java.util.List;

public interface ForecastInputBoundary {
    /**
     * @return the forecast.
     */
    List<String> forecast();
}
