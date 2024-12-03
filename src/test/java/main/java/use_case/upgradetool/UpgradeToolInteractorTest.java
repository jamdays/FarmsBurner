package main.java.use_case.upgradetool;

import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.interface_adapter.toolmenu.UpgradeController;
import main.java.use_case.upgradetool.UpgradeToolInteractor;
import main.java.use_case.upgradetool.UpgradeToolOutputBoundary;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UpgradeToolInteractorTest {

    // test that you don't start the game with a sprinkler (will add this in once appropriate changes have been made in the farm constructor)

    // test that upgrading the sprinkler updates its stats appropriately
    @Test
    public void testUpgradeSprinkler() {
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);

        UpgradeToolOutputBoundary outputBoundary = new UpgradeToolOutputBoundary() {
            @Override
            public void upgrade(String tool) {
            }
        };

        UpgradeToolInteractor interactor = new UpgradeToolInteractor(outputBoundary);
        UpgradeController controller = new UpgradeController(interactor);

        assertEquals(2, farm.getSprinklerLevel());
        controller.upgrade("sprinkler");
        assertEquals(3, farm.getSprinklerLevel());
    }

    // test that trying to upgrade the sprinkler when it is already maxed out does not change its level
    @Test
    public void testMaxedOutSprinkler() {
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);

        UpgradeToolOutputBoundary outputBoundary = new UpgradeToolOutputBoundary() {
            @Override
            public void upgrade(String tool) {
                // No implementation needed for this test
            }
        };

        UpgradeToolInteractor interactor = new UpgradeToolInteractor(outputBoundary);
        UpgradeController controller = new UpgradeController(interactor);

        // Upgrade sprinkler to level 4
        for (int i = 0; i < 2; i++) {
            controller.upgrade("sprinkler");
        }

        assertEquals(4, farm.getSprinklerLevel());
        controller.upgrade("sprinkler");
        assertEquals(5, farm.getSprinklerLevel());
        controller.upgrade("sprinkler");
        assertEquals(5, farm.getSprinklerLevel());
    }
}
