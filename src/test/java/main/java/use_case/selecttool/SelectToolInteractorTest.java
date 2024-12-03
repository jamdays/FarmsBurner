package main.java.use_case.selecttool;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.interface_adapter.selecttool.SelectToolController;
import main.java.interface_adapter.toolmenu.UpgradeController;
import main.java.use_case.upgradetool.UpgradeToolInteractor;
import main.java.use_case.upgradetool.UpgradeToolOutputBoundary;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SelectToolInteractorTest extends TestCase {
    @Test
    public void testSelectTool() {
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);
        farm.setHarvesterPurchased(true);
        farm.setFertilizerPurchased(true);
        farm.setPlanterPurchased(true);
        farm.setSprinklerPurchased(true);
        farm.setTillerPurchased(true);

        SelectToolOutputBoundary outputBoundary = new SelectToolOutputBoundary() {
            @Override
            public void selectTool(String tool) {
                // No implementation needed for this test
            }
        };

        SelectToolInteractor interactor = new SelectToolInteractor(outputBoundary);
        SelectToolController controller = new SelectToolController(interactor);

        controller.selectTool("sprinkler");
        controller.selectTool("tiller");
        controller.selectTool("fertilizer");
        controller.selectTool("harvester");
        controller.selectTool("planter");
    }
  
}