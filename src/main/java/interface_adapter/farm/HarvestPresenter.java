package main.java.interface_adapter.farm;


import main.java.use_case.harvest.HarvestOutputBoundary;

public class HarvestPresenter implements HarvestOutputBoundary {
    private final FarmViewModel farmViewModel;

    public HarvestPresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }

    @Override
    public void harvestCrop(int r, int c) {
        ((FarmState) (farmViewModel.getState())).harvest(r, c);
        farmViewModel.firePropertyChanged("harvestCrop");
    }

}
