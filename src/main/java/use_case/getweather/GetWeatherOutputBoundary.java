package main.java.use_case.getweather;

public interface GetWeatherOutputBoundary {

    /**
     * gets the current weather for the game location selected by the player
     */
    void weather(String condition, int day, long time);
}
