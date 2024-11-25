package main.java.use_case.claim;

import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.claim.ClaimInteractor;
import main.java.use_case.claim.ClaimOutputBoundary;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ClaimInteractorTest {

    @Test
    public void testExecute() {

        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);
        ClaimOutputBoundary claimOB = new ClaimOutputBoundary() {
            @Override
            public void claim(int r, int c){
                assertTrue(FarmSingleton.getInstance().getFarm().getFarmLand()[r][c].isClaimed());
            }

        };

        ClaimInteractor claimInteractor = new ClaimInteractor(claimOB);
        claimInteractor.execute(1, 1);

    }
}
