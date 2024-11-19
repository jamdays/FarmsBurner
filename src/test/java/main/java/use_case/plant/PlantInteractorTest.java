package main.java.use_case.plant;

import junit.framework.TestCase;
import main.java.entity.Farm;
import main.java.entity.Land;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class PlantInteractorTest extends TestCase {
    final int r = 0;
    final int c = 0;

    public void testPlantSuccessUnfertilized() {
        // Create a farm and claim then plant on a plot of land.
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.plant(r, c);

        PlantOutputBoundary outputBoundary = new PlantOutputBoundary() {

            @Override
            public void addCrop(int r, int c) {
                // Assert land at [r][c] is planted.
                assertTrue(farm.getFarmLand()[r][c].isPlanted());
            }
        };

        PlantInteractor interactor = new PlantInteractor(outputBoundary);
        interactor.execute(r, c);
    }

    public void testPlantSuccessFertilized() {
        // Create a farm and claim then plant on a plot of land.
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.fertilize(r, c);
        farm.plant(r, c);

        PlantOutputBoundary outputBoundary = new PlantOutputBoundary() {

            @Override
            public void addCrop(int r, int c) {
                // Assert land at [r][c] is planted.
                assertTrue(farm.getFarmLand()[r][c].isPlanted());
            }
        };

        PlantInteractor interactor = new PlantInteractor(outputBoundary);
        interactor.execute(r, c);
    }

    public void testPlantSuccessMultiple() {
        // Create a farm and claim then plant on a plot of land.
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.claim(r + 1, c + 1);
        farm.claim(r, c + 1);
        farm.claim(r + 1, c);
        farm.plant(r, c);
        farm.plant(r + 1, c + 1);
        farm.plant(r, c + 1);
        farm.plant(r + 1, c);

        PlantOutputBoundary outputBoundary = new PlantOutputBoundary() {

            @Override
            public void addCrop(int r, int c) {
                // Assert land at [r][c] is planted.
                assertTrue(farm.getFarmLand()[r][c].isPlanted());
                assertTrue(farm.getFarmLand()[1][1].isPlanted());
                assertTrue(farm.getFarmLand()[0][1].isPlanted());
                assertTrue(farm.getFarmLand()[1][0].isPlanted());
            }
        };

        PlantInteractor interactor = new PlantInteractor(outputBoundary);
        interactor.execute(0, 0);
        interactor.execute(1, 1);
        interactor.execute(0,  1);
        interactor.execute(1, 0);
    }

    public void testPlantFailUnclaimedLand() {
        // Create a farm, then plant on a plot of land without claiming.
        Farm farm = new Farm();
        farm.plant(r, c);

        PlantOutputBoundary outputBoundary = new PlantOutputBoundary() {

            @Override
            public void addCrop(int r, int c) {
                // Assert planting fails if land is not claimed.
                assertFalse(farm.getFarmLand()[r][c].isPlanted());
            }
        };

        PlantInteractor interactor = new PlantInteractor(outputBoundary);
        interactor.execute(r, c);
    }

    public void testPlantFailSnowy() {
        // Create a farm, then plant on a plot of land and set weather to be snowy.
        Farm farm = new Farm();
        farm.getFarmLand()[r][c].setIsSnowy(true);
        farm.plant(r, c);

        PlantOutputBoundary outputBoundary = new PlantOutputBoundary() {

            @Override
            public void addCrop(int r, int c) {
                // Assert planting fails if land is snowy.
                assertFalse(farm.getFarmLand()[r][c].isPlanted());
            }
        };

        PlantInteractor interactor = new PlantInteractor(outputBoundary);
        interactor.execute(r, c);
    }

    public void testPlantTwiceFail() {
        // Create a farm, then plant on a plot of land twice
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.plant(r, c);
        farm.plant(r, c);

        PlantOutputBoundary outputBoundary = new PlantOutputBoundary() {

            @Override
            public void addCrop(int r, int c) {
                // Assert land is still planted but line is printed that you can't print twice.
                assertTrue(farm.getFarmLand()[r][c].isPlanted());
            }
        };

        PlantInteractor interactor = new PlantInteractor(outputBoundary);
        interactor.execute(r, c);
    }
}