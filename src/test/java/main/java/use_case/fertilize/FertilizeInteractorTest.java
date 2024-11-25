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
        farm.claim(1, 1);
        FarmSingleton.getInstance().setFarm(farm);
        FertilizeOutputBoundary fertilizeOutputBoundary = new FertilizeOutputBoundary() {
            @Override
            public void fertilize(int r, int c){
                assertTrue(FarmSingleton.getInstance().getFarm().getFarmLand()[r][c].isFertilized());
            }

        };

        FertilizeInteractor fertilizeInteractor = new FertilizeInteractor(fertilizeOutputBoundary);
        fertilizeInteractor.execute(1, 1);

    }

    @Test
    public void testSnowy() throws PlantingException, FertilizeException {
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);
        farm.claim(1, 1);
        farm.getFarmLand()[1][1].setIsSnowy(true);
        FertilizeOutputBoundary fertilizeOutputBoundary = new FertilizeOutputBoundary() {
            @Override
            public void fertilize(int r, int c){
                assertThrows(FertilizeException.class, () -> farm.fertilize(r, c));
            }

        };

        FertilizeInteractor fertilizeInteractor = new FertilizeInteractor(fertilizeOutputBoundary);
        fertilizeInteractor.execute(1, 1);

    }

    @Test
    public void testAlreadyFertilized() throws PlantingException, FertilizeException {
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);
        farm.claim(1, 1);
        farm.fertilize(1, 1);
        FertilizeOutputBoundary fertilizeOutputBoundary = new FertilizeOutputBoundary() {
            @Override
            public void fertilize(int r, int c){
                assertThrows(FertilizeException.class, () -> farm.fertilize(r, c));
            }

        };

        FertilizeInteractor fertilizeInteractor = new FertilizeInteractor(fertilizeOutputBoundary);
        fertilizeInteractor.execute(1, 1);

    }

}