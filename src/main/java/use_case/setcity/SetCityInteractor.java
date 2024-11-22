package main.java.use_case.setcity;

import main.java.entity.FarmSingleton;

public class SetCityInteractor implements SetCityInputBoundary{
    SetCityOutputBoundary setCityOutputBoundary;

    public SetCityInteractor(SetCityOutputBoundary setCityOutputBoundary) {
        this.setCityOutputBoundary = setCityOutputBoundary;
    }

    @Override
    public void execute(String city) {
        setCityOutputBoundary.setCity(city);
    }
}
