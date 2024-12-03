package main.java.use_case.getweather;

/**
 * Get weather output boundary.
 */
public interface GetWeatherOutputBoundary {

    /**
     * Gets the current weather for the game location selected by the player.
     * @param condition .
     * @param day .
     * @param time .
     * @param temp .
     */
    void weather(String condition, int day, long time, int temp);
}
