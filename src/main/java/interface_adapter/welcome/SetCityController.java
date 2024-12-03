package main.java.interface_adapter.welcome;

import main.java.use_case.setcity.SetCityInputBoundary;

/**
 * Set city controller.
 */
public class SetCityController {
    private final SetCityInputBoundary setCityInputBoundary;

    public SetCityController(SetCityInputBoundary setCityInputBoundary) {
        this.setCityInputBoundary = setCityInputBoundary;
    }

    /**
     * Set city.
     * @param city .
     */
    public void setCity(String city) {
        setCityInputBoundary.execute(city);
    }

}
