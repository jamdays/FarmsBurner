package main.java.interface_adapter.welcome;

import main.java.use_case.load.LoadInputBoundary;
import main.java.use_case.setcity.SetCityInputBoundary;

public class SetCityController {
    private final SetCityInputBoundary setCityInputBoundary;

    public SetCityController(SetCityInputBoundary setCityInputBoundary, LoadInputBoundary loadInputBoundary) {
        this.setCityInputBoundary = setCityInputBoundary;
    }

    public void setCity(String city){
        setCityInputBoundary.execute(city);
    }


}
