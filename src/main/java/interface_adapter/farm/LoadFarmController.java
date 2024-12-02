package main.java.interface_adapter.farm;

import main.java.use_case.harvest.HarvestInputBoundary;
import main.java.use_case.loadFarm.LoadFarmInputBoundary;

public class LoadFarmController {
    private LoadFarmInputBoundary loadFarmInteractor;

    public LoadFarmController(LoadFarmInputBoundary loadFarmInteractor) {
        this.loadFarmInteractor = loadFarmInteractor;
    }

    public void load(){
        loadFarmInteractor.load();
    }

}
