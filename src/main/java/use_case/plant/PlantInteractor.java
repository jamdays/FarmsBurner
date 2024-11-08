package main.java.use_case.plant;

public class PlantInteractor implements PlantInputBoundary{
    private final PlantOutputBoundary outputBoundary;

    public PlantInteractor(PlantOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }
    @Override
    public void execute() {
        outputBoundary.addCrop();
    }
}

