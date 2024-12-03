package main.java.use_case.forecast;

import junit.framework.TestCase;
import main.java.data_access.OpenForecastAccessInterface;
import org.junit.Test;

import java.util.List;

public class ForecastInteractorTest extends TestCase {

    @Test
    public void testForecast() {

        ForecastOutputBoundary forecastOutputBoundary = new ForecastOutputBoundary() {
            @Override
            public void execute() {
                assertTrue(true);
            }
        };

        ForecastInteractor forecastInteractor = new ForecastInteractor(forecastOutputBoundary, new ForecastAccess());
        forecastInteractor.forecast();
    }

    public class ForecastAccess implements OpenForecastAccessInterface {

        @Override
        public List<String> fiveDayForecast(String city) {
            return List.of();
        }
    }
}
