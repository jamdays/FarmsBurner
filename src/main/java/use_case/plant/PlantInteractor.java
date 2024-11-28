package main.java.use_case.plant;

import main.java.entity.FarmSingleton;

import java.io.IOException;

public class PlantInteractor implements PlantInputBoundary{
    private final PlantOutputBoundary outputBoundary;

    public PlantInteractor(PlantOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }
    @Override
    public void execute(int r, int c) {
        try {
            FarmSingleton.getInstance().getFarm().plant(r, c);
            outputBoundary.addCrop(r, c);
        }
        catch (PlantingException e) {
            System.out.println(e.getMessage());
        }
    }
}

