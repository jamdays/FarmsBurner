package main.java.data_access;

public interface OpenWeatherAccessInterface {

    /**
     * executes code for calling the OpenWeatherMap API to get weather information for a city
     * @param city, the city to get weather information for
     */
    String allInfoForCity(String city);

    /**
     * executes code for calling the OpenWeatherMap API to get temperature information for a city
     * @param city, the city to get temperature for
     */
    String temperatureForCity(String city);

    /**
     * executes code for calling the OpenWeatherMap API to get rain information for a city
     * @param city, the city to get rain information for
     */
    String rainForCity(String city);

}
