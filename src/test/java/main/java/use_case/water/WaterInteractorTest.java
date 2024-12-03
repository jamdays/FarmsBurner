package main.java.use_case.water;

import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.plant.PlantingException;
import main.java.use_case.water.WaterInteractor;
import main.java.use_case.water.WaterOutputBoundary;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WaterInteractorTest {

    /*
    @Test
    public void testExecuteWithoutPlant() {

        Farm farm = new Farm();
        farm.claim(1, 1);
        FarmSingleton.getInstance().setFarm(farm);
        WaterOutputBoundary waterOB = new WaterOutputBoundary() {
            @Override
            public void water(int r, int c){
                assertTrue(!FarmSingleton.getInstance().getFarm().getFarmLand()[r][c].isWet());
            }

        };

        WaterInteractor waterInteractor = new WaterInteractor(waterOB);
        waterInteractor.execute(1, 1);

    }
    @Test
    public void testExecuteWithPlant() throws PlantingException {

        Farm farm = new Farm();
        farm.claim(1, 1);
        farm.plant(1, 1);
        FarmSingleton.getInstance().setFarm(farm);
        WaterOutputBoundary waterOB = new WaterOutputBoundary() {
            @Override
            public void water(int r, int c){
                assertTrue(FarmSingleton.getInstance().getFarm().getFarmLand()[r][c].isWet());
                assertTrue(FarmSingleton.getInstance().getFarm().getFarmLand()[r][c].getCrop().isWatered());
            }

        };

        WaterInteractor waterInteractor = new WaterInteractor(waterOB);
        waterInteractor.execute(1, 1);



    }

     */
}
