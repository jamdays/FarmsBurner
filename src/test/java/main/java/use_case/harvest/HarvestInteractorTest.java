package main.java.use_case.harvest;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;

public class HarvestInteractorTest extends TestCase {

    final int r = 0;
    final int c = 0;

    public void testHarvestSuccess() {
        // Create a farm and plant a crop.
        Farm farm = new Farm();
        farm.plant(r, c);
        FarmSingleton.setInstance(farm);

        HarvestOutputBoundary outputBoundary = new HarvestOutputBoundary() {

            @Override
            public void harvestCrop(int r, int c) {
                // Assert if the crop is harvested.
                assertFalse(farm.getFarmLand()[r][c].isPlanted());
            }
        };

        HarvestInteractor interactor = new HarvestInteractor(outputBoundary);
        interactor.execute(r, c);
    }
}