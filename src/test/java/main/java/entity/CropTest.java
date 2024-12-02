package main.java.entity;

import junit.framework.TestCase;

public class CropTest extends TestCase {

    public void testGetAge() {
        AbstractCrop crop = new AbstractCrop(1, true, 1);
        assertEquals(1, crop.getAge());
    }

    public void testSetAge(){
        AbstractCrop crop = new AbstractCrop();
        crop.setAge(1);
        assertEquals(1, crop.getAge());
    }

    public void testAgeIncrease(){
        AbstractCrop crop = new AbstractCrop();
        crop.water();
        assertEquals(1, crop.getAge());
    }

    public void testGetIsAlive(){
        AbstractCrop crop = new AbstractCrop(1, true, 1);
        assertTrue(crop.getIsAlive());
    }

    public void testGetIsDead(){
        AbstractCrop crop = new AbstractCrop(1, false, 1);
        assertFalse(crop.getIsAlive());
    }

    public void testTooMuchWater(){
        AbstractCrop crop = new AbstractCrop();
        for (int i = 0; i < 5; i++) {
            crop.water();
        }
        assertFalse(crop.getIsAlive());
    }

    public void testHarvest(){
        AbstractCrop crop = new AbstractCrop();
        crop.harvest();
        assertFalse(crop.getIsAlive());
        AbstractCrop crop1 = new AbstractCrop(5, true, 1);
        crop1.harvest();
        assertFalse(crop1.getIsAlive());
        AbstractCrop crop2 = new AbstractCrop(1, false, 1);
        crop2.harvest();
        assertFalse(crop2.getIsAlive());
    }

    public void testSetIsAlive(){
        AbstractCrop crop = new AbstractCrop();
        crop.setIsAlive(true);
        assertTrue(crop.getIsAlive());
    }

    public void testGetPrice(){
        AbstractCrop crop = new AbstractCrop(1, true, 1);
        assertEquals(1, crop.getPrice());
    }

    public void testSetPrice(){
        AbstractCrop crop = new AbstractCrop();
        crop.setPrice(1);
        assertEquals(1, crop.getPrice());
    }

    public void testIsWatered(){
        AbstractCrop crop = new AbstractCrop(1, true, 1);
        crop.water();
        assertTrue(crop.isWatered());
    }

    public void testGetWaterlevel(){
        AbstractCrop crop = new AbstractCrop();
        assertEquals(0, crop.getWaterlevel());
    }

    public void testSetWaterlevel(){
        AbstractCrop crop = new AbstractCrop();
        assertFalse(crop.isWatered());
        crop.setWaterLevel(1);
        assertTrue(crop.isWatered());
    }

    public void testGetReadyToHarvest(){
        AbstractCrop crop = new AbstractCrop();
        assertFalse(crop.getReadyToHarvest());
        AbstractCrop crop1 = new AbstractCrop(6, true, 1);
        assertTrue(crop1.getReadyToHarvest());
    }

}