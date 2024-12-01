package main.java.use_case.getweather;

import main.java.data_access.OpenWeatherAccessInterface;
import main.java.entity.FarmSingleton;


public class GetWeatherInteractor implements GetWeatherInputBoundary {
    private final GetWeatherOutputBoundary outputBoundary;
    private final OpenWeatherAccessInterface openWeatherAccess;

    public GetWeatherInteractor(GetWeatherOutputBoundary outputBoundary, OpenWeatherAccessInterface openWeatherAccess) {
        this.outputBoundary = outputBoundary;
        this.openWeatherAccess = openWeatherAccess;
    }

    public void execute() {
        FarmSingleton farmSingleton = FarmSingleton.getInstance();
        String weather = openWeatherAccess.currentWeatherTypeForCity(farmSingleton.getFarm().getCity());
        boolean cloudy = weather.equals("Clouds") | weather.equals("Drizzle");
        boolean rainy = weather.equals("Rain");
        boolean snowy = weather.equals("Snow");
        boolean thunderstorm = weather.equals("Thunderstorm");
        boolean clear = weather.equals("Clear");
        boolean foggy = weather.equals("Atmosphere");
        boolean day = true;
        farmSingleton.getFarm().setWeather(day, rainy, foggy, thunderstorm, snowy, cloudy, clear);
        outputBoundary.weather(weather, day);

    }
}
