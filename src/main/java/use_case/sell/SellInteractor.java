package use_case.sell;

import main.java.entity.Crop;
import main.java.entity.FarmSingleton;

public class SellInteractor implements SellInputBoundary {

    private final SellOutputBoundary outputBoundary;

    public SellInteractor(SellOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(int quantity) {
        FarmSingleton.getInstance().getFarm().sell(quantity);
        outputBoundary.sell(quantity);
    }
}
