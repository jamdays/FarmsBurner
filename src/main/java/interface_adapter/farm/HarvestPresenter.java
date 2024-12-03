package main.java.interface_adapter.farm;

import main.java.use_case.harvest.HarvestOutputBoundary;

/**
 * Harvest presenter.
 */
public class HarvestPresenter implements HarvestOutputBoundary {
    private final FarmViewModel farmViewModel;

    public HarvestPresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }

    @Override
    public void harvestCrop(int row, int col) {
        ((FarmState) (farmViewModel.getState())).harvest(row, col);
        farmViewModel.firePropertyChanged("harvestCrop");
    }

}
