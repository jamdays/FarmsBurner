package main.java.use_case.forecast;

import junit.framework.TestCase;
import main.java.data_access.OpenForecastAccess;
import main.java.data_access.OpenForecastAccessInterface;
import main.java.data_access.OpenWeatherAccessInterface;

import java.util.List;

public class ForecastInteractorTest extends TestCase {

        public void testForecast() {
            ForecastOutputBoundary outputBoundary = new ForecastOutputBoundary() {
                @Override
                public void execute() {
                }
            };

            OpenForecastAccessInterface openForecastAccessInterface = new OpenForecastAccessInterface() {
                @Override
                public List<String> fiveDayForecast(String city) {
                    return List.of();
                }
            };

            ForecastInteractor forecastInteractor = new ForecastInteractor(outputBoundary, openForecastAccessInterface);
            forecastInteractor.forecast();
        }

}