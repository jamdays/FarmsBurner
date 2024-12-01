package main.java.interface_adapter.farm;

import main.java.use_case.harvest.HarvestInputBoundary;

public class HarvestController {
    private final HarvestInputBoundary harvestInteractor;

    public HarvestController(HarvestInputBoundary harvestInteractor) {
        this.harvestInteractor = harvestInteractor;
    }

    public void harvestCrop(int r, int c) {
        harvestInteractor.execute(r, c);
    }
}
