package main.java.use_case.setcity;

/**
 * Set city input boundary.
 */
public interface SetCityInputBoundary {
    /**
     * Executes set city, for the city.
     * @param city the city to be set to
     */
    void execute(String city);
}
