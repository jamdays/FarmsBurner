package main.java.interface_adapter.welcome;

import main.java.use_case.load.LoadInputBoundary;
import main.java.use_case.setcity.SetCityInputBoundary;

public class WelcomeController {
    private final SetCityInputBoundary setCityInputBoundary;
    private final LoadInputBoundary loadInputBoundary;

    public WelcomeController(SetCityInputBoundary setCityInputBoundary, LoadInputBoundary loadInputBoundary) {
        this.setCityInputBoundary = setCityInputBoundary;
        this.loadInputBoundary = loadInputBoundary;
    }

    public void setCity(String city){
        setCityInputBoundary.execute(city);
    }

    public void load(){
        loadInputBoundary.load();
    }

}
