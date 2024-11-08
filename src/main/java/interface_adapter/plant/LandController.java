package main.java.interface_adapter.plant;

import main.java.use_case.plant.PlantInputBoundary;

public class LandController {
    private final PlantInputBoundary plantInteractor;

    public LandController(PlantInputBoundary plantInteractor) {
        this.plantInteractor = plantInteractor;
    }

    public void plantCrop(){
        plantInteractor.execute();

    }


}
