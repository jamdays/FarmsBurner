package main.java.use_case.plant;

import main.java.data_access.OpenWeatherAccessInterface;
import main.java.entity.FarmSingleton;

import java.io.IOException;

public class PlantInteractor implements PlantInputBoundary{
    private final PlantOutputBoundary outputBoundary;
    private final OpenWeatherAccessInterface openWeatherAccess;

    public PlantInteractor(PlantOutputBoundary outputBoundary, OpenWeatherAccessInterface openWeatherAccess) {
        this.outputBoundary = outputBoundary;
        this.openWeatherAccess = openWeatherAccess;
    }
    @Override
    public void execute(int r, int c) {
        try {
            Long time = openWeatherAccess.getTimesForCity(FarmSingleton.getInstance().getFarm().getCity()).get(0);
            FarmSingleton.getInstance().getFarm().plant(r, c, time);
            outputBoundary.addCrop(r, c, time);
        }
        catch (PlantingException e) {
            System.out.println(e.getMessage());
        }
    }
}

