package main.java.use_case.load;

import java.io.IOException;

import main.java.entity.FarmSingleton;
import main.java.use_case.save.DataAccessException;

/**
 * Load inteactor.
 */
public class LoadInteractor implements LoadInputBoundary {

    private final LoadDataAccessInterface loadDataAccessInterface;
    private final LoadOutputBoundary loadOutputBoundary;

    public LoadInteractor(LoadDataAccessInterface loadDataAccessInterface, LoadOutputBoundary loadOutputBoundary) {
        this.loadDataAccessInterface = loadDataAccessInterface;
        this.loadOutputBoundary = loadOutputBoundary;
    }

    /**
     * Executes the load use case.
     */
    @Override
    public void load() {
        // TODO MOVE THIS LATER
        loadOutputBoundary.loaded();
        try {
            FarmSingleton.getInstance().setFarm(loadDataAccessInterface.loadData());
        }
        catch (DataAccessException | IOException | ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
