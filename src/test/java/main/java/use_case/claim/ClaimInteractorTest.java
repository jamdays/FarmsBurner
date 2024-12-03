package main.java.use_case.claim;

import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.claim.ClaimInteractor;
import main.java.use_case.claim.ClaimOutputBoundary;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClaimInteractorTest {

    int r = 0;
    int c = 0;

    @Test
    public void claimSuccess() {

        // Create a farm and claim a plot of land.
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);
        farm.setWeather(0, false, false, false, false, false, true, 15, "sunny", System.currentTimeMillis());

        ClaimOutputBoundary outputBoundary = new ClaimOutputBoundary() {

            @Override
            public void claim(int row, int col) {
                FarmSingleton.getInstance().getFarm().getFarmLand()[row][col].setClaimed(true);
            }
        };

        ClaimInteractor interactor = new ClaimInteractor(outputBoundary);
        interactor.execute(r, c);

        assertTrue(FarmSingleton.getInstance().getFarm().getFarmLand()[r][c].isClaimed());
    }

    @Test
    public void landNotClaimed() {
        // Farm should initiate with no land claimed.
        Farm farm = new Farm();

        assertFalse(farm.getFarmLand()[r][c].isClaimed());
    }
}