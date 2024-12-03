package main.java.use_case.selectcrop;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.FarmSingleton;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SelectCropInteractorTest extends TestCase {
    private Farm farm;
    private SelectCropOutputBoundary outputBoundary;
    private SelectCropInteractor interactor;

    @Before
    public void setUp() {
        farm = new Farm();
        FarmSingleton.getInstance().setFarm(farm);
        outputBoundary = new SelectCropOutputBoundary() {
            @Override
            public void selectCrop(String crop) {
                // No-op for testing
            }
        };
        interactor = new SelectCropInteractor(outputBoundary);
    }

    @Test
    public void testSelectSnowberry() {
        interactor.selectCrop("snowberry");
        assertEquals("Snowberry", farm.getActiveCrop());
    }

    @Test
    public void testSelectRice() {
        interactor.selectCrop("rice");
        assertEquals("Rice", farm.getActiveCrop());
    }

    @Test
    public void testSelectWheat() {
        interactor.selectCrop("wheat");
        assertEquals("Wheat", farm.getActiveCrop());
    }

    @Test
    public void testSelectCorn() {
        interactor.selectCrop("corn");
        assertEquals("Corn", farm.getActiveCrop());
    }

}