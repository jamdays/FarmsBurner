package main.java.use_case.upgradetool;

import main.java.entity.FarmSingleton;
import main.java.entity.FarmTool;

public class UpgradeToolInteractor implements UpgradeToolInputBoundary{
    UpgradeToolOutputBoundary outputBoundary;
    public UpgradeToolInteractor(UpgradeToolOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void upgrade(String tool) {
        if (tool.equalsIgnoreCase("sprinkler")){
            outputBoundary.upgrade("sprinkler");
            int currSprinklerLevel = FarmSingleton.getInstance().getFarm().getSprinklerLevel();
            if (currSprinklerLevel < 5) {
                FarmSingleton.getInstance().getFarm().setSprinklerLevel(currSprinklerLevel + 1);
            }
        }
        if (tool.equalsIgnoreCase("planter")){
            outputBoundary.upgrade("planter");
            int currPlanterLevel = FarmSingleton.getInstance().getFarm().getPlanterLevel();
            if (currPlanterLevel < 5) {
                FarmSingleton.getInstance().getFarm().setPlanterLevel(currPlanterLevel + 1);
            }

        }
        if (tool.equalsIgnoreCase("harvester")){
            outputBoundary.upgrade("harvester");
            int currHarvesterLevel = FarmSingleton.getInstance().getFarm().getHarvesterLevel();
            if (currHarvesterLevel < 5) {
                FarmSingleton.getInstance().getFarm().setHarvesterLevel(currHarvesterLevel + 1);
            }

        }
        if (tool.equalsIgnoreCase("tiller")){
            outputBoundary.upgrade("tiller");
            int currTillerLevel = FarmSingleton.getInstance().getFarm().getTillerLevel();
            if (currTillerLevel < 5) {
                FarmSingleton.getInstance().getFarm().setTillerLevel(currTillerLevel + 1);
            }
        }
        if (tool.equalsIgnoreCase("fertilizer")){
            outputBoundary.upgrade("fertilizer");
            int currFertilizerLevel = FarmSingleton.getInstance().getFarm().getFertilizerLevel();
            if (currFertilizerLevel < 5) {
                FarmSingleton.getInstance().getFarm().setFertilizerLevel(currFertilizerLevel + 1);
            }
        }
    }
}
