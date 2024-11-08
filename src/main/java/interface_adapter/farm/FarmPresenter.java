package main.java.interface_adapter.farm;

import main.java.use_case.plant.PlantOutputBoundary;
import main.java.use_case.water.WaterOutputBoundary;

public class FarmPresenter implements PlantOutputBoundary, WaterOutputBoundary {
    private final FarmViewModel farmViewModel;

    public FarmPresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }
    @Override
    public void addCrop() {
        ((FarmState) (farmViewModel.getState())).plantCrop();
    }

    @Override
    public void water(){
        ((FarmState) (farmViewModel.getState())).water();
    }
}
