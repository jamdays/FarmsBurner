package main.java.interface_adapter.farm;

import main.java.use_case.claim.ClaimOutputBoundary;
import main.java.use_case.harvest.HarvestOutputBoundary;
import main.java.use_case.plant.PlantOutputBoundary;
import main.java.use_case.water.WaterOutputBoundary;
import main.java.use_case.fertilize.FertilizeOutputBoundary;

public class FarmPresenter implements PlantOutputBoundary, WaterOutputBoundary, ClaimOutputBoundary, FertilizeOutputBoundary, HarvestOutputBoundary {
    private final FarmViewModel farmViewModel;

    public FarmPresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }
    @Override
    public void addCrop(int r, int c) {
        ((FarmState) (farmViewModel.getState())).plantCrop(r, c);
        farmViewModel.firePropertyChanged("plant");
    }

    @Override
    public void water(int r, int c){
        ((FarmState) (farmViewModel.getState())).water(r, c);
        farmViewModel.firePropertyChanged("water");
    }

    @Override
    public void claim(int r, int c){
        ((FarmState) (farmViewModel.getState())).claim(r, c);
        farmViewModel.firePropertyChanged("claim");
    }

    public void harvestCrop(int r, int c) {
        ((FarmState) (farmViewModel.getState())).harvest(r, c);
        farmViewModel.firePropertyChanged("harvestCrop");
    }
      
    @Override
    public void fertilize(int r, int c){
        ((FarmState) (farmViewModel.getState())).fertilize(r, c);
        farmViewModel.firePropertyChanged("fertilize");
    }
}
