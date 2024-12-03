package main.java.interface_adapter.farm;

import main.java.use_case.loadFarm.LoadFarmInputBoundary;

/**
 * Load farm controller.
 */
public class LoadFarmController {
    private LoadFarmInputBoundary loadFarmInteractor;

    public LoadFarmController(LoadFarmInputBoundary loadFarmInteractor) {
        this.loadFarmInteractor = loadFarmInteractor;
    }

    /**
     * Load.
     */
    public void load() {
        loadFarmInteractor.load();
    }

}
