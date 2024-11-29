package main.java.use_case.upgradetool;

import main.java.entity.Farm;
import main.java.entity.Sprinkler;
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

        UpgradeToolOutputBoundary outputBoundary = new UpgradeToolOutputBoundary() {
            @Override
            public void upgrade(String tool) {
                assertEquals(0, farm.getSprinkler().getLevel());
                for (int i = 0; i < 5; i++) {
                    // check that current stats match level
                    assertEquals(i, farm.getSprinkler().getLevel());
                    assertEquals(150 * (i + 1), farm.getSprinkler().getPower());
                    assertEquals((i + 1)*(i + 1), farm.getSprinkler().getArea());
                    // upgrade sprinkler to check next level at next iteration of loop
                    farm.getSprinkler().upgrade();
                }
            }
        };

    }

    // test that trying to upgrade the sprinkler when it is already maxed out does not change its level
    @Test
    public void testMaxedOutSprinkler() {
        Farm farm = new Farm();
        // upgrade sprinkler to level 4
        farm.getSprinkler().upgrade();
        farm.getSprinkler().upgrade();
        farm.getSprinkler().upgrade();
        farm.getSprinkler().upgrade();

        UpgradeToolOutputBoundary outputBoundary = new UpgradeToolOutputBoundary() {
            @Override
            public void upgrade(String tool) {
                // check that sprinkler is at level 4
                assertEquals(4, farm.getSprinkler().getLevel());
                // ensure that upgrading the sprinkler past max level maintains its current level
                farm.getSprinkler().upgrade();
                assertEquals(4, farm.getSprinkler().getLevel());
            }
        };
    }
}
