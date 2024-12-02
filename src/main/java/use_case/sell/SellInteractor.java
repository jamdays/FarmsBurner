package main.java.use_case.sell;

import main.java.entity.Crop;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.entity.Storage;

import java.util.ArrayList;


public class SellInteractor implements SellInputBoundary {

    private final SellOutputBoundary outputBoundary;

    public SellInteractor(SellOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(int quantity) {
        Farm farm = FarmSingleton.getInstance().getFarm();
        farm.sell(quantity);
        outputBoundary.sell(quantity);
    }

}
