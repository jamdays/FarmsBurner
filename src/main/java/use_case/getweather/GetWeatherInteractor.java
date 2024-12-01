package main.java.use_case.getweather;

import main.java.data_access.OpenWeatherAccessInterface;
import main.java.entity.FarmSingleton;

import java.util.List;


public class GetWeatherInteractor implements GetWeatherInputBoundary {
    private final GetWeatherOutputBoundary outputBoundary;
    private final OpenWeatherAccessInterface openWeatherAccess;

    public GetWeatherInteractor(GetWeatherOutputBoundary outputBoundary, OpenWeatherAccessInterface openWeatherAccess) {
        this.outputBoundary = outputBoundary;
        this.openWeatherAccess = openWeatherAccess;
    }

    public List<String> execute() throws InvalidCityException{
        FarmSingleton farmSingleton = FarmSingleton.getInstance();
        try {
            String weather = openWeatherAccess.currentWeatherTypeForCity(farmSingleton.getFarm().getCity());
        List<Long> times = openWeatherAccess.getTimesForCity(farmSingleton.getFarm().getCity());
        //0 is current, 1 sunrise, 2 sunset
        //30 minutes before or after sunrise/sunset will show sunrise screen
        //1800 = 30 minutes (60*30)
        int day = 1;
        if ((times.get(0) - times.get(1) < 1800 &&
            times.get(0) - times.get(1) > -1800 )||
                (times.get(0) - times.get(2) < 1800 &&
            times.get(0) - times.get(2) > -1800)) {
            day = 2;
        } else if (times.get(0) < times.get(1) || times.get(0) > times.get(2) ) {
            day = 0;
        }
        boolean cloudy = weather.equals("Clouds") | weather.equals("Drizzle");
        boolean rainy = weather.equals("Rain");
        boolean snowy = weather.equals("Snow");
        boolean thunderstorm = weather.equals("Thunderstorm");
        boolean clear = weather.equals("Clear");
        boolean foggy = weather.equals("Atmosphere");
        farmSingleton.getFarm().setWeather(day, rainy, foggy, thunderstorm, snowy, cloudy, clear);
        outputBoundary.weather(weather, day);
        return openWeatherAccess.currentDisplayInfoForCity(farmSingleton.getFarm().getCity());
        } catch (Exception e) {
            throw new InvalidCityException(e.getMessage());
        }
    }
}
