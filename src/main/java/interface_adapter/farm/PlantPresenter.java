package main.java.interface_adapter.farm;

import main.java.use_case.plant.PlantOutputBoundary;

/**
 * Plant presenter.
 */
public class PlantPresenter implements PlantOutputBoundary {
    private final FarmViewModel farmViewModel;

    public PlantPresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }

    @Override
    public void addCrop(int row, int col, long time) {
        ((FarmState) (farmViewModel.getState())).plantCrop(row, col, time);
        farmViewModel.firePropertyChanged("plant");
    }
}
