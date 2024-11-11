package main.java.use_case.plant;

import main.java.entity.FarmSingleton;

public class PlantInteractor implements PlantInputBoundary{
    private final PlantOutputBoundary outputBoundary;

    public PlantInteractor(PlantOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }
    @Override
    public void execute(int r, int c) {
        outputBoundary.addCrop(r, c);
        FarmSingleton.getInstance().getFarm().plant(r, c);
    }
}

