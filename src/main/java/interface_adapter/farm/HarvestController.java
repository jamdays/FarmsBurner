package main.java.interface_adapter.farm;

import main.java.use_case.harvest.HarvestInputBoundary;

/**
 * Harvest controller.
 */
public class HarvestController {
    private final HarvestInputBoundary harvestInteractor;

    public HarvestController(HarvestInputBoundary harvestInteractor) {
        this.harvestInteractor = harvestInteractor;
    }

    /**
     * Harvest crop.
     * @param row .
     * @param col .
     */
    public void harvestCrop(int row, int col) {
        harvestInteractor.execute(row, col);
    }
}
