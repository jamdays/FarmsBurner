package main.java.entity;

import junit.framework.TestCase;

public class FarmSingletonTest extends TestCase {

    public void testFarmSingleton() {
        Farm farm = new Farm();
        Farm farm2 = new Farm();
        FarmSingleton.setInstance(farm);
        assertEquals(farm, FarmSingleton.getInstance().getFarm());
        FarmSingleton.setInstance(farm2);
        assertEquals(farm2, FarmSingleton.getInstance().getFarm());
    }
}