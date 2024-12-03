package main.java.entity;

import junit.framework.TestCase;
import main.java.use_case.plant.PlantingException;

public class LandTest extends TestCase {


    public void testLand() throws PlantingException {
        Farm farm = new Farm();
        farm.setWeather(0, false, false, false, false, false, true, 15, "sunny", System.currentTimeMillis());
        farm.setBarnBucks(5000);
        farm.setPower(5000);
        FarmSingleton.getInstance().setFarm(farm);

        // isClaimed tests
        assertFalse(farm.getFarmLand()[0][0].isClaimed());
        farm.getFarmLand()[0][0].water();
        farm.claim(0, 0);
        assertTrue(farm.getFarmLand()[0][0].isClaimed());

        // isPlanted tests
        assertFalse(farm.getFarmLand()[0][0].isPlanted());
        farm.getFarmLand()[0][0].water();
        farm.getFarmLand()[0][0].plant(System.currentTimeMillis(), "wheat");
        assertTrue(farm.getFarmLand()[0][0].isPlanted());
        assertNotNull(farm.getFarmLand()[0][0].getCrop());
        farm.getFarmLand()[1][1].setPlanted(false);
        assertFalse(farm.getFarmLand()[1][1].isPlanted());

        // isWet tests
        assertFalse(farm.getFarmLand()[0][0].isWet());
        farm.getFarmLand()[0][0].water();
        assertTrue(farm.getFarmLand()[0][0].isWet());
        farm.getFarmLand()[0][0].setIsWet(false);
        assertFalse(farm.getFarmLand()[0][0].isWet());

        // isFertilized tests
        farm.getFarmLand()[0][0].setIsSnowy(false);
        farm.getFarmLand()[0][0].fertilize();
        assertTrue(farm.getFarmLand()[0][0].isFertilized());
        farm.getFarmLand()[0][0].setFertilized(false);
        assertFalse(farm.getFarmLand()[0][0].isFertilized());

        // isSnowy tests
        assertFalse(farm.getFarmLand()[0][0].getIsSnowy());
        farm.getFarmLand()[0][0].setIsSnowy(true);
        farm.getFarmLand()[0][0].water();
        assertTrue(farm.getFarmLand()[0][0].getIsSnowy());

        // harvest tests
        farm.getFarmLand()[0][0].setClaimed(true);
        farm.getFarmLand()[0][0].setIsSnowy(false);
        farm.getFarmLand()[0][0].getCrop().setAge(5);
        assertTrue(farm.getFarmLand()[0][0].isPlanted());
        assertTrue(farm.getFarmLand()[0][0].getCrop().getIsAlive());
        farm.getFarmLand()[0][0].harvest();
        assertFalse(farm.getFarmLand()[0][0].isPlanted());
        assertNull(farm.getFarmLand()[0][0].getCrop());
    }


}