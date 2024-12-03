package main.java.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class RiceTest {

    @Test
    public void testDefaultRice() {
        /*
        Test rice default constructor
         */
        Land theland = new Land();
        CropFactory factory = new CropFactory();
        Rice rice = (Rice)factory.createCrop("Rice", 0L, theland);
        rice.setLand(theland);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(0, rice.getAge());

        assertSame(rice.getLand(), theland);

        assertEquals(0, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(0, rice.getTemp());
    }

    @Test
    public void testUpdateRice() {
        /*
        construct a rice
         */
        Land land = new Land();
        CropFactory factory = new CropFactory();
        Rice rice = (Rice)factory.createCrop("Rice", 0L, land);
        rice.setLand(land);

        rice.update(10);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(0, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(0, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(0, rice.getTemp());

        rice.update(86400);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(0, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(0, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(0, rice.getTemp());

        rice.setWaterLevel(1);
        assertTrue(rice.isWatered());
        rice.update(86400);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(1, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(0, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(0, rice.getTemp());


        rice.setTemp(15);
        rice.setWaterLevel(1);
        rice.update(86400);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(2, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(0, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(15, rice.getTemp());

        rice.setTemp(16);
        rice.setWaterLevel(1);
        rice.update(86400);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(3, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(5, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(16, rice.getTemp());

        rice.setWeather("Thunderstorm");
        rice.setTemp(16);
        rice.setWaterLevel(1);
        rice.update(86400);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(6, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(7, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("Thunderstorm", rice.getWeather());

        assertEquals(16, rice.getTemp());
    }

    @Test
    public void testSetAge() {
        /*
        construct a rice
         */
        Land land = new Land();
        CropFactory factory = new CropFactory();
        Rice rice = (Rice)factory.createCrop("Rice", 0L, land);
        rice.setLand(land);

        rice.setAge(2);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(2, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(0, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(0, rice.getTemp());

        rice.setAge(3);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(3, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(5, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(0, rice.getTemp());

        land.setFertilized(true);
        rice.setAge(3);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(3, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(10, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(0, rice.getTemp());

        rice.setAge(4);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(4, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(11, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(0, rice.getTemp());

        rice.setAge(5);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(5, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(12, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(0, rice.getTemp());

        rice.setAge(6);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(6, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(12, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(0, rice.getTemp());

        rice.setAge(7);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(7, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(12, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(0, rice.getTemp());

        rice.setAge(8);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(8, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(11, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(0, rice.getTemp());

        rice.setAge(9);
        rice.setAge(10);
        rice.setAge(11);
        rice.setAge(12);
        rice.setAge(13);
        rice.setAge(14);
        rice.setAge(15);
        rice.setAge(16);

        assertTrue(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(16, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(3, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(0, rice.getTemp());

        rice.setAge(17);
        rice.setAge(18);
        rice.setAge(19);
        rice.setAge(20);

        assertFalse(rice.getIsAlive());

        assertTrue("Rice".equalsIgnoreCase(rice.getName()));

        assertFalse(rice.isWatered());

        assertEquals(20, rice.getAge());

        assertSame(rice.getLand(), land);

        assertEquals(-1, rice.getPrice());

        assertEquals(0, rice.getWaterlevel());

        assertEquals("", rice.getWeather());

        assertEquals(0, rice.getTemp());
    }
}

