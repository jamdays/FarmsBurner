package main.java.use_case.harvest;

import main.java.entity.FarmSingleton;

/**
 * Harvest interactor.
 */
public class HarvestInteractor implements HarvestInputBoundary {
    private final HarvestOutputBoundary outputBoundary;

    public HarvestInteractor(HarvestOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(int row, int col) {
        try {
            FarmSingleton.getInstance().getFarm().harvest(row, col);
            outputBoundary.harvestCrop(row, col);
        }
        catch (HarvestException harvestException) {
            System.out.println(harvestException.getMessage());
            return;
        }
        outputBoundary.harvestCrop(row, col);
        FarmSingleton.getInstance().getFarm().harvest(row, col);
    }
}
