package main.java.use_case.harvest;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.Land;
import main.java.entity.FarmSingleton;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class HarvestInteractorTest extends TestCase {

    final int r = 0;
    final int c = 0;

    public void testHarvestSuccess() {
        // Create a farm and plant a crop.
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.plant(r, c);
        farm.getFarmLand()[r][c].getCrop().setAge(5);
        farm.harvest(r, c);
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

    public void testHarvestSuccessMultiple() {
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
        farm.getFarmLand()[r][c].getCrop().setAge(5);
        farm.getFarmLand()[r + 1][c + 1].getCrop().setAge(5);
        farm.getFarmLand()[r][c + 1].getCrop().setAge(5);
        farm.getFarmLand()[r + 1][c].getCrop().setAge(5);
        farm.harvest(r, c);
        farm.harvest(r + 1, c + 1);
        farm.harvest(r, c + 1);
        farm.harvest(r + 1, c);

        HarvestOutputBoundary outputBoundary = new HarvestOutputBoundary() {

            @Override
            public void harvestCrop(int r, int c) {
                // Assert if the crop is harvested.
                assertFalse(farm.getFarmLand()[r][c].isPlanted());
                assertFalse(farm.getFarmLand()[1][1].isPlanted());
                assertFalse(farm.getFarmLand()[0][1].isPlanted());
                assertFalse(farm.getFarmLand()[1][0].isPlanted());
            }
        };

        HarvestInteractor interactor = new HarvestInteractor(outputBoundary);
        interactor.execute(0, 0);
        interactor.execute(1, 1);
        interactor.execute(0,  1);
        interactor.execute(1, 0);
    }

    public void testFailTooYoung() {
        // Create a farm and plant a crop.
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.plant(r, c);
        FarmSingleton.setInstance(farm);
        farm.harvest(r, c);

        HarvestOutputBoundary outputBoundary = new HarvestOutputBoundary() {

            @Override
            public void harvestCrop(int r, int c) {
                // Assert if the crop is not harvested.
                assertTrue(farm.getFarmLand()[r][c].isPlanted());
            }
        };

        HarvestInteractor interactor = new HarvestInteractor(outputBoundary);
        interactor.execute(r, c);
    }

    public void testNoPlant(){
        // Create a farm and harvest a crop.
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.harvest(r, c);

        HarvestOutputBoundary outputBoundary = new HarvestOutputBoundary() {

            @Override
            public void harvestCrop(int r, int c) {
                // Assert if the crop is harvested (should not be possible since there was nothing to harvest.)
                assertFalse(farm.getFarmLand()[r][c].isPlanted());
            }
        };

        HarvestInteractor interactor = new HarvestInteractor(outputBoundary);
        interactor.execute(r, c);
    }

    public void testDeadCrop(){
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.plant(r, c);
        farm.getFarmLand()[r][c].getCrop().setIsAlive(false);
        farm.harvest(r, c);

        HarvestOutputBoundary outputBoundary = new HarvestOutputBoundary() {

            @Override
            public void harvestCrop(int r, int c) {
                // Assert if the crop is harvested, even if it is dead.
                assertFalse(farm.getFarmLand()[r][c].isPlanted());
            }
        };

        HarvestInteractor interactor = new HarvestInteractor(outputBoundary);
        interactor.execute(r, c);
    }
}