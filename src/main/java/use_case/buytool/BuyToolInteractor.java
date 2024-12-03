package main.java.use_case.buytool;

import main.java.entity.FarmSingleton;

/**
 * BuyToolInteractor.
 */
public class BuyToolInteractor implements BuyToolInputBoundary {
    private final BuyToolOutputBoundary outputBoundary;

    public BuyToolInteractor(BuyToolOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void buy(String tool) {
        if ("sprinkler".equalsIgnoreCase(tool)) {
            FarmSingleton.getInstance().getFarm().setSprinklerPurchased(true);
            outputBoundary.buy("sprinkler");
        }
        if ("harvester".equalsIgnoreCase(tool)) {
            FarmSingleton.getInstance().getFarm().setHarvesterPurchased(true);
            outputBoundary.buy("harvester");
        }
        if ("tiller".equalsIgnoreCase(tool)) {
            FarmSingleton.getInstance().getFarm().setTillerPurchased(true);
            outputBoundary.buy("tiller");

        }
        if ("fertilizer".equalsIgnoreCase(tool)) {
            FarmSingleton.getInstance().getFarm().setFertilizerPurchased(true);
            outputBoundary.buy("fertilizer");
        }
        if ("planter".equalsIgnoreCase(tool)) {
            FarmSingleton.getInstance().getFarm().setPlanterPurchased(true);
            outputBoundary.buy("planter");
        }
    }
}
