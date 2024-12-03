package main.java.use_case.buytool;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.interface_adapter.toolmenu.BuyController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuyToolInteractorTest extends TestCase {
    @Test
    public void testUpgradeSprinkler() {
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);

        BuyToolOutputBoundary outputBoundary = new BuyToolOutputBoundary() {
            @Override
            public void buy(String tool) {
            }
        };

        BuyToolInteractor buyInteractor = new BuyToolInteractor(outputBoundary);
        BuyController buyController = new BuyController(buyInteractor);
        buyController.buy("sprinkler");
        buyController.buy("harvester");
        buyController.buy("tiller");
        buyController.buy("fertilizer");
        buyController.buy("planter");
        assertTrue(FarmSingleton.getInstance().getFarm().getSprinklerPurchased());
        assertTrue(FarmSingleton.getInstance().getFarm().getHarvesterPurchased());
        assertTrue(FarmSingleton.getInstance().getFarm().getTillerPurchased());
        assertTrue(FarmSingleton.getInstance().getFarm().getFertilizerPurchased());
        assertTrue(FarmSingleton.getInstance().getFarm().getPlanterPurchased());
    }

}