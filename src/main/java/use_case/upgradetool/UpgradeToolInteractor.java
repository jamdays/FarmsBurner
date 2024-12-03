package main.java.use_case.upgradetool;

import main.java.entity.FarmSingleton;

/**
 * Upgrade tool interactor.
 */
public class UpgradeToolInteractor implements UpgradeToolInputBoundary {
    private UpgradeToolOutputBoundary outputBoundary;

    public UpgradeToolInteractor(UpgradeToolOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void upgrade(String tool) {
        if ("sprinkler".equalsIgnoreCase(tool)) {
            outputBoundary.upgrade("sprinkler");
            int currSprinklerLevel = FarmSingleton.getInstance().getFarm().getSprinklerLevel();
            if (currSprinklerLevel < 5) {
                FarmSingleton.getInstance().getFarm().setSprinklerLevel(currSprinklerLevel + 1);
            }
        }
        if ("planter".equalsIgnoreCase(tool)) {
            outputBoundary.upgrade("planter");
            int currPlanterLevel = FarmSingleton.getInstance().getFarm().getPlanterLevel();
            if (currPlanterLevel < 5) {
                FarmSingleton.getInstance().getFarm().setPlanterLevel(currPlanterLevel + 1);
            }

        }
        if ("harvester".equalsIgnoreCase(tool)) {
            outputBoundary.upgrade("harvester");
            int currHarvesterLevel = FarmSingleton.getInstance().getFarm().getHarvesterLevel();
            if (currHarvesterLevel < 5) {
                FarmSingleton.getInstance().getFarm().setHarvesterLevel(currHarvesterLevel + 1);
            }

        }
        if ("tiller".equalsIgnoreCase(tool)) {
            outputBoundary.upgrade("tiller");
            int currTillerLevel = FarmSingleton.getInstance().getFarm().getTillerLevel();
            if (currTillerLevel < 5) {
                FarmSingleton.getInstance().getFarm().setTillerLevel(currTillerLevel + 1);
            }
        }
        if ("fertilizer".equalsIgnoreCase(tool)) {
            outputBoundary.upgrade("fertilizer");
            int currFertilizerLevel = FarmSingleton.getInstance().getFarm().getFertilizerLevel();
            if (currFertilizerLevel < 5) {
                FarmSingleton.getInstance().getFarm().setFertilizerLevel(currFertilizerLevel + 1);
            }
        }
    }
}
