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
        if (tool.equalsIgnoreCase("sprinkler")){
            outputBoundary.buy("sprinkler");
            FarmSingleton.getInstance().getFarm().setSprinklerPurchased(true);
            int currSprinklerLevel = FarmSingleton.getInstance().getFarm().getSprinklerLevel();
            if (currSprinklerLevel < 5) {
                FarmSingleton.getInstance().getFarm().setSprinklerLevel(currSprinklerLevel + 1);
            }
        }
        if (tool.equalsIgnoreCase("harvester")){
            outputBoundary.buy("harvester");
            FarmSingleton.getInstance().getFarm().setHarvesterPurchased(true);
            int currHarvesterLevel = FarmSingleton.getInstance().getFarm().getHarvesterLevel();
            if (currHarvesterLevel < 5) {
                FarmSingleton.getInstance().getFarm().setSprinklerLevel(currHarvesterLevel + 1);
            }
        }
        if (tool.equalsIgnoreCase("tiller")){
            outputBoundary.buy("tiller");
            FarmSingleton.getInstance().getFarm().setTillerPurchased(true);
            int currTillerLevel = FarmSingleton.getInstance().getFarm().getSprinklerLevel();
            if (currTillerLevel < 5) {
                FarmSingleton.getInstance().getFarm().setSprinklerLevel(currTillerLevel + 1);
            }
        }
        if (tool.equalsIgnoreCase("fertilizer")){
            outputBoundary.buy("fertilizer");
            FarmSingleton.getInstance().getFarm().setFertilizerPurchased(true);
            int currFertilizerLevel = FarmSingleton.getInstance().getFarm().getSprinklerLevel();
            if (currFertilizerLevel < 5) {
                FarmSingleton.getInstance().getFarm().setSprinklerLevel(currFertilizerLevel + 1);
            }
        }
        if (tool.equalsIgnoreCase("planter")){
            outputBoundary.buy("planter");
            FarmSingleton.getInstance().getFarm().setPlanterPurchased(true);
        }
    }
}
