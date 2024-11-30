package main.java.interface_adapter.farm;

import main.java.use_case.plant.PlantOutputBoundary;

public class PlantPresenter implements PlantOutputBoundary {
    private final FarmViewModel farmViewModel;

    public PlantPresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }

    @Override
    public void addCrop(int r, int c) {
        ((FarmState) (farmViewModel.getState())).plantCrop(r, c);
        farmViewModel.firePropertyChanged("plant");
    }
}
