package main.java.use_case.getbarnbucks;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;

public class GetBarnBucksInteractorTest extends TestCase {

    public void testGetBarnBucks() {
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);

        GetBarnBucksOutputBoundary outputBoundary = new GetBarnBucksOutputBoundary() {
            @Override
            public void bucks(int bucks) {
                assertEquals(0, bucks);
            }
        };

        GetBarnBucksInteractor getBarnBucksInteractor = new GetBarnBucksInteractor(outputBoundary);
        getBarnBucksInteractor.getBarnBucks();
    }

}