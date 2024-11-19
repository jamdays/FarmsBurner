package main.java.use_case.fertilize;

import main.java.entity.FarmSingleton;

public class FertilizeInteractor implements FertilizeInputBoundary {
    private final FertilizeOutputBoundary outputBoundary;

    public FertilizeInteractor(FertilizeOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(int r, int c) {
        // TODO: land should only be fertilized if it is claimed and not already fertilized
        FarmSingleton.getInstance().getFarm().fertilize(r, c);
        outputBoundary.fertilize(r, c);
    }

}
