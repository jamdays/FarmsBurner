package main.java.entity;

import junit.framework.TestCase;

public class CrateTest extends TestCase {

        public void testGetDaysLeft() {
            Crate crate = new Crate(5, new AbstractCrop[5]);
            assertEquals(5, crate.getDaysLeft());
        }

        public void testSetDaysLeft() {
            Crate crate = new Crate(5, new AbstractCrop[5]);
            crate.setDaysLeft(10);
            assertEquals(10, crate.getDaysLeft());
        }

        public void testGetCrops() {
            AbstractCrop[] crops = new AbstractCrop[5];
            Crate crate = new Crate(5, crops);
            assertEquals(crops, crate.getCrops());
        }

        public void testSetCrops() {
            AbstractCrop[] crops = new AbstractCrop[5];
            Crate crate = new Crate(5, new AbstractCrop[5]);
            crate.setCrops(crops);
            assertEquals(crops, crate.getCrops());
        }

}