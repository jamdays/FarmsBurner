package main.java.use_case.usetool;

import main.java.data_access.OpenWeatherAccessInterface;
import main.java.entity.FarmSingleton;

public class UseToolInteractor implements UseToolInputBoundary {

    private final UseToolOutputBoundary outputBoundary;
    private final OpenWeatherAccessInterface openWeatherAccess;

    public UseToolInteractor(UseToolOutputBoundary outputBoundary, OpenWeatherAccessInterface openWeatherAccess) {
        this.outputBoundary = outputBoundary;
        this.openWeatherAccess = openWeatherAccess;
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
            outputBoundary.useTool(tool, rStart, cStart, FarmSingleton.getInstance().getFarm().getSprinklerLevel(), openWeatherAccess.getTimesForCity(FarmSingleton.getInstance().getFarm().getCity()).get(0));
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
            outputBoundary.useTool(tool, rStart, cStart, FarmSingleton.getInstance().getFarm().getHarvesterLevel(), openWeatherAccess.getTimesForCity(FarmSingleton.getInstance().getFarm().getCity()).get(0));
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
            outputBoundary.useTool(tool, rStart, cStart, FarmSingleton.getInstance().getFarm().getTillerLevel(), openWeatherAccess.getTimesForCity(FarmSingleton.getInstance().getFarm().getCity()).get(0));
        }
        // use fertilizer
        if (tool.equalsIgnoreCase("fertilizer")) {
            System.out.println("fertilize the land starting at row r and column c based on fertilizer level, given that the tiles are tilled");
            // implementation
            for (int i = 0; i < FarmSingleton.getInstance().getFarm().getFertilizerLevel(); i++) {
                for (int j = 0; j < FarmSingleton.getInstance().getFarm().getFertilizerLevel(); j++) {
                    // TODO: make it so that you don't fertilize tiles that are out of bounds
                    boolean alreadyFertilized = FarmSingleton.getInstance().getFarm().getFarmLand()[rStart + i][cStart + i].isFertilized();
                    if (!alreadyFertilized) {
                        FarmSingleton.getInstance().getFarm().fertilize(rStart + i, cStart + j);
                    }
                }
            }
            outputBoundary.useTool(tool, rStart, cStart, FarmSingleton.getInstance().getFarm().getFertilizerLevel(), openWeatherAccess.getTimesForCity(FarmSingleton.getInstance().getFarm().getCity()).get(0));
        }
        // use planter
        if (tool.equalsIgnoreCase("planter")) {
            System.out.println("plant the land starting at row r and column c based on fertilizer level, given that the tiles are tilled");
            // implementation
            for (int i = 0; i < FarmSingleton.getInstance().getFarm().getPlanterLevel(); i++) {
                for (int j = 0; j < FarmSingleton.getInstance().getFarm().getPlanterLevel(); j++) {
                    // TODO: make it so that you don't fertilize tiles that are out of bounds
                    try {
                        Long time = openWeatherAccess.getTimesForCity(FarmSingleton.getInstance().getFarm().getCity()).get(0);
                        FarmSingleton.getInstance().getFarm().plant(rStart + i, cStart + j, time);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                }
            }
            outputBoundary.useTool(tool, rStart, cStart, FarmSingleton.getInstance().getFarm().getPlanterLevel(), openWeatherAccess.getTimesForCity(FarmSingleton.getInstance().getFarm().getCity()).get(0));
    }
}
