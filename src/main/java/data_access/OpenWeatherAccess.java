package main.java.data_access;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import main.java.data_access.OpenWeatherAccessInterface;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class OpenWeatherAccess  implements OpenWeatherAccessInterface {

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
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }

        // parse currentInfoJSON string using Jackson to get details regarding city name, temperature, conditions and cloud coverage
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
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }

        // parse JSON to get and return the current weather type
        String weatherType = parent.get("weather").get(0).get("main").textValue();
        return weatherType;
    }

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
    public List<Integer> getTimesForCity(String city) {

        String JSON = JSONForCity(city);

        JsonNode parent = null;
        try {
            parent = new ObjectMapper().readTree(JSON);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }

        // parse JSON using Jackson to get current time, sunrise time and sunset time for the city
        String currentTimeString = parent.get("dt").toString();
        Integer currentTime = Integer.valueOf(currentTimeString);
        String sunriseTimeString = parent.get("sys").get("sunrise").toString();
        Integer sunriseTime = Integer.valueOf(sunriseTimeString);
        String sunsetTimeString = parent.get("sys").get("sunset").toString();
        Integer sunsetTime = Integer.valueOf(sunsetTimeString);

        List<Integer> returnList = new ArrayList<>();
        returnList.add(currentTime);
        returnList.add(sunriseTime);
        returnList.add(sunsetTime);
        return returnList;
    }

    // for testing
    public String JSONForCity(String city) {
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
