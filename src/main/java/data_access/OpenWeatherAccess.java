package main.java.data_access;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import com.github.prominence.openweathermap.api.model.forecast.Forecast;
import com.github.prominence.openweathermap.api.model.forecast.WeatherForecast;

/**
 * Open weather access.
 */
public class OpenWeatherAccess implements OpenWeatherAccessInterface {

    private String apiKey;
    private OpenWeatherMapClient openWeatherMapClient;

    public OpenWeatherAccess(String apiKey) {
        this.apiKey = apiKey;
        openWeatherMapClient = new OpenWeatherMapClient(apiKey);
    }

    // returns a list of 4 strings, containing (in order) the city name, temperature, conditions and cloud coverage %
    public List<String> currentDisplayInfoForCity(String city) {
        String currentInfoJSON = openWeatherMapClient
                .currentWeather()
                .single()
                .byCityName(city)
                .language(Language.ENGLISH)
                .unitSystem(UnitSystem.METRIC)
                .retrieve()
                .asJSON();

        JsonNode parent = null;
        try {
            parent = new ObjectMapper().readTree(currentInfoJSON);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }

        // parse currentInfoJSON string using Jackson to get details regarding city name,
        // temperature, conditions and cloud coverage
        String temp = "Temperature: " + parent.get("main").get("temp").toString() + "°C";
        String conditions = "Conditions: " + parent.get("weather").get(0).get("description").textValue();
        String cloudCoverage = "Cloud Coverage: " + parent.get("clouds").get("all").toString() + "%";

        // return list containing city name, temperature, current conditions and cloud coverage %, in that order
        List<String> list = new ArrayList<>();
        list.add(city);
        list.add(temp);
        list.add(conditions);
        list.add(cloudCoverage);

        return list;

    }

    /**
     * Current weather type for city.
     * @param city .
     * @return weather type.
     * @throws RuntimeException .
     */
    public String currentWeatherTypeForCity(String city) {
        String currentInfoJSON = openWeatherMapClient
                .currentWeather()
                .single()
                .byCityName(city)
                .language(Language.ENGLISH)
                .unitSystem(UnitSystem.METRIC)
                .retrieve()
                .asJSON();

        JsonNode parent = null;
        try {
            parent = new ObjectMapper().readTree(currentInfoJSON);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }

        // parse JSON to get and return the current weather type
        String weatherType = parent.get("weather").get(0).get("main").textValue();
        return weatherType;
    }

    /**
     * Forecast info for city.
     * @param city .
     * @return forecast.
     */
    public String forecastInfoForCity(String city) {
        return openWeatherMapClient
                .forecast5Day3HourStep()
                .byCityName(city)
                .language(Language.ENGLISH)
                .unitSystem(UnitSystem.METRIC)
                .count(15)
                .retrieve()
                .asJava()
                .toString();
    }

    @Override
    public List<Long> getTimesForCity(String city) {

        String json = jsonforcity(city);

        JsonNode parent = null;
        try {
            parent = new ObjectMapper().readTree(json);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }

        // parse JSON using Jackson to get current time, sunrise time and sunset time for the city
        String currentTimeString = parent.get("dt").toString();
        Long currentTime = Long.valueOf(currentTimeString);
        String sunriseTimeString = parent.get("sys").get("sunrise").toString();
        Long sunriseTime = Long.valueOf(sunriseTimeString);
        String sunsetTimeString = parent.get("sys").get("sunset").toString();
        Long sunsetTime = Long.valueOf(sunsetTimeString);

        List<Long> returnList = new ArrayList<>();
        returnList.add(currentTime);
        returnList.add(sunriseTime);
        returnList.add(sunsetTime);
        return returnList;
    }

    // for testing

    /**
     * JSON for city.
     * @param city .
     * @return JSON.
     */
    public String jsonforcity(String city) {
        return openWeatherMapClient
                .currentWeather()
                .single()
                .byCityName(city)
                .language(Language.ENGLISH)
                .unitSystem(UnitSystem.METRIC)
                .retrieve()
                .asJSON();
    }

}
