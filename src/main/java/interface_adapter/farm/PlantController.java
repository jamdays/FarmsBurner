package main.java.interface_adapter.farm;

import main.java.use_case.plant.PlantInputBoundary;

/**
 * Plant controller.
 */
public class PlantController {
    private final PlantInputBoundary plantInteractor;

    public PlantController(PlantInputBoundary plantInteractor) {
        this.plantInteractor = plantInteractor;
    }

    /**
     * Plant crop.
     * @param row .
     * @param col .
     */
    public void plantCrop(int row, int col) {
        plantInteractor.execute(row, col);
    }
}
