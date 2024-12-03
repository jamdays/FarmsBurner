package main.java.use_case.harvest;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.plant.PlantingException;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class HarvestInteractorTest extends TestCase {
    /*
    @Test
    public void testExecute() throws PlantingException {
        Farm farm = new Farm();
        farm.claim(1, 1);
        farm.plant(1, 1);
        farm.getFarmLand()[1][1].getCrop().setAge(5);
        FarmSingleton.getInstance().setFarm(farm);
        HarvestOutputBoundary harvestOutputBoundary = new HarvestOutputBoundary() {
            @Override
            public void harvestCrop(int row, int col){
                farm.harvest(row, col);
                assertFalse(FarmSingleton.getInstance().getFarm().getFarmLand()[row][col].isPlanted());
            }

        };

        HarvestInteractor harvestInteractor = new HarvestInteractor(harvestOutputBoundary);
        harvestInteractor.execute(1, 1);

    }

    public void testHarvestSuccessMultiple() throws PlantingException {
        // Create a farm and plant a crop.
        Farm farm = new Farm();
        farm.claim(1, 1);
        farm.claim(2, 2);
        farm.claim(1, 2);
        farm.claim(2, 1);
        farm.plant(1, 1);
        farm.plant(2, 2);
        farm.plant(1, 2);
        farm.plant(2, 1);
        farm.getFarmLand()[1][1].getCrop().setAge(5);
        farm.getFarmLand()[2][2].getCrop().setAge(5);
        farm.getFarmLand()[1][2].getCrop().setAge(5);
        farm.getFarmLand()[2][1].getCrop().setAge(5);
        farm.harvest(1, 1);
        farm.harvest(2, 2);
        farm.harvest(1, 2);
        farm.harvest(2, 1);

        HarvestOutputBoundary outputBoundary = new HarvestOutputBoundary() {

            @Override
            public void harvestCrop(int row, int col) {
                // Assert if the crop is harvested.
                assertFalse(farm.getFarmLand()[row][col].isPlanted());
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

    @Test
    public void testNotReady() throws PlantingException, HarvestException {
        Farm farm = new Farm();
        farm.claim(1, 1);
        farm.plant(1, 1);
        farm.getFarmLand()[1][1].getCrop().setAge(1);

        HarvestOutputBoundary harvestOutputBoundary = new HarvestOutputBoundary() {
            @Override
            public void harvestCrop(int row, int col) {
                assertThrows(HarvestException.class, () -> farm.harvest(row, col));
            }
        };

        HarvestInteractor harvestInteractor = new HarvestInteractor(harvestOutputBoundary);
        harvestInteractor.execute(1, 1);
    }

    @Test
    public void testDeadPlant() throws HarvestException, PlantingException {
        Farm farm = FarmSingleton.getInstance().getFarm();
        farm.claim(1, 1);
        farm.plant(1, 1);
        farm.getFarmLand()[1][1].getCrop().setIsAlive(false);

        HarvestOutputBoundary harvestOutputBoundary = new HarvestOutputBoundary() {
            @Override
            public void harvestCrop(int row, int col) {
                assertThrows(HarvestException.class, () -> farm.harvest(row, col));
            }
        };

        HarvestInteractor harvestInteractor = new HarvestInteractor(harvestOutputBoundary);
        harvestInteractor.execute(1, 1);
    }

     */

}