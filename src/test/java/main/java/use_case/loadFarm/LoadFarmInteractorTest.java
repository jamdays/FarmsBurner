package main.java.use_case.loadFarm;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.entity.Land;
import main.java.entity.Rice;
import main.java.use_case.plant.PlantingException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LoadFarmInteractorTest extends TestCase {
    private Farm farm;
    private LoadFarmOutputBoundary outputBoundary;
    private LoadFarmInteractor interactor;

    @Before
    public void setUp() {
        farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);
        outputBoundary = new LoadFarmOutputBoundary() {
            @Override
            public void load(int[][] landInt, long[][] cropTimes, int[][] cropAges, int[][] prices, int barnBucks, int power) {
                // No-op for testing
            }
        };
        interactor = new LoadFarmInteractor(outputBoundary);
    }

    @Test
    public void testLoadFarm() throws PlantingException {
        Land land = new Land();
        Rice rice = new Rice(5, true, 3, System.currentTimeMillis(), land);
        farm.claim(1, 1);
        farm.plant(1, 1, System.currentTimeMillis());
        farm.getFarmLand()[1][1].setCrop(rice);
        farm.getFarmLand()[1][1].setFertilized(true);
        farm.getFarmLand()[1][1].setIsWet(true);
        farm.getFarmLand()[1][1].getCrop().setIsAlive(true);

        interactor.load();

        long expectedCropTimes = rice.getTime();

        int expectedCropAges = rice.getAge();

        int expectedPrices = rice.getPrice();

        assertTrue(farm.getFarmLand()[1][1].isClaimed());
        assertTrue(farm.getFarmLand()[1][1].isPlanted());
        assertEquals(expectedCropTimes, FarmSingleton.getInstance().getFarm().getFarmLand()[1][1].getCrop().getTime());
        assertEquals(expectedCropAges, FarmSingleton.getInstance().getFarm().getFarmLand()[1][1].getCrop().getAge());
        assertEquals(expectedPrices, FarmSingleton.getInstance().getFarm().getFarmLand()[1][1].getCrop().getPrice());
    }
}