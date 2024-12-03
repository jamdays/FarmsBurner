package main.java.use_case.selecttool;

import main.java.entity.FarmSingleton;

/**
 * Select tool interactor.
 */
public class SelectToolInteractor implements SelectToolInputBoundary {
    private final SelectToolOutputBoundary outputBoundary;

    public SelectToolInteractor(SelectToolOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void selectTool(String tool) {
        if ("sprinkler".equalsIgnoreCase(tool)) {
            // only select sprinkler if it is purchased
            if (FarmSingleton.getInstance().getFarm().getSprinklerPurchased()) {
                FarmSingleton.getInstance().getFarm().setActiveTool("sprinkler");
                outputBoundary.selectTool("Sprinkler");
            }
        }

        if ("harvester".equalsIgnoreCase(tool)) {
            // only select harvester if it is purchased
            if (FarmSingleton.getInstance().getFarm().getHarvesterPurchased()) {
                FarmSingleton.getInstance().getFarm().setActiveTool("harvester");
                outputBoundary.selectTool("Harvester");
            }
        }

        if ("tiller".equalsIgnoreCase(tool)) {
            // only select tiller if it is purchased
            if (FarmSingleton.getInstance().getFarm().getTillerPurchased()) {
                FarmSingleton.getInstance().getFarm().setActiveTool("tiller");
                outputBoundary.selectTool("Tiller");
            }
        }

        if ("fertilizer".equalsIgnoreCase(tool)) {
            // only select tiller if it is purchased
            if (FarmSingleton.getInstance().getFarm().getFertilizerPurchased()) {
                FarmSingleton.getInstance().getFarm().setActiveTool("fertilizer");
                outputBoundary.selectTool("Fertilizer");
            }
        }

        if ("planter".equalsIgnoreCase(tool)) {
            // only select tiller if it is purchased
            if (FarmSingleton.getInstance().getFarm().getPlanterPurchased()) {
                FarmSingleton.getInstance().getFarm().setActiveTool("planter");
                outputBoundary.selectTool("Planter");
            }
        }
    }
}
