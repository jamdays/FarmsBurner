package main.java.interface_adapter.farm;

import main.java.use_case.fertilize.FertilizeOutputBoundary;

public class FertilizePresenter implements FertilizeOutputBoundary{
    private final FarmViewModel farmViewModel;

    public FertilizePresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }

    @Override
    public void fertilize(int r, int c){
        ((FarmState) (farmViewModel.getState())).fertilize(r, c);
        farmViewModel.firePropertyChanged("fertilize");
    }
}
