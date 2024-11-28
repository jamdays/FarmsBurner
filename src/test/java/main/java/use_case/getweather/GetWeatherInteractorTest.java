package main.java.use_case.getweather;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GetWeatherInteractorTest extends TestCase {

    @Test
    public void testExecute() {

        GetWeatherOutputBoundary weatherOutputBoundary = new GetWeatherOutputBoundary() {
            @Override
            public void getWeather(){

            }

        };

        GetWeatherInteractor weatherInteractor = new GetWeatherInteractor(weatherOutputBoundary);
        weatherInteractor.execute();

    }

}