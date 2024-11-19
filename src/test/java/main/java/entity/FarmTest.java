package main.java.entity;

import junit.framework.TestCase;

public class FarmTest extends TestCase {

    public void testFarm() {
        Land[][] farmLand = new Land[8][10];
        Farm farm = new Farm(farmLand);
        assertEquals(farmLand, farm.getFarmLand());
        assertEquals(0, farm.getBarnBucks());
        assertEquals(0, farm.getPower());
        assertNull(farm.getSprinkler());
        farm.setPower(1);
        assertEquals(1, farm.getPower());
        farm.setBarnBucks(1);
        assertEquals(1, farm.getBarnBucks());
        // TODO: uncomment this once we are able to get a sprinkler
        assertNotNull(farm.getSprinkler());
    }

}