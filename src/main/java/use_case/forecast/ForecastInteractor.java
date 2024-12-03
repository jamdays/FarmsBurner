package main.java.use_case.forecast;

import main.java.data_access.OpenForecastAccess;
import main.java.data_access.OpenForecastAccessInterface;
import main.java.data_access.OpenWeatherAccessInterface;
import main.java.entity.FarmSingleton;
import main.java.use_case.getactivetool.GetActiveToolOutputBoundary;

import java.util.List;

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
