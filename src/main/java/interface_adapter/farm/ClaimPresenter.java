package main.java.interface_adapter.farm;

import main.java.use_case.claim.ClaimOutputBoundary;

/**
 * Claim presenter.
 */
public class ClaimPresenter implements ClaimOutputBoundary {
    private final FarmViewModel farmViewModel;

    public ClaimPresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }

    @Override
    public void claim(int row, int col) {
        ((FarmState) (farmViewModel.getState())).claim(row, col);
        farmViewModel.firePropertyChanged("claim");
    }

}
