package main.java.use_case.claim;

import main.java.entity.FarmSingleton;

/**
 * Claim interactor.
 */
public class ClaimInteractor implements ClaimInputBoundary {
    private final ClaimOutputBoundary outputBoundary;

    public ClaimInteractor(ClaimOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(int row, int col) {
        FarmSingleton.getInstance().getFarm().claim(row, col);
        outputBoundary.claim(row, col);
    }
}

