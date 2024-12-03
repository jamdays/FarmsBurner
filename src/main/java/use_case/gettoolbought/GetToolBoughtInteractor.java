package main.java.use_case.gettoolbought;

import java.util.ArrayList;
import java.util.List;

import main.java.entity.FarmSingleton;

/**
 * Get tool bought interactor.
 */
public class GetToolBoughtInteractor implements GetToolBoughtInputBoundary {

    private GetToolBoughtOutputBoundary outputBoundary;

    public GetToolBoughtInteractor(GetToolBoughtOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    /**
     * Get tool bought.
     * @param tool .
     * @return tool bought.
     */
    public List<Object> getToolBought(String tool) {
        if ("sprinkler".equalsIgnoreCase(tool)) {
            boolean bought = FarmSingleton.getInstance().getFarm().getSprinklerPurchased();
            int level = FarmSingleton.getInstance().getFarm().getSprinklerLevel();
            outputBoundary.toolBought(tool, bought, level);
            List<Object> returnList = new ArrayList<>();
            returnList.add(bought);
            returnList.add(level);
            return returnList;
        }
        if ("planter".equalsIgnoreCase(tool)) {
            boolean bought = FarmSingleton.getInstance().getFarm().getPlanterPurchased();
            int level = FarmSingleton.getInstance().getFarm().getPlanterLevel();
            outputBoundary.toolBought(tool, bought, level);
            List<Object> returnList = new ArrayList<>();
            returnList.add(bought);
            returnList.add(level);
            return returnList;
        }
        if ("harvester".equalsIgnoreCase(tool)) {
            boolean bought = FarmSingleton.getInstance().getFarm().getHarvesterPurchased();
            int level = FarmSingleton.getInstance().getFarm().getHarvesterLevel();
            outputBoundary.toolBought(tool, bought, level);
            List<Object> returnList = new ArrayList<>();
            returnList.add(bought);
            returnList.add(level);
            return returnList;
        }
        if ("tiller".equalsIgnoreCase(tool)) {
            boolean bought = FarmSingleton.getInstance().getFarm().getTillerPurchased();
            int level = FarmSingleton.getInstance().getFarm().getTillerLevel();
            outputBoundary.toolBought(tool, bought, level);
            List<Object> returnList = new ArrayList<>();
            returnList.add(bought);
            returnList.add(level);
            return returnList;
        }
        if ("fertilizer".equalsIgnoreCase(tool)) {
            boolean bought = FarmSingleton.getInstance().getFarm().getFertilizerPurchased();
            int level = FarmSingleton.getInstance().getFarm().getFertilizerLevel();
            outputBoundary.toolBought(tool, bought, level);
            List<Object> returnList = new ArrayList<>();
            returnList.add(bought);
            returnList.add(level);
            return returnList;
        }
        return new ArrayList<>();
    }
}
