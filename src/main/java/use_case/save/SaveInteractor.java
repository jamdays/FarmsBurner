package main.java.use_case.save;

import main.java.entity.FarmSingleton;

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
        }
        catch (DataAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
