package main.java.entity;

import junit.framework.TestCase;
import java.util.ArrayList;
import main.java.entity.Crate;
import main.java.entity.Crop;

public class StorageTest extends TestCase {

    public void testGetCapacity() {
        Storage storage = new Storage(10);
        assertEquals(storage.getCapacity(), 10);
    }

    public void testSetCapacity() {
        Storage storage = new Storage(10);
        storage.setCapacity(20);
        assertEquals(storage.getCapacity(), 20);
    }

    public void testGetCrops() {
        Storage storage = new Storage(10);
        assertEquals(storage.getCrops().size(), 0);
    }

    public void testSetCrops() {
        Storage storage = new Storage(10);
        ArrayList<Crop> crops = new ArrayList<Crop>();
        crops.add(new Crop());
        storage.setCrops(crops);
        assertEquals(storage.getCrops().size(), 1);
    }
}