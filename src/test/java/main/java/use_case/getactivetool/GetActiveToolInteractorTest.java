package main.java.use_case.getactivetool;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.interface_adapter.farm.GetActiveToolController;
import main.java.interface_adapter.toolmenu.BuyController;
import main.java.use_case.buytool.BuyToolInteractor;

public class GetActiveToolInteractorTest extends TestCase {
    public void testGetActiveTool() {
        Farm farm = new Farm();
        farm.setActiveTool("sprinkler");
        FarmSingleton.getInstance().setFarm(farm);

        GetActiveToolOutputBoundary outputBoundary = new GetActiveToolOutputBoundary() {
            @Override
            public void activeTool(String tool) {
                assertEquals("sprinkler", tool);
            }
        };

        GetActiveToolInteractor getActiveToolInteractor = new GetActiveToolInteractor(outputBoundary);
        GetActiveToolController getActiveToolController = new GetActiveToolController(getActiveToolInteractor);
        getActiveToolController.getActiveTool();
    }


}