package main.java.interface_adapter.farm;

import main.java.use_case.loadFarm.LoadFarmOutputBoundary;

/**
 * Load farm presenter.
 */
public class LoadFarmPresenter implements LoadFarmOutputBoundary {
    private final FarmViewModel farmViewModel;

    public LoadFarmPresenter(FarmViewModel farmViewModel) {
        this.farmViewModel = farmViewModel;
    }

    @Override
    public void load(int[][] land) {
        ((FarmState) (farmViewModel.getState())).setLand(land);
        farmViewModel.firePropertyChanged("land");
    }

}
