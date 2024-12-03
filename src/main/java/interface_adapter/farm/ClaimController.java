package main.java.interface_adapter.farm;

import main.java.use_case.claim.ClaimInputBoundary;

/**
 * Claim controller.
 */
public class ClaimController {
    private final ClaimInputBoundary claimInteractor;

    public ClaimController(ClaimInputBoundary claimInteractor) {
        this.claimInteractor = claimInteractor;
    }

    /**
     * Claim.
     * @param row .
     * @param col .
     */
    public void claim(int row, int col) {
        claimInteractor.execute(row, col);
    }
}
