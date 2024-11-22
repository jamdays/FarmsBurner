package main.java.entity;

import junit.framework.TestCase;
import main.java.entity.Land;

public class LandTest extends TestCase {

    public void testLand() {
        Land land = new Land();

        // isClaimed tests
        assertFalse(land.isClaimed());
        land.setClaimed(true);
        assertTrue(land.isClaimed());

        // isPlanted tests
        assertFalse(land.isPlanted());
        land.plant();
        assertTrue(land.isPlanted());
        assertNotNull(land.getCrop());

        // isWet tests
        assertFalse(land.isWet());
        land.water();
        assertTrue(land.isWet());
        land.setIsWet(false);
        assertFalse(land.isWet());

        // isFertilized tests
        land.setIsSnowy(false);
        land.fertilize();
        assertTrue(land.isFertilized());
        land.setFertilized(false);
        assertFalse(land.isFertilized());

        // isSnowy tests
        assertFalse(land.getIsSnowy());
        land.setIsSnowy(true);
        assertTrue(land.getIsSnowy());

        // harvest tests
        land.setClaimed(true);
        land.setIsSnowy(false);
        land.plant();
        land.getCrop().setAge(5);
        assertTrue(land.isPlanted());
        assertTrue(land.getCrop().getIsAlive());
        land.harvest();
        assertFalse(land.isPlanted());
        assertNull(land.getCrop());

        // Land with parameters tests
        Land land2 = new Land(new Crop());
        assertTrue(land2.isPlanted());
        assertTrue(land2.isClaimed());
        assertTrue(land2.isFertilized());
        assertFalse(land2.isWet());
        assertFalse(land2.getIsSnowy());

    }

}