package main.java.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class CornTest {

    @Test
    public void testDefaultCorn() {
        /*
        Test corn default constructor
         */
        Land theland = new Land();
        CropFactory factory = new CropFactory();
        Corn corn = (Corn)factory.createCrop("Corn", 0L, theland);
        corn.setLand(theland);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(0, corn.getAge());

        assertSame(corn.getLand(), theland);

        assertEquals(0, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(0, corn.getTemp());
    }

    @Test
    public void testUpdateCorn() {
        /*
        construct a corn
         */
        Land land = new Land();
        CropFactory factory = new CropFactory();
        Corn corn = (Corn)factory.createCrop("Corn", 0L, land);
        corn.setLand(land);

        corn.update(10);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(0, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(0, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(0, corn.getTemp());

        corn.update(86400);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(0, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(0, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(0, corn.getTemp());

        corn.setWaterLevel(1);
        assertTrue(corn.isWatered());
        corn.update(86400);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(0, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(0, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(0, corn.getTemp());


        corn.setTemp(15);
        corn.setWaterLevel(1);
        corn.update(86400);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(1, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(0, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(15, corn.getTemp());

        corn.setTemp(16);
        corn.setWaterLevel(1);
        corn.update(86400);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(3, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(5, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(16, corn.getTemp());

        corn.setWeather("Thunderstorm");
        corn.setTemp(16);
        corn.setWaterLevel(1);
        corn.update(86400);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(3, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(5, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("Thunderstorm", corn.getWeather());

        assertEquals(16, corn.getTemp());
    }

    @Test
    public void testSetAge() {
        /*
        construct a corn
         */
        Land land = new Land();
        CropFactory factory = new CropFactory();
        Corn corn = (Corn)factory.createCrop("Corn", 0L, land);
        corn.setLand(land);

        corn.setAge(2);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(2, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(0, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(0, corn.getTemp());

        corn.setAge(3);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(3, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(5, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(0, corn.getTemp());

        land.setFertilized(true);
        corn.setAge(3);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(3, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(10, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(0, corn.getTemp());

        corn.setAge(4);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(4, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(11, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(0, corn.getTemp());

        corn.setAge(5);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(5, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(12, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(0, corn.getTemp());

        corn.setAge(6);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(6, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(12, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(0, corn.getTemp());

        corn.setAge(7);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(7, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(12, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(0, corn.getTemp());

        corn.setAge(8);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(8, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(11, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(0, corn.getTemp());

        corn.setAge(9);
        corn.setAge(10);
        corn.setAge(11);
        corn.setAge(12);
        corn.setAge(13);
        corn.setAge(14);
        corn.setAge(15);
        corn.setAge(16);

        assertTrue(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(16, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(3, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(0, corn.getTemp());

        corn.setAge(17);
        corn.setAge(18);
        corn.setAge(19);
        corn.setAge(20);

        assertFalse(corn.getIsAlive());

        assertTrue("Corn".equalsIgnoreCase(corn.getName()));

        assertFalse(corn.isWatered());

        assertEquals(20, corn.getAge());

        assertSame(corn.getLand(), land);

        assertEquals(-1, corn.getPrice());

        assertEquals(0, corn.getWaterlevel());

        assertEquals("", corn.getWeather());

        assertEquals(0, corn.getTemp());
    }
}
