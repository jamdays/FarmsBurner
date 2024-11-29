package main.java.use_case.sell;

import main.java.entity.Crop;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.entity.Storage;
import org.junit.Test;
import use_case.sell.SellInteractor;
import use_case.sell.SellOutputBoundary;

import static org.junit.Assert.assertEquals;

public class SellInteractorTest {

    // test that selling a regular crop increases BarnBucks by 3
    @Test
    public void testBarnBucksRegularCrop() {
        Farm farm = new Farm();
        Crop regularCrop = new Crop(5, true, 3);
        farm.getStorage().getCrops().add(regularCrop);

        SellOutputBoundary outputBoundary = new SellOutputBoundary() {
            @Override
            public void sell(int quantity) {
                // ensure barnbucks value is correct before
                assertEquals(0, farm.getBarnBucks());
                // sell crop
                farm.sell(1);
                // ensure barnbucks value is correct after
                assertEquals(3, farm.getBarnBucks());
            }
        };

        // interactor stuff
        SellInteractor interactor = new SellInteractor(outputBoundary);
        interactor.execute(1);
    }

    // test that selling a fertilized crop increases BarnBucks by 5
    @Test
    public void testBarnBucksHighValueCrop() {
        Farm farm = new Farm();
        Crop highValueCrop = new Crop(5, true, 5);
        farm.getStorage().getCrops().add(highValueCrop);

        SellOutputBoundary outputBoundary = new SellOutputBoundary() {
            @Override
            public void sell(int quantity) {
                // ensure barnbucks value is correct before
                assertEquals(0, farm.getBarnBucks());
                // sell crop
                farm.sell(1);
                // ensure barnbucks value is correct after
                assertEquals(5, farm.getBarnBucks());
            }
        };

        // interactor stuff
        SellInteractor interactor = new SellInteractor(outputBoundary);
        interactor.execute(1);
    }

    // test that selling crops updates the storage

    @Test
    public void testStorageUpdate() {
        Farm farm = new Farm();
        Crop regularCrop = new Crop(5, true, 3);
        Crop highValueCrop = new Crop(5, true, 5);
        farm.getStorage().getCrops().add(regularCrop);
        farm.getStorage().getCrops().add(highValueCrop);

        SellOutputBoundary outputBoundary = new SellOutputBoundary() {
            @Override
            public void sell(int quantity) {
                // ensure storage has the crops
                assertEquals(2, farm.getStorage().getCrops().size());
                // sell both crops
                farm.sell(2);
                // ensure storage is empty
                assertEquals(0, farm.getStorage().getCrops().size());
            }
        };

        // interactor stuff
        SellInteractor interactor = new SellInteractor(outputBoundary);
        interactor.execute(2);
    }

}
