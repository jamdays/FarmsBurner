package main.java.interface_adapter.farm;

import main.java.use_case.claim.ClaimInputBoundary;

public class ClaimController {
    private final ClaimInputBoundary claimInteractor;

    public ClaimController(ClaimInputBoundary claimInteractor) {
        this.claimInteractor = claimInteractor;
    }


    public void claim(int r, int c) {
        claimInteractor.execute(r, c);
    }
}
