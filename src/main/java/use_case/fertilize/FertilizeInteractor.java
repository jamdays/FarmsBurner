package main.java.use_case.fertilize;

import main.java.entity.FarmSingleton;

/**
 * Fertilize interactor.
 */
public class FertilizeInteractor implements FertilizeInputBoundary {
    private final FertilizeOutputBoundary outputBoundary;

    public FertilizeInteractor(FertilizeOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(int row, int col) {
        try {
            FarmSingleton.getInstance().getFarm().fertilize(row, col);
            outputBoundary.fertilize(row, col);
        }
        catch (FertilizeException fertilizeException) {
            System.out.println(fertilizeException.getMessage());
        }

    }

}
