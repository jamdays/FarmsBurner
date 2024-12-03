package main.java.use_case.fertilize;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.plant.PlantingException;
import main.java.use_case.fertilize.FertilizeException;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class FertilizeInteractorTest extends TestCase {

    @Test
    public void testExecute() throws PlantingException {
        Farm farm = new Farm();
        farm.setWeather(0, false, false, false, false, false, true, 15, "sunny", System.currentTimeMillis());
        farm.setBarnBucks(5000);
        farm.setPower(5000);
        farm.claim(1, 1);
        FarmSingleton.getInstance().setFarm(farm);
        FertilizeOutputBoundary fertilizeOutputBoundary = new FertilizeOutputBoundary() {
            @Override
            public void fertilize(int row, int col){
                assertTrue(FarmSingleton.getInstance().getFarm().getFarmLand()[row][col].isFertilized());
            }

        };

        FertilizeInteractor fertilizeInteractor = new FertilizeInteractor(fertilizeOutputBoundary);
        fertilizeInteractor.execute(1, 1);

    }

    public void testSucessMultiple() throws PlantingException {
        // Create a farm, claim land, fertilize land.
        Farm farm = new Farm();
        farm.setWeather(0, false, false, false, false, false, true, 15, "sunny", System.currentTimeMillis());
        farm.setBarnBucks(5000);
        farm.setPower(5000);
        farm.claim(1, 1);
        farm.claim(2, 2);
        farm.claim(1, 2);
        farm.claim(2, 1);

        FertilizeOutputBoundary outputBoundary = new FertilizeOutputBoundary() {

            @Override
            public void fertilize(int row, int col) {
                // Assert land is fertilized
                farm.fertilize(row, col);
                assertTrue(farm.getFarmLand()[row][col].isFertilized());
            }
        };

        FertilizeInteractor interactor = new FertilizeInteractor(outputBoundary);
        interactor.execute(0, 0);
        interactor.execute(1, 1);
        interactor.execute(0,  1);
        interactor.execute(1, 0);
    }

    @Test
    public void testSnowy() throws PlantingException, FertilizeException {
        Farm farm = new Farm();
        farm.setWeather(0, false, false, false, false, false, true, 15, "sunny", System.currentTimeMillis());
        farm.setBarnBucks(5000);
        farm.setPower(5000);
        FarmSingleton.getInstance().setFarm(farm);
        farm.claim(1, 1);
        farm.getFarmLand()[1][1].setIsSnowy(true);
        FertilizeOutputBoundary fertilizeOutputBoundary = new FertilizeOutputBoundary() {
            @Override
            public void fertilize(int row, int col){
                assertThrows(FertilizeException.class, () -> farm.fertilize(row, col));
            }

        };

        FertilizeInteractor fertilizeInteractor = new FertilizeInteractor(fertilizeOutputBoundary);
        fertilizeInteractor.execute(1, 1);

    }

    @Test
    public void testAlreadyFertilized() throws PlantingException, FertilizeException {
        Farm farm = new Farm();
        farm.setWeather(0, false, false, false, false, false, true, 15, "sunny", System.currentTimeMillis());
        farm.setBarnBucks(5000);
        farm.setPower(5000);
        FarmSingleton.getInstance().setFarm(farm);
        farm.claim(1, 1);
        farm.fertilize(1, 1);
        FertilizeOutputBoundary fertilizeOutputBoundary = new FertilizeOutputBoundary() {
            @Override
            public void fertilize(int row, int col){
                assertThrows(FertilizeException.class, () -> farm.fertilize(row, col));
            }

        };

        FertilizeInteractor fertilizeInteractor = new FertilizeInteractor(fertilizeOutputBoundary);
        fertilizeInteractor.execute(1, 1);

    }

}