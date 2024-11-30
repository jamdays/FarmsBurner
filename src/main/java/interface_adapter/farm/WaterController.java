package main.java.interface_adapter.farm;

import main.java.use_case.water.WaterInputBoundary;

public class WaterController {
    private final WaterInputBoundary waterInteractor;

    public WaterController(WaterInputBoundary waterInteractor) {
        this.waterInteractor = waterInteractor;
    }


    public void waterCrop(int r, int c){
        waterInteractor.execute(r, c);
    }

}
