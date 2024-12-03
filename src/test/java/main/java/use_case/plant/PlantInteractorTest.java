package main.java.use_case.plant;

import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.plant.PlantInteractor;
import main.java.use_case.plant.PlantOutputBoundary;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class PlantInteractorTest {
    /*
    @Test
    public void testPlantSuccessUnfertilized() throws PlantingException {
        // Create a farm and claim then plant on a plot of land.
        Farm farm = new Farm();
        farm.claim(1, 1);
        farm.plant(1, 1);

        PlantOutputBoundary outputBoundary = new PlantOutputBoundary() {

            @Override
            public void addCrop(int r, int c) {
                // Assert land at [r][c] is planted.
                assertTrue(farm.getFarmLand()[r][c].isPlanted());
            }
        };

        PlantInteractor interactor = new PlantInteractor(outputBoundary);
        interactor.execute(1, 1);
    }

    @Test
    public void testPlantSuccessFertilized() throws PlantingException {
        // Create a farm and claim then plant on a plot of land.
        Farm farm = new Farm();
        farm.claim(1, 1);
        farm.fertilize(1, 1);
        farm.plant(1, 1);

        PlantOutputBoundary outputBoundary = new PlantOutputBoundary() {

            @Override
            public void addCrop(int r, int c) {
                // Assert land at [r][c] is planted.
                assertTrue(farm.getFarmLand()[r][c].isPlanted());
            }
        };
    }


    @Test
    public void testNotClaimed() throws PlantingException{
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);
        PlantOutputBoundary plantOB = new PlantOutputBoundary() {
            @Override
            public void addCrop(int r, int c){
                assertThrows(PlantingException.class, () -> farm.plant(r, c));
            }

        };

        PlantInteractor plantInteractor = new PlantInteractor(plantOB);
        plantInteractor.execute(1, 1);
    }

    @Test
    public void testPlantAlreadyThere() throws PlantingException{
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);
        farm.claim(1, 1);
        farm.plant(1, 1);
        PlantOutputBoundary plantOB = new PlantOutputBoundary() {
            @Override
            public void addCrop(int r, int c){
                assertThrows(PlantingException.class, () -> farm.plant(r, c));
            }

        };

        PlantInteractor plantInteractor = new PlantInteractor(plantOB);
        plantInteractor.execute(1, 1);
    }

    @Test
    public void testPlantSuccessMultiple() throws PlantingException {
        // Create a farm and claim then plant on a plot of land.
        Farm farm = new Farm();
        farm.claim(1, 1);
        farm.claim(2, 2);
        farm.claim(1, 2);
        farm.claim(2, 1);
        farm.plant(1, 1);
        farm.plant(2, 2);
        farm.plant(1, 2);
        farm.plant(2, 1);

        PlantOutputBoundary outputBoundary = new PlantOutputBoundary() {

            @Override
            public void addCrop(int r, int c) {
                // Assert land at [r][c] is planted.
                assertTrue(farm.getFarmLand()[r][c].isPlanted());
                assertTrue(farm.getFarmLand()[1][1].isPlanted());
                assertTrue(farm.getFarmLand()[0][1].isPlanted());
                assertTrue(farm.getFarmLand()[1][0].isPlanted());
            }
        };

        PlantInteractor interactor = new PlantInteractor(outputBoundary);
        interactor.execute(0, 0);
        interactor.execute(1, 1);
        interactor.execute(0,  1);
        interactor.execute(1, 0);
    }

    @Test
    public void testIsSnowy() throws PlantingException{
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);
        farm.claim(1, 1);
        farm.getFarmLand()[1][1].setIsSnowy(true);
        PlantOutputBoundary plantOB = new PlantOutputBoundary() {
            @Override
            public void addCrop(int r, int c){
                assertThrows(PlantingException.class, () -> farm.plant(r, c));
            }

        };

        PlantInteractor plantInteractor = new PlantInteractor(plantOB);
        plantInteractor.execute(1, 1);
    }

     */

}
