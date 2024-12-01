package main.java.use_case.buytool;

import main.java.entity.FarmSingleton;
import main.java.use_case.buytool.BuyToolOutputBoundary;
import main.java.entity.Sprinkler;

public class BuyToolInteractor implements BuyToolInputBoundary {
    BuyToolOutputBoundary outputBoundary;
    public BuyToolInteractor(BuyToolOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void buy(String tool) {
        //TODO add other cases later
        if (tool.equalsIgnoreCase("sprinkler")){
            outputBoundary.buy("sprinkler");
            FarmSingleton.getInstance().getFarm().setSprinklerPurchased(true);
        }
        if (tool.equalsIgnoreCase("harvester")){
            outputBoundary.buy("harvester");
            FarmSingleton.getInstance().getFarm().setHarvesterPurchased(true);
        }
    }
}
