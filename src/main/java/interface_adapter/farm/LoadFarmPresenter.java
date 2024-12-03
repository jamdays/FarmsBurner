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
    public void load(int[][] land, long[][] times, int[][] ages, int[][] prices, int barnBucks, int power, long time) {
        ((FarmState) (farmViewModel.getState())).setLand(land);
        ((FarmState) (farmViewModel.getState())).setCropTimes(times);
        ((FarmState) (farmViewModel.getState())).setPrices(prices);
        ((FarmState) (farmViewModel.getState())).setCropAges(ages);
        ((FarmState) (farmViewModel.getState())).setBarnBucks(barnBucks);
        ((FarmState) (farmViewModel.getState())).setPower(power);
        ((FarmState)(farmViewModel.getState())).refreshPower(time);
        farmViewModel.firePropertyChanged("load farm");
    }

}
