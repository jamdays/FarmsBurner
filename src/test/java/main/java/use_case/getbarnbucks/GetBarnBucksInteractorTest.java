package main.java.use_case.getbarnbucks;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.interface_adapter.farm.GetActiveToolController;
import main.java.interface_adapter.toolmenu.GetBarnBucksController;
import org.junit.Test;


public class GetBarnBucksInteractorTest extends TestCase {

    @Test
    public void testGetBarnBucks() {
        Farm farm = new Farm();
        farm.setBarnBucks(100);
        FarmSingleton.getInstance().setFarm(farm);

        GetBarnBucksOutputBoundary outputBoundary = new GetBarnBucksOutputBoundary() {
            @Override
            public void bucks(int bb) {
                assertEquals(bb, farm.getBarnBucks());
            }
        };

        GetBarnBucksInteractor getBarnBucksInteractor = new GetBarnBucksInteractor(outputBoundary);
        GetBarnBucksController getBarnBucksController = new GetBarnBucksController(getBarnBucksInteractor);
        getBarnBucksController.getbb();
    }

}
