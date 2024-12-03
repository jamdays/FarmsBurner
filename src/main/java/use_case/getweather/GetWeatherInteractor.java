package main.java.use_case.getweather;

import java.util.List;

import main.java.data_access.OpenWeatherAccessInterface;
import main.java.entity.FarmSingleton;

/**
 * Get weather interactor.
 */
public class GetWeatherInteractor implements GetWeatherInputBoundary {
    private final GetWeatherOutputBoundary outputBoundary;
    private final OpenWeatherAccessInterface openWeatherAccess;

    public GetWeatherInteractor(GetWeatherOutputBoundary outputBoundary, OpenWeatherAccessInterface openWeatherAccess) {
        this.outputBoundary = outputBoundary;
        this.openWeatherAccess = openWeatherAccess;
    }

    /**
     * Exectue.
     * @return Execute.
     * @throws InvalidCityException .
     */
    public List<String> execute() throws InvalidCityException {
        FarmSingleton farmSingleton = FarmSingleton.getInstance();
        try {
            String weather = openWeatherAccess.currentWeatherTypeForCity(farmSingleton.getFarm().getCity());
            List<Long> times = openWeatherAccess.getTimesForCity(farmSingleton.getFarm().getCity());
            // 0 is current, 1 sunrise, 2 sunset
            // 30 minutes before or after sunrise/sunset will show sunrise screen
            // 1800 = 30 minutes (60*30)
            int day = 1;
            if (times.get(0) - times.get(1) < 1800
                    && times.get(0) - times.get(1) > -1800
                    || times.get(0) - times.get(2) < 1800
                    && times.get(0) - times.get(2) > -1800) {
                day = 2;
            }
            else if (times.get(0) < times.get(1) || times.get(0) > times.get(2)) {
                day = 0;
            }
            boolean cloudy = "Clouds".equals(weather) || "Drizzle".equals(weather);
            boolean rainy = "Rain".equals(weather);
            boolean snowy = "Snow".equals(weather);
            boolean thunderstorm = "Thunderstorm".equals(weather);
            boolean clear = "Clear".equals(weather);
            boolean foggy = "Fog".equals(weather) || "Mist".equals(weather) || "Haze".equals(weather);
            String temp = openWeatherAccess.currentDisplayInfoForCity(farmSingleton.getFarm().getCity()).get(1);
            System.out.println(temp);
            float temp_float = Float.parseFloat(temp.substring(temp.indexOf(" ") + 1, temp.indexOf("°C")));
            int temp_int = Math.round(temp_float);
            outputBoundary.weather(weather, day, times.get(0), temp_int);
            farmSingleton.getFarm().setWeather(day, rainy, foggy, thunderstorm, snowy, cloudy, clear, temp_int, weather, times.get(0));
            return openWeatherAccess.currentDisplayInfoForCity(farmSingleton.getFarm().getCity());
        }
        catch (Exception exception) {
            throw new InvalidCityException(exception.getMessage());
        }
    }
}
