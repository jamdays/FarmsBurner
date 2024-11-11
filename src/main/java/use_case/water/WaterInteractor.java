package main.java.use_case.water;

import main.java.entity.FarmSingleton;
import main.java.use_case.plant.PlantOutputBoundary;

public class WaterInteractor implements WaterInputBoundary{
    private final WaterOutputBoundary outputBoundary;
    public WaterInteractor(WaterOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(int r, int c) {
        outputBoundary.water(r, c);
        FarmSingleton.getInstance().getFarm().plant(r, c);
    }
}
