package main.java.use_case.forecast;

import main.java.data_access.OpenWeatherAccessInterface;
import main.java.entity.FarmSingleton;
import main.java.use_case.getactivetool.GetActiveToolOutputBoundary;

import java.util.List;

public class ForecastInteractor implements ForecastInputBoundary {
    private final ForecastOutputBoundary outputBoundary;
    private final OpenWeatherAccessInterface openWeatherAccess;

    public ForecastInteractor(ForecastOutputBoundary outputBoundary, OpenWeatherAccessInterface openWeatherAccess) {
        this.outputBoundary = outputBoundary;
        this.openWeatherAccess = openWeatherAccess;
    }

    /**
     * Get the forecast.
     * @return forecast.
     */
    public List<String> forecast() {
        outputBoundary.execute();
        return openWeatherAccess.fiveDayForecast(FarmSingleton.getInstance().getFarm().getCity());
    }
}
