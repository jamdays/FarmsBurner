package main.java.use_case.loadFarm;

import main.java.entity.Farm;
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
    private final int ready = 0B10000000;
    private final int crop_mask = 0B1100000000;
    private final int rice = 0B0100000000;
    private final int snowberry = 0B0000000000;
    private final int corn = 0B1100000000;
    private final int wheat = 0B1000000000;
    // 0 is night, 1 is day, 2 is sunrise/sunset
    private final LoadFarmOutputBoundary loadFarmOutputBoundary;

    public LoadFarmInteractor(LoadFarmOutputBoundary outputBoundary) {
        this.loadFarmOutputBoundary = outputBoundary;
    }

    @Override
    public void load() {
        // Get the farm land
        Land[][] land = FarmSingleton.getInstance().getFarm().getFarmLand();
        Farm farm = FarmSingleton.getInstance().getFarm();

        // Create landInt so that we can pass it in the way FarmState needs it
        int[][] landInt = new int[land.length][land[0].length];
        long[][] cropTimes = new long[land.length][land[0].length];
        int[][] cropAges = new int[land.length][land[0].length];
        int[][] prices = new int[land.length][land[0].length];
        int barnBucks = farm.getBarnBucks();
        int power = farm.getPower();
        long powerRefresh = farm.getPowerRefresh();

        // Iterate through landToCreate landInt
        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[0].length; c++) {

                //If Planted set landInt to alive by adding const for this
                if (land[r][c].isPlanted()){
                    landInt[r][c] += planted;
                    prices[r][c] = land[r][c].getCrop().getPrice();
                    cropTimes[r][c] = land[r][c].getCrop().getTime();
                    cropAges[r][c] = land[r][c].getCrop().getAge();
                    if ("Snowberry".equalsIgnoreCase(land[r][c].getCrop().getName())){
                        landInt[r][c] += snowberry;
                    }
                    else if ("Wheat".equalsIgnoreCase(land[r][c].getCrop().getName())){
                        landInt[r][c] += wheat;
                    }
                    else if ("Rice".equalsIgnoreCase(land[r][c].getCrop().getName())){
                        landInt[r][c] += rice;
                    }
                    else if ("Corn".equalsIgnoreCase(land[r][c].getCrop().getName())){
                        landInt[r][c] += corn;
                    }
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

                if (land[r][c].getCrop() != null && land[r][c].getCrop().getReadyToHarvest()){
                    landInt[r][c] += ready;
                }
            }
        }
        loadFarmOutputBoundary.load(landInt, cropTimes, cropAges, prices, barnBucks, power, powerRefresh);
    }

}
