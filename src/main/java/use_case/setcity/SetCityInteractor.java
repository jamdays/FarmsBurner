package main.java.use_case.setcity;

import main.java.entity.FarmSingleton;

/**
 * Set city interactor.
 */
public class SetCityInteractor implements SetCityInputBoundary {
    private SetCityOutputBoundary setCityOutputBoundary;

    public SetCityInteractor(SetCityOutputBoundary setCityOutputBoundary) {
        this.setCityOutputBoundary = setCityOutputBoundary;
    }

    @Override
    public void execute(String city) {
        setCityOutputBoundary.setCity(city);
        FarmSingleton.getInstance().getFarm().setCity(city);
    }

}
