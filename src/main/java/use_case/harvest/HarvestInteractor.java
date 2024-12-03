package main.java.use_case.harvest;

import main.java.entity.FarmSingleton;

public class HarvestInteractor implements HarvestInputBoundary {
    private final HarvestOutputBoundary outputBoundary;

    public HarvestInteractor(HarvestOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(int r, int c) {
        try {
            FarmSingleton.getInstance().getFarm().harvest(r, c);
            outputBoundary.harvestCrop(r, c);
        } catch (HarvestException e) {
            System.out.println(e.getMessage());
            return;
        }
        outputBoundary.harvestCrop(r, c);
        FarmSingleton.getInstance().getFarm().harvest(r, c);
    }
}