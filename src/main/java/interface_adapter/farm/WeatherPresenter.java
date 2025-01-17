package main.java.interface_adapter.farm;

import main.java.use_case.getweather.GetWeatherOutputBoundary;

/**
 * Weather presenter.
 */
public class WeatherPresenter implements GetWeatherOutputBoundary {
    private final FarmViewModel farmViewModel;

    public WeatherPresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }

    @Override
    public void weather(String weather, int day, long time, int temp) {
        ((FarmState) (farmViewModel.getState())).setWeather(weather, day, time, temp);
        farmViewModel.firePropertyChanged("weather");
    }
}
