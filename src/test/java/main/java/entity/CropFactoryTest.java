package main.java.entity;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CropFactoryTest {
    @Test
    public void testCropFactory(){
        CropFactory cropFactory = new CropFactory();
        Land land = new Land();
        assertTrue(cropFactory.createCrop("Corn", 0L, land) instanceof Corn);
        assertTrue(cropFactory.createCrop("Snowberry", 1L, land) instanceof Snowberry);
        assertTrue(cropFactory.createCrop("Wheat", 1L, land) instanceof Wheat);
        assertTrue(cropFactory.createCrop("Rice", 0L, land) instanceof Rice);
        assertNotNull(cropFactory.createCrop("Rice", 1L, land));
        assertNotNull(cropFactory.createCrop("Corn", 1L, land));
        assertNotNull(cropFactory.createCrop("Wheat", 1L, land));
        assertNotNull(cropFactory.createCrop("Snowberry", 1L, land));
    }
}