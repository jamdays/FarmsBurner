package main.java.interface_adapter.farm;

import main.java.use_case.fertilize.FertilizeOutputBoundary;

/**
 * Fertilize presenter.
 */
public class FertilizePresenter implements FertilizeOutputBoundary {
    private final FarmViewModel farmViewModel;

    public FertilizePresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }

    @Override
    public void fertilize(int row, int col) {
        ((FarmState) (farmViewModel.getState())).fertilize(row, col);
        farmViewModel.firePropertyChanged("fertilize");
    }
}
