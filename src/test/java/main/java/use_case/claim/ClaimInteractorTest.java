package main.java.use_case.claim;

import main.java.entity.Farm;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClaimInteractorTest {

    int r = 0;
    int c = 0;

    @Test
    public void claimSuccess() {

        // Create a farm and claim a plot of land.
        Farm farm1 = new Farm();
        farm1.claim(r, c);

        ClaimOutputBoundary outputBoundary = new ClaimOutputBoundary() {

            @Override
            public void claim(int r, int c) {
                // Assert if land is claimed.
                assertTrue(farm1.getFarmLand()[r][c].isClaimed());
            }
        };

        ClaimInteractor interactor = new ClaimInteractor(outputBoundary);
        interactor.execute(r, c);
    }

    @Test
    public void claimSuccessMultiple() {

        // Create a farm and claim a plot of land.
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.claim(r + 1, c + 1);
        farm.claim(r, c + 1);
        farm.claim(r + 1, c);

        ClaimOutputBoundary outputBoundary = new ClaimOutputBoundary() {

            @Override
            public void claim(int r, int c) {
                // Assert if multiple pieces of land is claimed.
                assertTrue(farm.getFarmLand()[0][0].isClaimed());
                assertTrue(farm.getFarmLand()[1][1].isClaimed());
                assertTrue(farm.getFarmLand()[0][1].isClaimed());
                assertTrue(farm.getFarmLand()[1][0].isClaimed());
            }
        };

        ClaimInteractor interactor = new ClaimInteractor(outputBoundary);
        interactor.execute(0, 0);
        interactor.execute(1, 1);
        interactor.execute(0,  1);
        interactor.execute(1, 0);
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

    // TODO: implement testFailAlreadyClaimed

}