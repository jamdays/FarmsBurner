package main.java.interface_adapter.farm;

import main.java.use_case.plant.PlantInputBoundary;

public class FarmController {
    private final PlantInputBoundary plantInteractor;

    public FarmController(PlantInputBoundary plantInteractor) {
        this.plantInteractor = plantInteractor;
    }

    public void plantCrop(){
        plantInteractor.execute();

    }


}
