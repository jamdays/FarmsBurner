package main.java.use_case.plant;

import main.java.data_access.OpenWeatherAccess;
import main.java.data_access.OpenWeatherAccessInterface;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.plant.PlantInteractor;
import main.java.use_case.plant.PlantOutputBoundary;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class PlantInteractorTest {
    private PlantInteractor interactor;
    private OpenWeatherAccessInterface openWeatherAccess;
    private PlantOutputBoundary outputBoundary;
    private Properties props;
    private String apiKey;

    @Before
    public void setUp() {
        props = new Properties();
        try (var inputStream = Files.newInputStream(Paths.get(".env"))) {
            props.load(inputStream);
            apiKey = props.getProperty("WAK");
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }

        openWeatherAccess = new OpenWeatherAccess(apiKey); // Use real implementation
        PlantOutputBoundary outputBoundary = new PlantOutputBoundary() {
            @Override
            public void addCrop(int row, int col, long time) {

            }
        };
        interactor = new PlantInteractor(outputBoundary, openWeatherAccess);

        Farm farm = new Farm();
        farm.setWeather(0, false, false, false, false, false, true, 15, "sunny", System.currentTimeMillis());
        farm.claim(1, 1);
        FarmSingleton.getInstance().setFarm(farm);
    }

    @Test
    public void testPlantSuccess() {
        interactor.execute(1, 1);
        assertTrue(FarmSingleton.getInstance().getFarm().getFarmLand()[1][1].isPlanted());
    }

    @Test
    public void testPlantFail() {
        interactor.execute(2,2);
    }

    /*
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
