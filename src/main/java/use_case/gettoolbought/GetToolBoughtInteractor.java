package main.java.use_case.gettoolbought;

import main.java.entity.FarmSingleton;

import java.util.ArrayList;
import java.util.List;

public class GetToolBoughtInteractor implements GetToolBoughtInputBoundary {

    private GetToolBoughtOutputBoundary outputBoundary;

    public GetToolBoughtInteractor(GetToolBoughtOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    public List<Object> getToolBought(String tool) {
        if (tool.equalsIgnoreCase("sprinkler")) {
            boolean bought = FarmSingleton.getInstance().getFarm().getSprinklerPurchased();
            int level = FarmSingleton.getInstance().getFarm().getSprinklerLevel();
            outputBoundary.toolBought(tool, bought, level);
            List<Object> returnList = new ArrayList<>();
            returnList.add(bought);
            returnList.add(level);
            return returnList;
        }
        if (tool.equalsIgnoreCase("planter")) {
            boolean bought = FarmSingleton.getInstance().getFarm().getPlanterPurchased();
            int level = FarmSingleton.getInstance().getFarm().getPlanterLevel();
            outputBoundary.toolBought(tool, bought, level);
            List<Object> returnList = new ArrayList<>();
            returnList.add(bought);
            returnList.add(level);
            return returnList;
        }
        if (tool.equalsIgnoreCase("harvester")) {
            boolean bought = FarmSingleton.getInstance().getFarm().getHarvesterPurchased();
            int level = FarmSingleton.getInstance().getFarm().getHarvesterLevel();
            outputBoundary.toolBought(tool, bought, level);
            List<Object> returnList = new ArrayList<>();
            returnList.add(bought);
            returnList.add(level);
            return returnList;
        }
        if (tool.equalsIgnoreCase("tiller")) {
            boolean bought = FarmSingleton.getInstance().getFarm().getTillerPurchased();
            int level = FarmSingleton.getInstance().getFarm().getTillerLevel();
            outputBoundary.toolBought(tool, bought, level);
            List<Object> returnList = new ArrayList<>();
            returnList.add(bought);
            returnList.add(level);
            return returnList;
        }
        if (tool.equalsIgnoreCase("fertilizer")) {
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
