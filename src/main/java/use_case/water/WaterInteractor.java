package main.java.use_case.water;

import main.java.entity.FarmSingleton;

/**
 * Water Interactor.
 */
public class WaterInteractor implements WaterInputBoundary {
    private final WaterOutputBoundary outputBoundary;

    public WaterInteractor(WaterOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(int row, int col) {
        FarmSingleton.getInstance().getFarm().water(row, col);
        outputBoundary.water(row, col);
    }
}
