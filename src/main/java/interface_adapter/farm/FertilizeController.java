package main.java.interface_adapter.farm;

import main.java.use_case.fertilize.FertilizeInputBoundary;

/**
 * Fertilize Controller.
 */
public class FertilizeController {
    private final FertilizeInputBoundary fertilizeInteractor;

    public FertilizeController(FertilizeInputBoundary fertilizeInteractor) {
        this.fertilizeInteractor = fertilizeInteractor;
    }

    /**
     * Fertilize.
     * @param row .
     * @param col .
     */
    public void fertilize(int row, int col) {
        fertilizeInteractor.execute(row, col);
    }
}
