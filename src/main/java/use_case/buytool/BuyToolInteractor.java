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
            outputBoundary.buy("sprinkler");
            FarmSingleton.getInstance().getFarm().setSprinklerPurchased(true);

        }
        if ("harvester".equalsIgnoreCase(tool)) {
            outputBoundary.buy("harvester");
            FarmSingleton.getInstance().getFarm().setHarvesterPurchased(true);
        }
        if ("tiller".equalsIgnoreCase(tool)) {
            outputBoundary.buy("tiller");
            FarmSingleton.getInstance().getFarm().setTillerPurchased(true);

        }
        if ("fertilizer".equalsIgnoreCase(tool)) {
            outputBoundary.buy("fertilizer");
            FarmSingleton.getInstance().getFarm().setFertilizerPurchased(true);
        }
        if ("planter".equalsIgnoreCase(tool)) {
            outputBoundary.buy("planter");
            FarmSingleton.getInstance().getFarm().setPlanterPurchased(true);
        }
    }
}
