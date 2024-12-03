package main.java.use_case.usetool;

import junit.framework.TestCase;
import main.java.data_access.OpenWeatherAccessInterface;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.plant.PlantingException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class UseToolInteractorTest extends TestCase {

    @Test
    public void testUseTool() throws PlantingException {
        Farm farm = new Farm();
        farm.claim(0, 0);
        farm.claim(0, 1);
        farm.claim(1, 0);
        farm.claim(1, 1);
        farm.plant(0, 0, System.currentTimeMillis());
        farm.plant(0, 1, System.currentTimeMillis());
        farm.plant(1, 0, System.currentTimeMillis());
        farm.plant(1, 1, System.currentTimeMillis());
        FarmSingleton.getInstance().setFarm(farm);

        UseToolOutputBoundary outputBoundary = new UseToolOutputBoundary() {
            @Override
            public void useTool(String tool, int rStart, int cStart, int amount, long time) {
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

        UseToolInteractor interactor = new UseToolInteractor(outputBoundary, openWeatherAccess);
        interactor.useTool("sprinkler", 0, 0);
        assertTrue(farm.getFarmLand()[0][0].isWet());
        assertTrue(farm.getFarmLand()[0][1].isWet());
        assertTrue(farm.getFarmLand()[1][0].isWet());
        assertTrue(farm.getFarmLand()[1][1].isWet());
    }

}