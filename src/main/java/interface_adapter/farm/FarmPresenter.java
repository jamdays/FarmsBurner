package main.java.interface_adapter.farm;

import main.java.use_case.plant.PlantOutputBoundary;
import main.java.use_case.water.WaterOutputBoundary;

public class FarmPresenter implements PlantOutputBoundary, WaterOutputBoundary {
    private final FarmViewModel farmViewModel;

    public FarmPresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }
    @Override
    public void addCrop(int r, int c) {
        ((FarmState) (farmViewModel.getState())).plantCrop(r, c);
    }

    @Override
    public void water(int r, int c){
        ((FarmState) (farmViewModel.getState())).water(r, c);
    }
}
