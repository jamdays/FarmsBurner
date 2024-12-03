package main.java.use_case.setcrop;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import org.junit.Before;
import org.junit.Test;

public class SetCropInteractorTest extends TestCase {
    private Farm farm;
    private SetCropOutputBoundary outputBoundary;
    private SetCropInteractor interactor;

    @Before
    public void setUp() {
        farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);
        SetCropOutputBoundary outputBoundary = new SetCropOutputBoundary() {
            @Override
            public void setCrop(String crop) {
            }
        };
        interactor = new SetCropInteractor(outputBoundary);
    }

    @Test
    public void testSetSnowberry() {
        interactor.setCrop("snowberry");
        assertEquals("snowberry", farm.getActiveCrop());
    }

    @Test
    public void testSetRice() {
        interactor.setCrop("rice");
        assertEquals("rice", farm.getActiveCrop());
    }

    @Test
    public void testSetWheat() {
        interactor.setCrop("wheat");
        assertEquals("wheat", farm.getActiveCrop());
    }

    @Test
    public void testSetCorn() {
        interactor.setCrop("corn");
        assertEquals("corn", farm.getActiveCrop());
    }
}