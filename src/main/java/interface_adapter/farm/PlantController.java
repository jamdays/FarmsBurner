package main.java.interface_adapter.farm;

import main.java.use_case.plant.PlantInputBoundary;

public class PlantController {
    private final PlantInputBoundary plantInteractor;

    public PlantController(PlantInputBoundary plantInteractor) {
        this.plantInteractor = plantInteractor;
    }


    public void plantCrop(int r, int c){
        plantInteractor.execute(r, c);
    }
}
