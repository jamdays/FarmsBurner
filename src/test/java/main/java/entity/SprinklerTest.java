package main.java.entity;

import junit.framework.TestCase;

public class SprinklerTest extends TestCase {

    public void testSprinkler() {
        Sprinkler sprinkler = new Sprinkler(0);
        assertEquals(150, sprinkler.getPower());
        assertEquals(0, sprinkler.getLevel());
        assertEquals(1, sprinkler.getArea());
        sprinkler.upgrade();
        assertEquals(1, sprinkler.getLevel());
        assertEquals(300, sprinkler.getPower());
        assertEquals(4, sprinkler.getArea());
        Sprinkler newSprinkler = new Sprinkler(1);
        assertEquals(1, newSprinkler.getLevel());
        assertEquals(300, newSprinkler.getPower());
        assertEquals(4, newSprinkler.getArea());
    }


}