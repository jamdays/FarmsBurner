package main.java.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class WheatTest {

    @Test
    public void testDefaultWheat() {
        /*
        Test wheat default constructor
         */
        Land theland = new Land();
        CropFactory factory = new CropFactory();
        Wheat wheat = (Wheat)factory.createCrop("Wheat", 0L, theland);
        wheat.setLand(theland);

        assertTrue(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(0, wheat.getAge());

        assertSame(wheat.getLand(), theland);

        assertEquals(0, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(0, wheat.getTemp());
    }

    @Test
    public void testUpdateWheat() {
        /*
        construct a wheat
         */
        Land land = new Land();
        CropFactory factory = new CropFactory();
        Wheat wheat = (Wheat)factory.createCrop("Wheat", 0L, land);
        wheat.setLand(land);

        wheat.update(10);

        assertTrue(wheat.getIsAlive());

        assertTrue("wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(0, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(0, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(0, wheat.getTemp());

        wheat.update(86400);

        assertTrue(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(0, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(0, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(0, wheat.getTemp());

        wheat.setWaterLevel(1);
        assertTrue(wheat.isWatered());
        wheat.update(86400);

        assertTrue(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(0, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(0, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(0, wheat.getTemp());


        wheat.setTemp(15);
        wheat.setWaterLevel(1);
        wheat.update(86400);

        assertTrue(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(1, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(0, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(15, wheat.getTemp());

        wheat.setTemp(16);
        wheat.setWaterLevel(1);
        wheat.update(86400);

        assertTrue(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(4, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(6, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(16, wheat.getTemp());

        wheat.setWeather("Thunderstorm");
        wheat.setTemp(16);
        wheat.setWaterLevel(1);
        wheat.update(86400);

        assertTrue(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(6, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(7, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("Thunderstorm", wheat.getWeather());

        assertEquals(16, wheat.getTemp());
    }

    @Test
    public void testSetAge() {
        /*
        construct a wheat
         */
        Land land = new Land();
        CropFactory factory = new CropFactory();
        Wheat wheat = (Wheat)factory.createCrop("Wheat", 0L, land);
        wheat.setLand(land);

        wheat.setAge(2);

        assertTrue(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(2, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(0, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(0, wheat.getTemp());

        wheat.setAge(3);

        assertTrue(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(3, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(5, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(0, wheat.getTemp());

        land.setFertilized(true);
        wheat.setAge(3);

        assertTrue(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(3, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(10, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(0, wheat.getTemp());

        wheat.setAge(4);

        assertTrue(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(4, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(11, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(0, wheat.getTemp());

        wheat.setAge(5);

        assertTrue(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(5, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(12, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(0, wheat.getTemp());

        wheat.setAge(6);

        assertTrue(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(6, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(12, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(0, wheat.getTemp());

        wheat.setAge(7);

        assertTrue(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(7, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(12, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(0, wheat.getTemp());

        wheat.setAge(8);

        assertTrue(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(8, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(11, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(0, wheat.getTemp());

        wheat.setAge(9);
        wheat.setAge(10);
        wheat.setAge(11);
        wheat.setAge(12);
        wheat.setAge(13);
        wheat.setAge(14);
        wheat.setAge(15);
        wheat.setAge(16);

        assertTrue(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(16, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(3, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(0, wheat.getTemp());

        wheat.setAge(17);
        wheat.setAge(18);
        wheat.setAge(19);
        wheat.setAge(20);

        assertFalse(wheat.getIsAlive());

        assertTrue("Wheat".equalsIgnoreCase(wheat.getName()));

        assertFalse(wheat.isWatered());

        assertEquals(20, wheat.getAge());

        assertSame(wheat.getLand(), land);

        assertEquals(-1, wheat.getPrice());

        assertEquals(0, wheat.getWaterlevel());

        assertEquals("", wheat.getWeather());

        assertEquals(0, wheat.getTemp());
    }
}
