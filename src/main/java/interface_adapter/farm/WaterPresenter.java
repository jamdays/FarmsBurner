package main.java.interface_adapter.farm;

import main.java.use_case.water.WaterOutputBoundary;

public class WaterPresenter implements WaterOutputBoundary{
    private final FarmViewModel farmViewModel;

    public WaterPresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }

    @Override
    public void water(int r, int c){
        ((FarmState) (farmViewModel.getState())).water(r, c);
        farmViewModel.firePropertyChanged("water");
    }

}
