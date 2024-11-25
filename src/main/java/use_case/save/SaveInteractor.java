package main.java.use_case.save;

import main.java.entity.FarmSingleton;

import java.io.IOException;

public class SaveInteractor implements SaveInputBoundary{

    private final SaveDataAccessInterface saveDataAccessInterface;
    private final SaveOutputBoundary saveOutputBoundary;

    public SaveInteractor(SaveDataAccessInterface saveDataAccessInterface, SaveOutputBoundary saveOutputBoundary) {
        this.saveDataAccessInterface = saveDataAccessInterface;
        this.saveOutputBoundary = saveOutputBoundary;
    }

    /**
     * Executes the save use case
     */
    @Override
    public void save(){
        try {
            saveDataAccessInterface.saveData(FarmSingleton.getInstance().getFarm());
            saveOutputBoundary.saved();
        } catch (main.java.use_case.load.DataAccessException | IOException | main.java.use_case.save.DataAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
