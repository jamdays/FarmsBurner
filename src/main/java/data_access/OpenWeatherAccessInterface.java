package main.java.data_access;

public interface OpenWeatherAccessInterface {

    /**
     * executes code for calling the OpenWeatherMap API to get current weather for a city
     * @param city, the city to get current weather for (must be a valid city)
     */
    String getWeatherForCity(String city);
}
