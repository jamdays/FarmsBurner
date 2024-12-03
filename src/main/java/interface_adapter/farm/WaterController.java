package main.java.interface_adapter.farm;

import main.java.use_case.water.WaterInputBoundary;

/**
 * Water controller.
 */
public class WaterController {
    private final WaterInputBoundary waterInteractor;

    public WaterController(WaterInputBoundary waterInteractor) {
        this.waterInteractor = waterInteractor;
    }

    /**
     * Water crop.
     * @param row .
     * @param col .
     */
    public void waterCrop(int row, int col) {
        waterInteractor.execute(row, col);
    }

}
