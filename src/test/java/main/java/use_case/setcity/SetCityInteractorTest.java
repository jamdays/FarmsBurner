package main.java.use_case.setcity;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import main.java.use_case.getweather.InvalidCityException;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class SetCityInteractorTest extends TestCase {
    @Test
    public void testSetCity() {
        Farm farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);

        SetCityOutputBoundary setCityOutputBoundary = new SetCityOutputBoundary() {
            @Override
            public void setCity(String city){
                assertEquals("Toronto", FarmSingleton.getInstance().getFarm().getCity());
            }

        };

        SetCityInteractor cityInteractor = new SetCityInteractor(setCityOutputBoundary);
        cityInteractor.execute("Toronto");

    }

}