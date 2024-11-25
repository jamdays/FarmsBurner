package main.java.use_case.plant;

import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.plant.PlantInteractor;
import main.java.use_case.plant.PlantOutputBoundary;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class PlantInteractorTest {
    @Test
    public void testExecute() {

        Farm farm = new Farm();
        farm.claim(1, 1);
        FarmSingleton.getInstance().setFarm(farm);
        PlantOutputBoundary plantOB = new PlantOutputBoundary() {
            @Override
            public void addCrop(int r, int c){
                assertTrue(FarmSingleton.getInstance().getFarm().getFarmLand()[r][c].isPlanted());
            }

        };

        PlantInteractor plantInteractor = new PlantInteractor(plantOB);
        plantInteractor.execute(1, 1);

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

}
