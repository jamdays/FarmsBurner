package main.java.data_access;

import java.util.ArrayList;
import java.util.List;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import com.github.prominence.openweathermap.api.model.forecast.WeatherForecast;

/**
 * Open forecast access.
 */
public class OpenForecastAccess implements OpenForecastAccessInterface {
    private String apiKey;
    private OpenWeatherMapClient openWeatherMapClient;

    public OpenForecastAccess(String apiKey) {
        this.apiKey = apiKey;
        openWeatherMapClient = new OpenWeatherMapClient(apiKey);
    }

    /**
     * Forecast for city.
     * @param city .
     * @return list of forecast with time, weather state, and hi and low.
     */
    public List<String> fiveDayForecast(String city) {
        List<WeatherForecast> forecastJSON = openWeatherMapClient
                .forecast5Day3HourStep()
                .byCityName(city)
                .language(Language.ENGLISH)
                .unitSystem(UnitSystem.METRIC)
                .count(40)
                .retrieve()
                .asJava().getWeatherForecasts();
        ArrayList<String> out = new ArrayList<>();
        for (int i = 0; i < forecastJSON.size(); i++) {
            out.add(forecastJSON.get(i).getForecastTime().toString());
            out.add(forecastJSON.get(i).getWeatherState().toString());
            out.add("High: " + forecastJSON.get(i).getTemperature().getMaxTemperature().toString());
            out.add("Low: " + forecastJSON.get(i).getTemperature().getMinTemperature().toString());
        }
        return out;
    }

    /**
     * Forecast for city.
     * @param city .
     * @return string, out of the five-day forecast seperated by new lines two new lines evey third one.
     */
    public String fiveDayForecastString(String city) {
        List<String> forecast = fiveDayForecast(city);
        String out = "";
        for (int i = 0; i < forecast.size(); i++) {
            out += forecast.get(i) + "\n";
            if (i > 1 && (i + 1) % 4 == 0) {
                out += "\n";
            }
        }
        return out;
    }
}
