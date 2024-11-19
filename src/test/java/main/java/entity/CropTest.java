package main.java.entity;

import junit.framework.TestCase;
import main.java.entity.Crop;

public class CropTest extends TestCase {

    public void testGetAge() {
        Crop crop = new Crop(1, true, 1);
        assertEquals(1, crop.getAge());
    }

    public void testSetAge(){
        Crop crop = new Crop();
        crop.setAge(1);
        assertEquals(1, crop.getAge());
    }

    public void testAgeIncrease(){
        Crop crop = new Crop();
        crop.water();
        assertEquals(1, crop.getAge());
    }

    public void testGetIsAlive(){
        Crop crop = new Crop(1, true, 1);
        assertTrue(crop.getIsAlive());
    }

    public void testGetIsDead(){
        Crop crop = new Crop(1, false, 1);
        assertFalse(crop.getIsAlive());
    }

    public void testTooMuchWater(){
        Crop crop = new Crop();
        for (int i = 0; i < 5; i++) {
            crop.water();
        }
        assertFalse(crop.getIsAlive());
    }

    public void testHarvest(){
        Crop crop = new Crop();
        crop.harvest();
        assertTrue(crop.getIsAlive());
        Crop crop1 = new Crop(5, true, 1);
        crop1.harvest();
        assertFalse(crop1.getIsAlive());
        Crop crop2 = new Crop(1, false, 1);
        crop2.harvest();
        assertFalse(crop2.getIsAlive());
    }

    public void testSetIsAlive(){
        Crop crop = new Crop();
        crop.setIsAlive(true);
        assertTrue(crop.getIsAlive());
    }

    public void testGetPrice(){
        Crop crop = new Crop(1, true, 1);
        assertEquals(1, crop.getPrice());
    }

    public void testSetPrice(){
        Crop crop = new Crop();
        crop.setPrice(1);
        assertEquals(1, crop.getPrice());
    }

    public void testIsWatered(){
        Crop crop = new Crop(1, true, 1);
        crop.water();
        assertTrue(crop.isWatered());
    }

    public void testGetWaterlevel(){
        Crop crop = new Crop();
        assertEquals(0, crop.getWaterlevel());
    }

    public void testSetWaterlevel(){
        Crop crop = new Crop();
        assertFalse(crop.isWatered());
        crop.setWaterlevel(1);
        assertTrue(crop.isWatered());
    }

    public void testGetReadyToHarvest(){
        Crop crop = new Crop();
        assertFalse(crop.getReadyToHarvest());
        Crop crop1 = new Crop(6, true, 1);
        assertTrue(crop1.getReadyToHarvest());
    }

}