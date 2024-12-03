package main.java.use_case.buytool;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.interface_adapter.toolmenu.BuyController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuyToolInteractorTest extends TestCase {
    @Test
    public void testBuyTool() {
        Farm farm = new Farm();
        farm.setWeather(0, false, false, false, false, false, true, 15, "sunny", System.currentTimeMillis());
        farm.setBarnBucks(5000);
        FarmSingleton.getInstance().setFarm(farm);

        BuyToolOutputBoundary outputBoundary = new BuyToolOutputBoundary() {
            @Override
            public void buy(String tool) {
                switch (tool) {
                    case "sprinkler":
                        FarmSingleton.getInstance().getFarm().setSprinklerPurchased(true);
                        assertTrue(farm.getSprinklerPurchased());
                        break;
                    case "harvester":
                        FarmSingleton.getInstance().getFarm().setHarvesterPurchased(true);
                        assertTrue(farm.getHarvesterPurchased());
                        break;
                    case "tiller":
                        FarmSingleton.getInstance().getFarm().setTillerPurchased(true);
                        assertTrue(farm.getTillerPurchased());
                        break;
                    case "fertilizer":
                        FarmSingleton.getInstance().getFarm().setFertilizerPurchased(true);
                        assertTrue(farm.getFertilizerPurchased());
                        break;
                    case "planter":
                        FarmSingleton.getInstance().getFarm().setPlanterPurchased(true);
                        assertTrue(farm.getPlanterPurchased());
                        break;
                }
            }
        };

        BuyToolInteractor buyInteractor = new BuyToolInteractor(outputBoundary);
        BuyController buyController = new BuyController(buyInteractor);
        buyController.buy("sprinkler");
        buyController.buy("harvester");
        buyController.buy("tiller");
        buyController.buy("fertilizer");
        buyController.buy("planter");
    }

}