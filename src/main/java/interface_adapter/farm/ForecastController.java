package main.java.interface_adapter.farm;

import java.util.List;

import main.java.use_case.forecast.ForecastInputBoundary;

/**
 * Forecast controller.
 */
public class ForecastController {
    private ForecastInputBoundary forecastController;

    public ForecastController(ForecastInputBoundary forecastController) {
        this.forecastController = forecastController;
    }

    public List<String> forecast(){
        return forecastController.forecast();
    }

}
