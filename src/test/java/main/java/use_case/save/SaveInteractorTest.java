package main.java.use_case.save;

import main.java.data_access.OpenWeatherAccessInterface;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.plant.PlantingException;
import main.java.use_case.save.SaveDataAccessInterface;
import main.java.use_case.save.SaveInteractor;
import main.java.use_case.save.SaveOutputBoundary;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class SaveInteractorTest {

    @Test
    public void testSave() throws PlantingException {

        Farm farm = new Farm();
        farm.claim(1, 1);
        farm.claim(2, 2);
        farm.claim(3, 1);
        farm.plant(1, 1, System.currentTimeMillis());
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

        OpenWeatherAccessInterface openWeatherAccess = new OpenWeatherAccessInterface() {
            @Override
            public List<String> currentDisplayInfoForCity(String city) {
                return List.of();
            }

            @Override
            public String currentWeatherTypeForCity(String city) {
                return "";
            }

            @Override
            public String forecastInfoForCity(String city) {
                return "";
            }

            @Override
            public List<Long> getTimesForCity(String city) {
                return Arrays.asList(0L);
            }

            @Override
            public String jsonforcity(String city) {
                return "";
            }

            /**
             * @param city 
             * @return
             */
            @Override
            public List<String> fiveDayForecast(String city) {
                return List.of();
            }


        };

        SaveInteractor saveInteractor = new SaveInteractor(saveDAO, saveOB, openWeatherAccess);

        saveInteractor.save();

    }

}
