package main.java.interface_adapter.farm;

import main.java.use_case.water.WaterOutputBoundary;

/**
 * Water presenter.
 */
public class WaterPresenter implements WaterOutputBoundary {
    private final FarmViewModel farmViewModel;

    public WaterPresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }

    @Override
    public void water(int row, int col) {
        ((FarmState) (farmViewModel.getState())).water(row, col);
        farmViewModel.firePropertyChanged("water");
    }

}
