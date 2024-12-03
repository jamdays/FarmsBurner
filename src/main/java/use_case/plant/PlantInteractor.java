package main.java.use_case.plant;

import main.java.data_access.OpenWeatherAccessInterface;
import main.java.entity.FarmSingleton;

/**
 * Plant Interactor.
 */
public class PlantInteractor implements PlantInputBoundary {
    private final PlantOutputBoundary outputBoundary;
    private final OpenWeatherAccessInterface openWeatherAccess;

    public PlantInteractor(PlantOutputBoundary outputBoundary, OpenWeatherAccessInterface openWeatherAccess) {
        this.outputBoundary = outputBoundary;
        this.openWeatherAccess = openWeatherAccess;
    }

    @Override
    public void execute(int row, int col) {
        try {
            Long time = openWeatherAccess.getTimesForCity(FarmSingleton.getInstance().getFarm().getCity()).get(0);
            FarmSingleton.getInstance().getFarm().plant(row, col, time);
            outputBoundary.addCrop(row, col, time);
        }
        catch (PlantingException plantingException) {
            System.out.println(plantingException.getMessage());
        }
    }
}

