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
        //TODO add other cases later
        if (tool.equalsIgnoreCase("sprinkler")){
            outputBoundary.upgrade("sprinkler");
            FarmSingleton.getInstance().getFarm().getSprinkler().upgrade();
        }
    }
}
