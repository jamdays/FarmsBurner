package main.java.data_access;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import main.java.data_access.OpenWeatherAccessInterface;

public class OpenWeatherAccess  implements OpenWeatherAccessInterface {

    private String apiKey;
    private OpenWeatherMapClient openWeatherMapClient;

    public OpenWeatherAccess(String apiKey) {
        this.apiKey = apiKey;
        openWeatherMapClient = new OpenWeatherMapClient(apiKey);
    }

    public String getWeatherForCity(String city) {
        return openWeatherMapClient
                .currentWeather()
                .single()
                .byCityName(city)
                .language(Language.ENGLISH)
                .unitSystem(UnitSystem.METRIC)
                .retrieve()
                .asJava()
                .toString();
    }
}
