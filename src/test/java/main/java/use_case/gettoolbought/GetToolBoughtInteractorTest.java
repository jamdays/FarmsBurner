package main.java.use_case.gettoolbought;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.interface_adapter.toolmenu.GetToolBoughtController;
import org.junit.Test;

public class GetToolBoughtInteractorTest extends TestCase {
    @Test
    public void testGetToolBought() {
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);

        GetToolBoughtOutputBoundary outputBoundary = new GetToolBoughtOutputBoundary() {
            @Override
            public void toolBought(String tool, boolean bought, int level) {
            }
        };

        GetToolBoughtInteractor getInteractor = new GetToolBoughtInteractor(outputBoundary);
        GetToolBoughtController getController = new GetToolBoughtController(getInteractor);

        getController.getToolBought("sprinkler");
        assertEquals(getController.getToolBought("sprinkler").get(0), false);
        assertEquals(getController.getToolBought("sprinkler").get(1), 2);

        getController.getToolBought("harvester");
        assertEquals(getController.getToolBought("harvester").get(0), false);
        assertEquals(getController.getToolBought("harvester").get(1), 2);

        getController.getToolBought("tiller");
        assertEquals(getController.getToolBought("tiller").get(0), false);
        assertEquals(getController.getToolBought("tiller").get(1), 2);

        getController.getToolBought("fertilizer");
        assertEquals(getController.getToolBought("fertilizer").get(0), false);
        assertEquals(getController.getToolBought("fertilizer").get(1), 2);

        getController.getToolBought("planter");
        assertEquals(getController.getToolBought("planter").get(0), false);
        assertEquals(getController.getToolBought("planter").get(1), 2);
    }

}