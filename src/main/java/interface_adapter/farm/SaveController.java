package main.java.interface_adapter.farm;

import main.java.use_case.save.SaveInputBoundary;

/**
 * Save controller.
 */
public class SaveController {
    private final SaveInputBoundary saveInteractor;

    public SaveController(SaveInputBoundary saveInteractor) {
        this.saveInteractor = saveInteractor;
    }

    /**
     * Save.
     */
    public void save() {
        saveInteractor.save();
    }
}
