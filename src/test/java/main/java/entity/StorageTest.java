package main.java.entity;

import junit.framework.TestCase;
import java.util.ArrayList;

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
        Land land = new Land();
        ArrayList<AbstractCrop> crops = new ArrayList<AbstractCrop>();
        crops.add(new Rice(System.currentTimeMillis(), land));
        storage.setCrops(crops);
        assertEquals(storage.getCrops().size(), 1);
    }
}