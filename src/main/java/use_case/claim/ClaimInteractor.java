package main.java.use_case.claim;

import main.java.entity.FarmSingleton;

public class ClaimInteractor implements ClaimInputBoundary {
    private final ClaimOutputBoundary outputBoundary;

    public ClaimInteractor(ClaimOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }
    @Override
    public void execute(int r, int c) {
        FarmSingleton.getInstance().getFarm().claim(r, c);
        outputBoundary.claim(r, c);
    }
}

