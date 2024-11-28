package main.java.use_case.fertilize;

import main.java.entity.FarmSingleton;
import main.java.use_case.plant.PlantingException;

public class FertilizeInteractor implements FertilizeInputBoundary {
    private final FertilizeOutputBoundary outputBoundary;

    public FertilizeInteractor(FertilizeOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(int r, int c) {
        try{
            FarmSingleton.getInstance().getFarm().fertilize(r, c);
            outputBoundary.fertilize(r, c);
        }
        catch (FertilizeException e) {
            System.out.println(e.getMessage());
        }
//        FarmSingleton.getInstance().getFarm().fertilize(r, c);
//        outputBoundary.fertilize(r, c);

    }

}