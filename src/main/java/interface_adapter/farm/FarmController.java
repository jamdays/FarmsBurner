package main.java.interface_adapter.farm;

import main.java.use_case.plant.PlantInputBoundary;
import main.java.use_case.plant.PlantOutputBoundary;
import main.java.use_case.water.WaterInputBoundary;

public class FarmController {
    private final PlantInputBoundary plantInteractor;
    private final WaterInputBoundary waterInteractor;

    public FarmController(PlantInputBoundary plantInteractor, WaterInputBoundary waterInteractor){
        this.plantInteractor = plantInteractor;
        this.waterInteractor = waterInteractor;
    }

    public void plantCrop(int r, int c){
        plantInteractor.execute(r, c);
    }

    public void waterCrop(int r, int c){
        waterInteractor.execute(r, c);
    }


}
