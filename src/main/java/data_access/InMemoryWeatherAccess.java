package main.java.data_access;

import java.util.ArrayList;
import java.util.List;

/**
 * In memory weather access.
 */
public class InMemoryWeatherAccess implements OpenWeatherAccessInterface {
    private String condition;
    private List<Long> times;
    private long startofday;

    /**
     * The non-default constructor.
     * @param condition the weather condition
     * @param times the times
     * @param startofday the start of day
     * @throws IllegalArgumentException if the times are incorrect,
     *      if the times are not all after or equal to start of day
     *      if the times are not before end of day (startofday + 86400)
     *      if sunset is after sunrise
     *      if there are not 3 times in the List
     */
    public InMemoryWeatherAccess(String condition, List<Long> times, Long startofday) {
        if (times.size() < 3) {
            throw new IllegalArgumentException("Time list must contain at least 3 elements");
        }
        if (times.get(0) < startofday || times.get(1) < startofday || times.get(2) < startofday) {
            throw new IllegalArgumentException("Times must be after or equal to start of day");
        }
        if (times.get(0) > startofday + 86400L || times.get(1) > startofday + 86400L || times.get(2) > startofday + 86400L) {
            throw new IllegalArgumentException("Times must be after or equal to end of day");
        }
        this.condition = condition;
        this.times = times;
        this.startofday = startofday;
    }

    public InMemoryWeatherAccess() {
        this.condition = "Clear";
        this.times = new ArrayList<>();
        times.add(0L);
        // Sets sunrise to 8am
        times.add(28800L);
        // Sets sunset to 8pm
        times.add(57600L);
    }
    /**
     * Executes code for calling the OpenWeatherMap API to get current information for a city.
     * @param city the city that they call for (doesn't matter because it is the MockDao)
     * @return list of strings which is the current info for the city
     */

    @Override
    public List<String> currentDisplayInfoForCity(String city) {
        List<String> result = new ArrayList<>();
        result.add("hi");
        result.add(" 15°C");
        result.add(" 15°C");
        result.add(" 15°C");
        result.add(" 15°C");
        return result;
    }

    /**
     * Mocks call to the OpenWeatherMap API to get current weather type.
     * this can be used for setting the background image and weather view popup icon based on the current weather type
     *
     * @param city the city that they call from (doesn't matter because it's a MockDao)
     * @return the condition
     */
    @Override
    public String currentWeatherTypeForCity(String city) {
        return this.condition;
    }

    /**
     * Executes code for calling the OpenWeatherMap API to get forecast information for a city.
     *
     * @param city the city that they call for weather info from (doesn't matter because it is a mockDAO)
     * @return empty string because we don't need it for testing
     */
    @Override
    public String forecastInfoForCity(String city) {
        return "";
    }

    /**
     * Executes mock call to OpenWeatherMap API to get time information for a city.
     * @return the current time, sunrise time and sunset time for the city (in unix epoch time)
     *      the returned list has 3 elements; at index 0 is the current time,
     *      at index 1 is the sunrise time and at index 2 is the sunset time
     */
    @Override
    public List<Long> getTimesForCity(String city) {
        return this.times;
    }

    /**
     * Mock call to OpenWeatherAPI to get JSON.
     * Not used in code so not implemented
     * @return the JSON with the weather for the city
     */
    @Override
    public String jsonforcity(String city) {
        return "";
    }

    /**
     * @param city 
     * @return
     */
    @Override
    public List<String> fiveDayForecast(String city) {
        return List.of();
    }

    /**
     * Set Condition.
     * @param condition .
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * Set times.
     * @param times .
     */
    public void setTimes(List<Long> times) {
        this.times = times;
    }

    /**
     * Updates sunset, times and startOfDay, so it becomes the next day.
     */
    public void nextDay() {
        for (int i = 0; i < times.size(); i++) {
            // adds one day to the time
            times.set(i, times.get(i) + 86400L);
        }

        startofday += 86400L;

    }

    /**
     * Set the time to whatever time it needs to be.
     * @param time the time to be set to
     * @throws IllegalArgumentException if the time is not in the day we are on
     */
    public void setTime(Long time) {
        if (time < startofday || time > startofday + 86400L) {
            throw new IllegalArgumentException("Time must be between 0 and 86400");
        }
        this.times.set(0, time);

    }

    /**
     * Changes the time.
     * If it changes into the next day, updates the sunset, sunrise and startofday
     * @param increment how much to increment the time by
     */
    public void changeTime(Long increment) {
        if (times.get(0) + increment > startofday + 86400L) {
            times.set(1, times.get(1) + 86400L);
            times.set(2, times.get(2) + 86400L);
            startofday += 86400L;
        }
        times.set(0, times.get(0) + increment);
    }

}
