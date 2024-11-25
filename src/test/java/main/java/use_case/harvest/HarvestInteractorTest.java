package main.java.use_case.harvest;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.plant.PlantingException;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class HarvestInteractorTest extends TestCase {
    @Test
    public void testExecute() throws PlantingException {
        Farm farm = new Farm();
        farm.claim(1, 1);
        farm.plant(1, 1);
        farm.getFarmLand()[1][1].getCrop().setAge(5);
        FarmSingleton.getInstance().setFarm(farm);
        HarvestOutputBoundary harvestOutputBoundary = new HarvestOutputBoundary() {
            @Override
            public void harvestCrop(int r, int c){
                farm.harvest(r, c);
                assertFalse(FarmSingleton.getInstance().getFarm().getFarmLand()[r][c].isPlanted());
            }

        };

        HarvestInteractor harvestInteractor = new HarvestInteractor(harvestOutputBoundary);
        harvestInteractor.execute(1, 1);

    }

    @Test
    public void testNotReady() throws PlantingException, HarvestException {
        Farm farm = FarmSingleton.getInstance().getFarm();
        farm.claim(1, 1);
        farm.plant(1, 1);
        farm.getFarmLand()[1][1].getCrop().setAge(1);

        HarvestOutputBoundary harvestOutputBoundary = new HarvestOutputBoundary() {
            @Override
            public void harvestCrop(int r, int c) {
                assertThrows(HarvestException.class, () -> farm.harvest(r, c));
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
            public void harvestCrop(int r, int c) {
                assertThrows(HarvestException.class, () -> farm.harvest(r, c));
            }
        };

        HarvestInteractor harvestInteractor = new HarvestInteractor(harvestOutputBoundary);
        harvestInteractor.execute(1, 1);
    }

}