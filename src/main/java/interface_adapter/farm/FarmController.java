package main.java.interface_adapter.farm;

import main.java.use_case.claim.ClaimInputBoundary;
import main.java.use_case.harvest.HarvestInputBoundary;
import main.java.use_case.plant.PlantInputBoundary;
import main.java.use_case.water.WaterInputBoundary;
import main.java.use_case.fertilize.FertilizeInputBoundary;


public class FarmController {
    private final PlantInputBoundary plantInteractor;
    private final WaterInputBoundary waterInteractor;
    private final ClaimInputBoundary claimInteractor;
    private final FertilizeInputBoundary fertilizeInteractor;
    private final HarvestInputBoundary harvestInteractor;

    public FarmController(PlantInputBoundary plantInteractor, WaterInputBoundary waterInteractor, ClaimInputBoundary claimInteractor, FertilizeInputBoundary fertilizeInteractor) {
        this.plantInteractor = plantInteractor;
        this.waterInteractor = waterInteractor;
        this.claimInteractor = claimInteractor;
        this.fertilizeInteractor = fertilizeInteractor;
        this.harvestInteractor = harvestInteractor;
    }

    public void plantCrop(int r, int c){
        plantInteractor.execute(r, c);
    }

    public void waterCrop(int r, int c){
        waterInteractor.execute(r, c);
    }

    public void claim(int r, int c) {
        claimInteractor.execute(r, c);
    }
  
    public void harvestCrop(int r, int c) {
        harvestInteractor.execute(r, c);
    }
    public void fertilize(int r, int c){
        claimInteractor.execute(r, c);
        System.out.println("plot fertilized");
    }

}
