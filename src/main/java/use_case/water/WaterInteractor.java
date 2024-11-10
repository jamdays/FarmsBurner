package main.java.use_case.water;

import main.java.use_case.plant.PlantOutputBoundary;

public class WaterInteractor implements WaterInputBoundary{
    private final WaterOutputBoundary outputBoundary;
    public WaterInteractor(WaterOutputBoundary outputBoundary, int r, int c) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(int r, int c) {
        outputBoundary.water(r, c);
    }
}
