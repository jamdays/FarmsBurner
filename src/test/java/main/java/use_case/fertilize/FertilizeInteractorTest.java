package main.java.use_case.fertilize;

import junit.framework.TestCase;
import main.java.entity.Farm;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FertilizeInteractorTest extends TestCase {
    final int r = 0;
    final int c = 0;

    public void testSucess() {
        // Create a farm, claim land, fertilize land.
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.plant(r, c);
        farm.fertilize(r, c);

        FertilizeOutputBoundary outputBoundary = new FertilizeOutputBoundary() {

            @Override
            public void fertilize(int r, int c) {
                // Assert land is fertilized
                assertTrue(farm.getFarmLand()[r][c].isFertilized());
            }
        };

        FertilizeInteractor interactor = new FertilizeInteractor(outputBoundary);
        interactor.execute(r, c);
    }

    public void testSucessMultiple() {
        // Create a farm, claim land, fertilize land.
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.claim(r + 1, c + 1);
        farm.claim(r, c + 1);
        farm.claim(r + 1, c);
        farm.plant(r, c);
        farm.plant(r + 1, c + 1);
        farm.plant(r, c + 1);
        farm.plant(r + 1, c);
        farm.fertilize(r, c);
        farm.fertilize(r + 1, c + 1);
        farm.fertilize(r, c + 1);
        farm.fertilize(r + 1, c);

        FertilizeOutputBoundary outputBoundary = new FertilizeOutputBoundary() {

            @Override
            public void fertilize(int r, int c) {
                // Assert land is fertilized
                assertTrue(farm.getFarmLand()[r][c].isFertilized());
                assertTrue(farm.getFarmLand()[1][0].isFertilized());
                assertTrue(farm.getFarmLand()[0][1].isFertilized());
                assertTrue(farm.getFarmLand()[1][1].isFertilized());
            }
        };

        FertilizeInteractor interactor = new FertilizeInteractor(outputBoundary);
        interactor.execute(0, 0);
        interactor.execute(1, 1);
        interactor.execute(0,  1);
        interactor.execute(1, 0);
    }


    public void testFailUnclaimedLand() {
        // Create a farm, fertilize land.
        Farm farm = new Farm();
        farm.fertilize(r, c);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FertilizeOutputBoundary outputBoundary = new FertilizeOutputBoundary() {

            @Override
            public void fertilize(int r, int c) {
                // Assert land is not fertilized.
                assertFalse(farm.getFarmLand()[r][c].isFertilized());
                String expectedLine = "Land is not claimed";
                assertTrue(outContent.toString().contains(expectedLine));
                System.setOut(System.out);
            }
        };

        FertilizeInteractor interactor = new FertilizeInteractor(outputBoundary);
        interactor.execute(r, c);
    }

    public void testFailAlreadyFertilized() {
        // Create a farm, fertilize land.
        Farm farm = new Farm();
        farm.claim(r, c);
        farm.plant(r, c);
        farm.fertilize(r, c);
        farm.fertilize(r, c);

        FertilizeOutputBoundary outputBoundary = new FertilizeOutputBoundary() {

            @Override
            public void fertilize(int r, int c) {
                // Assert land is already fertilized.
                assertTrue(farm.getFarmLand()[r][c].isFertilized());
                }
        };

        FertilizeInteractor interactor = new FertilizeInteractor(outputBoundary);
        interactor.execute(r, c);

    }
}