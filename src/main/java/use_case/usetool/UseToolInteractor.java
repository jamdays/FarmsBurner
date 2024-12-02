package main.java.use_case.usetool;

import main.java.entity.FarmSingleton;

public class UseToolInteractor implements UseToolInputBoundary {

    private final UseToolOutputBoundary outputBoundary;

    public UseToolInteractor(UseToolOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    public void useTool(String tool, int rStart, int cStart) {
        // use sprinkler
        if (tool.equalsIgnoreCase("sprinkler")) {
            System.out.println("water the crops starting at row r and column c based on sprinkler level, given that the tiles are tilled");
            // implementation
            for (int i = 0; i < FarmSingleton.getInstance().getFarm().getSprinklerLevel(); i++) {
                for (int j = 0; j < FarmSingleton.getInstance().getFarm().getSprinklerLevel(); j++) {
                    // TODO: make it so that you don't water tiles that are out of bounds
                    FarmSingleton.getInstance().getFarm().water(rStart + i, cStart + j);
                }
            }
            outputBoundary.useTool(tool, rStart, cStart, FarmSingleton.getInstance().getFarm().getSprinklerLevel());
        }
        // use harvester
        if (tool.equalsIgnoreCase("harvester")) {
            System.out.println("harvest the crops starting at row r and column c based on harvester level, given that the tiles have ready crops");
            // implementation
            for (int i = 0; i < FarmSingleton.getInstance().getFarm().getHarvesterLevel(); i++) {
                for (int j = 0; j < FarmSingleton.getInstance().getFarm().getHarvesterLevel(); j++) {
                    // TODO: make it so that you don't harvest tiles that are out of bounds
                    FarmSingleton.getInstance().getFarm().harvest(rStart + i, cStart + j);
                }
            }
            outputBoundary.useTool(tool, rStart, cStart, FarmSingleton.getInstance().getFarm().getHarvesterLevel());
        }
        // use tiller
        if (tool.equalsIgnoreCase("tiller")) {
            System.out.println("till the land starting at row r and column c based on tiller level");
            // implementation
            for (int i = 0; i < FarmSingleton.getInstance().getFarm().getTillerLevel(); i++) {
                for (int j = 0; j < FarmSingleton.getInstance().getFarm().getTillerLevel(); j++) {
                    // TODO: make it so you don't till tiles that are out of bounds
                    FarmSingleton.getInstance().getFarm().claim(rStart + i, cStart + j);
                }
            }
            outputBoundary.useTool(tool, rStart, cStart, FarmSingleton.getInstance().getFarm().getTillerLevel());
        }
        // use fertilizer
        if (tool.equalsIgnoreCase("fertilizer")) {
            System.out.println("fertilize the land starting at row r and column c based on fertilizer level, given that the tiles are tilled");
            // implementation
            for (int i = 0; i < FarmSingleton.getInstance().getFarm().getFertilizerLevel(); i++) {
                for (int j = 0; j < FarmSingleton.getInstance().getFarm().getFertilizerLevel(); j++) {
                    // TODO: make it so that you don't fertilize tiles that are out of bounds
                    FarmSingleton.getInstance().getFarm().fertilize(rStart + i, cStart + j);
                }
            }
            outputBoundary.useTool(tool, rStart, cStart, FarmSingleton.getInstance().getFarm().getFertilizerLevel());
        }
        // use planter
        if (tool.equalsIgnoreCase("planter")) {
            System.out.println("plant the land starting at row r and column c based on fertilizer level, given that the tiles are tilled");
            // implementation
            for (int i = 0; i < FarmSingleton.getInstance().getFarm().getPlanterLevel(); i++) {
                for (int j = 0; j < FarmSingleton.getInstance().getFarm().getPlanterLevel(); j++) {
                    // TODO: make it so that you don't fertilize tiles that are out of bounds
                    try {
                        FarmSingleton.getInstance().getFarm().plant(rStart + i, cStart + j);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                }
            }
            outputBoundary.useTool(tool, rStart, cStart, FarmSingleton.getInstance().getFarm().getPlanterLevel());
    }
}
