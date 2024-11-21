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

    public void testGetCrates() {
        Storage storage = new Storage(10);
        assertEquals(storage.getCrates().size(), 0);
    }

    public void testSetCrates() {
        Storage storage = new Storage(10);
        ArrayList<Crate> crates = new ArrayList<Crate>();
        crates.add(new Crate(5, new Crop[1]));
        storage.setCrates(crates);
        assertEquals(storage.getCrates().size(), 1);
    }
}