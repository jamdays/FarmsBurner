package main.java.interface_adapter.farm;

import main.java.use_case.forecast.ForecastInputBoundary;
import main.java.use_case.forecast.ForecastOutputBoundary;

import java.util.List;

public class ForecastController {
    private ForecastInputBoundary forecastController;

    public ForecastController(ForecastInputBoundary forecastController) {
        this.forecastController = forecastController;
    }

    public List<String> forecast(){
        return forecastController.forecast();
    }

}
