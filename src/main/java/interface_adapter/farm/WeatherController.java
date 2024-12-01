package main.java.interface_adapter.farm;

import main.java.use_case.getweather.GetWeatherInputBoundary;
import main.java.use_case.water.WaterInputBoundary;

import java.util.List;

public class WeatherController {
    private final GetWeatherInputBoundary weatherInteractor;

    public WeatherController(GetWeatherInputBoundary weatherInteractor) {
        this.weatherInteractor = weatherInteractor;
    }


    public List<String> weather(){
        return weatherInteractor.execute();
    }

}
