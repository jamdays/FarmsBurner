package main.java.use_case.water;

import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.plant.PlantingException;
import main.java.use_case.water.WaterInteractor;
import main.java.use_case.water.WaterOutputBoundary;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WaterInteractorTest {


    @Test
    public void testExecuteWithoutPlant() {

        Farm farm = new Farm();
        farm.claim(1, 1);
        FarmSingleton.getInstance().setFarm(farm);
        WaterOutputBoundary waterOB = new WaterOutputBoundary() {
            @Override
            public void water(int row, int col){
                assertTrue(!FarmSingleton.getInstance().getFarm().getFarmLand()[row][col].isWet());
            }

        };

        WaterInteractor waterInteractor = new WaterInteractor(waterOB);
        waterInteractor.execute(1, 1);

    }
    @Test
    public void testExecuteWithPlant() throws PlantingException {

        Farm farm = new Farm();
        farm.setWeather(0, false, false, false, false, false, true, 15, "sunny", System.currentTimeMillis());
        farm.claim(1, 1);
        farm.plant(1, 1, System.currentTimeMillis());
        FarmSingleton.getInstance().setFarm(farm);
        WaterOutputBoundary waterOB = new WaterOutputBoundary() {
            @Override
            public void water(int row, int col){
                assertTrue(FarmSingleton.getInstance().getFarm().getFarmLand()[row][col].isWet());
                assertTrue(FarmSingleton.getInstance().getFarm().getFarmLand()[row][col].getCrop().isWatered());
            }

        };

        WaterInteractor waterInteractor = new WaterInteractor(waterOB);
        waterInteractor.execute(1, 1);



    }


}
