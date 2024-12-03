package main.java.use_case.getweather;

import junit.framework.TestCase;
import main.java.data_access.OpenWeatherAccess;
import main.java.data_access.OpenWeatherAccessInterface;
import main.java.use_case.forecast.ForecastInteractor;
import main.java.use_case.forecast.ForecastOutputBoundary;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GetWeatherInteractorTest extends TestCase {

    @Test
    public void testGetWeather() {

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
            return List.of();
        }

        @Override
        public String jsonforcity(String city) {
            return "";
        }
    }

}