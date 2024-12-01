package main.java.use_case.selecttool;

import main.java.entity.FarmSingleton;

public class SelectToolInteractor implements SelectToolInputBoundary{

    private final SelectToolOutputBoundary outputBoundary;

    public SelectToolInteractor(SelectToolOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void selectTool(String tool) {
        if (tool.equalsIgnoreCase("sprinkler")) {
            // only select sprinkler if it is purchased
            if (FarmSingleton.getInstance().getFarm().getSprinklerPurchased()) {
                FarmSingleton.getInstance().getFarm().setActiveTool("sprinkler");
                outputBoundary.selectTool("sprinkler");
            }
        }

        if (tool.equalsIgnoreCase("harvester")) {
            // only select harvester if it is purchased
            if (FarmSingleton.getInstance().getFarm().getHarvesterPurchased()) {
                FarmSingleton.getInstance().getFarm().setActiveTool("harvester");
                outputBoundary.selectTool("harvester");
            }
        }
    }
}
