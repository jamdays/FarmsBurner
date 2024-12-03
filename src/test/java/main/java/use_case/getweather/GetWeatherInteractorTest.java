package main.java.use_case.getweather;

import junit.framework.TestCase;
import main.java.data_access.OpenWeatherAccessInterface;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import org.junit.Test;

import java.util.List;


public class GetWeatherInteractorTest extends TestCase {

    @Test
    public void testGetWeather() {
        Farm farm = new Farm();
        farm.setWeather(0, false, false, false, false, false, true, 15, "sunny", System.currentTimeMillis());
        farm.setCity("Toronto");
        FarmSingleton.getInstance().setFarm(farm);

        GetWeatherOutputBoundary getWeatherOutputBoundary = new GetWeatherOutputBoundary() {
            @Override
            public void weather(String condition, int day, long time, int temp) {
                assertTrue(true);
            }
        };

        GetWeatherInteractor getWeatherInteractor = new GetWeatherInteractor(getWeatherOutputBoundary, new WeatherAccess());
        getWeatherInteractor.execute();
    }

    public class WeatherAccess implements OpenWeatherAccessInterface {

        @Override
        public List<String> currentDisplayInfoForCity(String city) {
            return List.of("a", "b", "c");
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
            return List.of(0L, 0L, 0L);
        }

        @Override
        public String jsonforcity(String city) {
            return "";
        }
    }

}