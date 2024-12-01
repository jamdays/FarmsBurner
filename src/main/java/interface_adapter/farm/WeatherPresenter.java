package main.java.interface_adapter.farm;

import main.java.use_case.getweather.GetWeatherOutputBoundary;

public class WeatherPresenter implements GetWeatherOutputBoundary {
    private final FarmViewModel farmViewModel;

    public WeatherPresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }

    @Override
    public void weather(String weather, boolean day){
        ((FarmState) (farmViewModel.getState())).setWeather(weather, day);
        farmViewModel.firePropertyChanged("weather");
    }
}
