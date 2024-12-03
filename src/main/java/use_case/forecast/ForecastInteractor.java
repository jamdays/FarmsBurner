package main.java.use_case.forecast;

import java.util.List;

import main.java.data_access.OpenForecastAccessInterface;
import main.java.entity.FarmSingleton;

/**
 * Forecast interactor.
 */
public class ForecastInteractor implements ForecastInputBoundary {
    private final ForecastOutputBoundary outputBoundary;
    private final OpenForecastAccessInterface openForecastAccess;

    public ForecastInteractor(ForecastOutputBoundary outputBoundary, OpenForecastAccessInterface openForecastAccess) {
        this.outputBoundary = outputBoundary;
        this.openForecastAccess = openForecastAccess;
    }

    /**
     * Get the forecast.
     * @return forecast.
     */
    public List<String> forecast() {
        outputBoundary.execute();
        return openForecastAccess.fiveDayForecast(FarmSingleton.getInstance().getFarm().getCity());
    }
}
