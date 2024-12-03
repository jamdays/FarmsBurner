package main.java.interface_adapter.farm;

import java.util.List;

import main.java.use_case.getweather.GetWeatherInputBoundary;

/**
 * Weather controller.
 */
public class WeatherController {
    private final GetWeatherInputBoundary weatherInteractor;

    public WeatherController(GetWeatherInputBoundary weatherInteractor) {
        this.weatherInteractor = weatherInteractor;
    }

    /**
     * Weather.
     * @return weather.
     */
    public List<String> weather() {
        return weatherInteractor.execute();
    }

}
