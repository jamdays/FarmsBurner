package main.java.use_case.water;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.harvest.HarvestInteractor;
import main.java.use_case.harvest.HarvestOutputBoundary;

public class WaterInteractorTest extends TestCase {
    final int r = 0;
    final int c = 0;

    public void testWaterSuccess() {
        // Create a farm and plant a crop.
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.plant(r, c);
        farm.water(r, c);

        WaterOutputBoundary outputBoundary = new WaterOutputBoundary() {

            @Override
            public void water(int r, int c) {
                // Assert if the crop is harvested.
                assertTrue(farm.getFarmLand()[r][c].getIsWet());
            }
        };

        WaterInteractor interactor = new WaterInteractor(outputBoundary);
        interactor.execute(r, c);
    }

    public void testWaterSuccessMultiple() {
        // Create a farm and plant a crop.
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.claim(r + 1, c + 1);
        farm.claim(r, c + 1);
        farm.claim(r + 1, c);
        farm.plant(r, c);
        farm.plant(r + 1, c + 1);
        farm.plant(r, c + 1);
        farm.plant(r + 1, c);
        farm.water(r, c);
        farm.water(r + 1, c + 1);
        farm.water(r, c + 1);
        farm.water(r + 1, c);

        WaterOutputBoundary outputBoundary = new WaterOutputBoundary() {

            @Override
            public void water(int r, int c) {
                // Assert if the crop is harvested.
                assertTrue(farm.getFarmLand()[r][c].getIsWet());
                assertTrue(farm.getFarmLand()[1][1].getIsWet());
                assertTrue(farm.getFarmLand()[0][1].getIsWet());
                assertTrue(farm.getFarmLand()[1][0].getIsWet());
            }
        };

        WaterInteractor interactor = new WaterInteractor(outputBoundary);
        interactor.execute(0, 0);
        interactor.execute(1, 1);
        interactor.execute(0,  1);
        interactor.execute(1, 0);
    }

    public void testLandNotClaimed() {
        // Create a farm and plant a crop.
        Farm farm = new Farm();
        farm.water(r, c);

        WaterOutputBoundary outputBoundary = new WaterOutputBoundary() {

            @Override
            public void water(int r, int c) {
                // Assert that land is not wet (cannot water unclaimed land)
                assertFalse(farm.getFarmLand()[r][c].getIsWet());
            }
        };

        WaterInteractor interactor = new WaterInteractor(outputBoundary);
        interactor.execute(r, c);
    }

    public void testSnowy() {
        // Create a farm and plant a crop.
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.plant(r, c);
        farm.getFarmLand()[r][c].setIsSnowy(true);
        farm.water(r, c);

        WaterOutputBoundary outputBoundary = new WaterOutputBoundary() {

            @Override
            public void water(int r, int c) {
                // Assert that land is not wet (cannot water when snowy)
                assertFalse(farm.getFarmLand()[r][c].getIsWet());
            }
        };

        WaterInteractor interactor = new WaterInteractor(outputBoundary);
        interactor.execute(r, c);
    }

    public void testNoCrop() {
        // Create a farm and plant a crop.
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.water(r, c);

        WaterOutputBoundary outputBoundary = new WaterOutputBoundary() {

            @Override
            public void water(int r, int c) {
                // Assert that land is not wet (cannot water without crop)
                assertFalse(farm.getFarmLand()[r][c].getIsWet());
            }
        };

        WaterInteractor interactor = new WaterInteractor(outputBoundary);
        interactor.execute(r, c);
    }

}