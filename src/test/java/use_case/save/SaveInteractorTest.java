package use_case.save;

import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.save.SaveDataAccessInterface;
import main.java.use_case.save.SaveInteractor;
import main.java.use_case.save.SaveOutputBoundary;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SaveInteractorTest {
    @Test
    public void testSave() {

        Farm farm = new Farm();
        farm.claim(1, 1);
        farm.claim(2, 2);
        farm.claim(3, 1);
        farm.plant(1, 1);
        FarmSingleton.getInstance().setFarm(farm);
        SaveDataAccessInterface saveDAO = new SaveDataAccessInterface() {


            @Override
            public void saveData(Farm farm) {
                assertTrue(farm.getFarmLand()[1][1].isClaimed());
                assertTrue(farm.getFarmLand()[2][2].isClaimed());
                assertTrue(farm.getFarmLand()[3][1].isClaimed());
                assertTrue(farm.getFarmLand()[1][1].isPlanted());
            }
        };

        SaveOutputBoundary saveOB = new SaveOutputBoundary() {
            @Override
            public void saved() {
            }

        };
        SaveInteractor saveInteractor = new SaveInteractor(saveDAO, saveOB);

        saveInteractor.save();


    }
}
