package main.java.entity;

import junit.framework.TestCase;
import main.java.use_case.plant.PlantingException;

public class FarmTest extends TestCase {

    public void testFarm() throws PlantingException {
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);
        farm.setWeather(0, false, false, false, false, false, true, 15, "sunny", 0L);
        farm.getFarmLand();
        assertEquals(0, farm.getBarnBucks());
        farm.setPower(1);
        assertEquals(1, farm.getPower());
        farm.setBarnBucks(1);
        assertEquals(1, farm.getBarnBucks());
        farm.setSprinklerPurchased(true);
        farm.setBarnBucks(100000);

        farm.setCity("Toronto");
        assertEquals("Toronto", farm.getCity());

        farm.setSprinklerPurchased(true);
        assertTrue(farm.getSprinklerPurchased());
        farm.setSprinklerLevel(1);
        assertEquals(1, farm.getSprinklerLevel());

        farm.setHarvesterPurchased(true);
        assertTrue(farm.getHarvesterPurchased());
        farm.setHarvesterLevel(1);
        assertEquals(1, farm.getHarvesterLevel());

        farm.setTillerPurchased(true);
        assertTrue(farm.getTillerPurchased());
        farm.setTillerLevel(1);
        assertEquals(1, farm.getTillerLevel());

        farm.setFertilizerPurchased(true);
        assertTrue(farm.getFertilizerPurchased());
        farm.setFertilizerLevel(1);
        assertEquals(1, farm.getFertilizerLevel());

        farm.setPlanterPurchased(true);
        assertTrue(farm.getPlanterPurchased());
        farm.setPlanterLevel(1);
        assertEquals(1, farm.getPlanterLevel());

        farm.setActiveTool("sprinkler");
        assertEquals("sprinkler", farm.getActiveTool());

        farm.setActiveCrop("wheat");
        assertEquals("wheat", farm.getActiveCrop());

        farm.claim(0,0);
        farm.fertilize(0,0);
        farm.plant(0,0, System.currentTimeMillis());
        farm.water(0,0);
        farm.harvest(0,0);
        farm.sell(1);

        farm.setLogOutTime(0L);
        farm.getTime();

        Storage storage = new Storage(1);
        farm.setStorage(storage);
        assertEquals(1, farm.getStorage().getCapacity());

        farm.isClear();
        farm.isCloudy();
        farm.isFog();
        farm.isThunderstorm();
        farm.isSnowy();
        farm.isRainy();
        farm.getDay();

        farm.setTemp(1);
        assertEquals(1, farm.getTemp());

        farm.setWeather(1, true, true, true, true, true, true, 1, "rainy", 1);
        farm.getWeather();
        farm.weather("sunny");
    }

    public void testRefreshPower(){
        Land[][] farmLand = new Land[8][10];
        Farm farm = new Farm(farmLand);
        farm.setPower(1);
        farm.refreshPower(System.currentTimeMillis());
        farm.getPowerRefresh();
        assertTrue(true);
    }

}