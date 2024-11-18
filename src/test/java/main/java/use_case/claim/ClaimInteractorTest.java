package main.java.use_case.claim;

import main.java.entity.Farm;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClaimInteractorTest {

    final int r = 0;
    final int c = 0;

    @Test
    public void claimSuccess() {

        // Create a farm and claim a plot of land.
        Farm farm1 = new Farm();
        farm1.claim(r, c);

        ClaimOutputBoundary outputBoundary = new ClaimOutputBoundary() {

            @Override
            public void claim(int r, int c) {
                // Assert if the two farms are equal.
                assertTrue(farm1.getFarmLand()[r][c].isClaimed());
            }
        };

        ClaimInteractor interactor = new ClaimInteractor(outputBoundary);
        interactor.execute(r, c);
    }

    @Test
    public void landNotClaimed() {
        // Farm should initiate with no land claimed.
        Farm farm = new Farm();

        ClaimOutputBoundary outputBoundary = new ClaimOutputBoundary() {

            @Override
            public void claim(int r, int c) {
                // Assert that the farm starts with no FarmLand claimed.
                assertFalse(farm.getFarmLand()[r][c].isClaimed());
            }
        };

        ClaimInputBoundary interactor = new ClaimInteractor(outputBoundary);
        interactor.execute(r, c);
    }

}