package main.java.interface_adapter.farm;

import main.java.use_case.plant.PlantInputBoundary;
import main.java.use_case.save.SaveInputBoundary;

public class SaveController {
    private final SaveInputBoundary saveInteractor;

    public SaveController(SaveInputBoundary saveInteractor) {
        this.saveInteractor = saveInteractor;
    }


    public void save() {
        saveInteractor.save();
    }
}
