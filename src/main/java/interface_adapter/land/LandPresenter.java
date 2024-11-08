package main.java.interface_adapter.land;

import main.java.use_case.plant.PlantOutputBoundary;

public class LandPresenter implements PlantOutputBoundary {
    private final LandViewModel landViewModel;

    public LandPresenter(LandViewModel landViewModel) {
        this.landViewModel = landViewModel;
    }
    @Override
    public void addCrop() {
        ((LandState) (landViewModel.getState())).plantCrop();
    }
}
