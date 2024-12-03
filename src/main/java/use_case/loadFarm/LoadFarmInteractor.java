package main.java.use_case.loadFarm;

import main.java.entity.FarmSingleton;
import main.java.entity.Land;

/**
 * Load farm interactor.
 */
public class LoadFarmInteractor implements LoadFarmInputBoundary {
    private final int wet = 0B1;
    private final int claimed = 0B10;
    private final int snowy = 0B100;
    private final int planted = 0B1000;
    private final int alive = 0B100000;
    private final int fertilized = 0B1000000;
    private final LoadFarmOutputBoundary loadFarmOutputBoundary;

    public LoadFarmInteractor(LoadFarmOutputBoundary outputBoundary) {
        this.loadFarmOutputBoundary = outputBoundary;
    }

    @Override
    public void load() {
        // Get the farm land
        Land[][] land = FarmSingleton.getInstance().getFarm().getFarmLand();

        // Create landInt so that we can pass it in the way FarmState needs it
        int[][] landInt = new int[land.length][land[0].length];

        // Iterate through landToCreate landInt
        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[0].length; c++) {

                // If Planted set landInt to alive by adding const for this
                if (land[r][c].isPlanted()) {
                    landInt[r][c] += planted;
                }

                // If Fertilized set landInt to alive by adding const for this
                if (land[r][c].isFertilized()) {
                    landInt[r][c] += fertilized;
                }

                // If Wet set landInt to alive by adding const for this
                if (land[r][c].isWet()) {
                    landInt[r][c] += wet;
                }

                // If claimed set landInt to alive by adding const for this
                if (land[r][c].isClaimed()) {
                    landInt[r][c] += claimed;
                }

                // If snowy set landInt to alive by adding const for this
                if (land[r][c].getIsSnowy()) {
                    landInt[r][c] += snowy;
                }
                // If alive set landInt to alive by adding const for this
                if (land[r][c].getCrop() != null && land[r][c].getCrop().getIsAlive()) {
                    landInt[r][c] += alive;
                }
            }
        }
        loadFarmOutputBoundary.load(landInt);
    }

}
