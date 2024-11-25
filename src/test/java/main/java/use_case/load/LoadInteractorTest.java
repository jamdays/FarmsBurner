package main.java.use_case.load;

import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.load.LoadDataAccessInterface;
import main.java.use_case.load.LoadInteractor;
import main.java.use_case.load.LoadOutputBoundary;
import main.java.use_case.plant.PlantingException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoadInteractorTest {
    @Test
    public void testLoad() throws PlantingException {

        Farm testfarm = new Farm();
        testfarm.claim(1, 1);
        testfarm.claim(2, 2);
        testfarm.claim(3, 1);
        testfarm.plant(1, 1);
        LoadDataAccessInterface loadDAO = new LoadDataAccessInterface() {


            @Override
            public Farm loadData() {
                return testfarm;
            }
        };

        LoadOutputBoundary loadOB = new LoadOutputBoundary() {
            @Override
            public void loaded() {
            }

        };
        LoadInteractor loadInteractor = new LoadInteractor(loadDAO, loadOB);

        loadInteractor.load();

        assertEquals(FarmSingleton.getInstance().getFarm(), testfarm);


    }
}
