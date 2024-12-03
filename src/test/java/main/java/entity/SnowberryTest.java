package main.java.entity;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class SnowberryTest{
    @Test
    public void testDefaultSnowberry() {
        /*
        Test snowberry default constructor
         */
        Land theland = new Land();
        CropFactory factory = new CropFactory();
        Snowberry snowberry = (Snowberry) factory.createCrop("Snowberry", 0L, theland);
        snowberry.setLand(theland);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(0, snowberry.getAge());

        assertSame(snowberry.getLand(), theland);

        assertEquals(0, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("", snowberry.getWeather());

        assertEquals(0, snowberry.getTemp());
    }

    @Test
    public void testUpdateSnowberry() {
        /*
        construct a snowberry
         */
        Land land = new Land();
        CropFactory factory = new CropFactory();
        Snowberry snowberry = (Snowberry) factory.createCrop("Snowberry", 0L, land);
        snowberry.setLand(land);

        snowberry.update(10);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(0, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(0, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("", snowberry.getWeather());

        assertEquals(0, snowberry.getTemp());

        snowberry.update(86400);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(0, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(0, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("", snowberry.getWeather());

        assertEquals(0, snowberry.getTemp());

        snowberry.setWaterLevel(1);
        assertTrue(snowberry.isWatered());
        snowberry.update(86400);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(1, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(0, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("", snowberry.getWeather());

        assertEquals(0, snowberry.getTemp());


        snowberry.setWeather("Snow");
        snowberry.setTemp(2);
        snowberry.setWaterLevel(1);
        snowberry.update(86400);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(3, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(5, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("Snow", snowberry.getWeather());

        assertEquals(2, snowberry.getTemp());

        snowberry.setWeather("Snow");
        snowberry.setTemp(-11);
        snowberry.setWaterLevel(1);
        snowberry.update(86400);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(6, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(7, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("Snow", snowberry.getWeather());

        assertEquals(-11, snowberry.getTemp());

        snowberry.setTemp(9);
        snowberry.setWaterLevel(1);
        snowberry.update(86400);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(6, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(7, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("Snow", snowberry.getWeather());

        assertEquals(9, snowberry.getTemp());

        snowberry.setWeather("Snow");
        snowberry.setTemp(19);
        snowberry.setWaterLevel(1);
        snowberry.update(86400);

        assertFalse(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(7, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(7, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("Snow", snowberry.getWeather());

        assertEquals(19, snowberry.getTemp());
    }

    @Test
    public void testSetAge() {
        /*
        construct a snowberry
         */
        Land land = new Land();
        CropFactory factory = new CropFactory();
        Snowberry snowberry = (Snowberry)factory.createCrop("Snowberry", 0L, land);
        snowberry.setLand(land);

        snowberry.setAge(2);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(2, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(0, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("", snowberry.getWeather());

        assertEquals(0, snowberry.getTemp());

        snowberry.setAge(3);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(3, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(5, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("", snowberry.getWeather());

        assertEquals(0, snowberry.getTemp());

        land.setFertilized(true);
        snowberry.setAge(3);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(3, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(10, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("", snowberry.getWeather());

        assertEquals(0, snowberry.getTemp());

        snowberry.setAge(4);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(4, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(11, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("", snowberry.getWeather());

        assertEquals(0, snowberry.getTemp());

        snowberry.setAge(5);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(5, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(12, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("", snowberry.getWeather());

        assertEquals(0, snowberry.getTemp());

        snowberry.setAge(6);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(6, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(12, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("", snowberry.getWeather());

        assertEquals(0, snowberry.getTemp());

        snowberry.setAge(7);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(7, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(12, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("", snowberry.getWeather());

        assertEquals(0, snowberry.getTemp());

        snowberry.setAge(8);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(8, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(11, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("", snowberry.getWeather());

        assertEquals(0, snowberry.getTemp());

        snowberry.setAge(9);
        snowberry.setAge(10);
        snowberry.setAge(11);
        snowberry.setAge(12);
        snowberry.setAge(13);
        snowberry.setAge(14);
        snowberry.setAge(15);
        snowberry.setAge(16);

        assertTrue(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(16, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(3, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("", snowberry.getWeather());

        assertEquals(0, snowberry.getTemp());

        snowberry.setAge(17);
        snowberry.setAge(18);
        snowberry.setAge(19);
        snowberry.setAge(20);

        assertFalse(snowberry.getIsAlive());

        assertTrue("Snowberry".equalsIgnoreCase(snowberry.getName()));

        assertFalse(snowberry.isWatered());

        assertEquals(20, snowberry.getAge());

        assertSame(snowberry.getLand(), land);

        assertEquals(-1, snowberry.getPrice());

        assertEquals(0, snowberry.getWaterlevel());

        assertEquals("", snowberry.getWeather());

        assertEquals(0, snowberry.getTemp());
    }
}
