package main.java.interface_adapter.farm;

import main.java.use_case.fertilize.FertilizeInputBoundary;

public class FertilizeController {
    private final FertilizeInputBoundary fertilizeInteractor;

    public FertilizeController(FertilizeInputBoundary fertilizeInteractor) {
        this.fertilizeInteractor = fertilizeInteractor;
    }

    public void fertilize(int r, int c){
        fertilizeInteractor.execute(r, c);
    }
}
