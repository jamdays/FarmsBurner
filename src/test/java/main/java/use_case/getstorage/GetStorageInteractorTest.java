package main.java.use_case.getstorage;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;

import java.util.List;

public class GetStorageInteractorTest extends TestCase {

    public void testGetStorage() {
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);

        GetStorageOutputBoundary outputBoundary = new GetStorageOutputBoundary() {
            @Override
            public void getStorage(List<Integer> storage) {
                assertEquals(0, storage.size());
            }
        };

        GetStorageInteractor getStorageInteractor = new GetStorageInteractor(outputBoundary);
        getStorageInteractor.getStorage();
    }

}