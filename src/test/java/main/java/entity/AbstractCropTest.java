package main.java.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class AbstractCropTest {

    @Test
    public void testUpdate() {
        /*
        construct an abstract crop
         */
        Land land = new Land();
        AbstractCrop crop = new Rice(86400, land);
        crop.setLand(land);

        crop.setWaterLevel(1);

        int tim = 0;
        crop.update(tim);
        assertEquals(0, tim);
    }

    @Test
    public void testSetTime() {
        /*
        construct an abstract crop
         */
        Land land = new Land();
        AbstractCrop crop = new Rice(86400, land);
        crop.setLand(land);

        crop.setTime(10);

        assertEquals(10, crop.getTime());
    }

    @Test
    public void testGetReadyToHarvest() {
        /*
        construct an abstract crop
         */
        Land land = new Land();
        AbstractCrop crop = new Rice(86400, land);
        crop.setLand(land);

        assertFalse(crop.getReadyToHarvest());
    }
}
