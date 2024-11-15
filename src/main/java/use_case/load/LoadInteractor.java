package main.java.use_case.load;

import main.java.entity.FarmSingleton;
import main.java.use_case.save.DataAccessException;
import main.java.use_case.save.SaveDataAccessInterface;
import main.java.use_case.save.SaveInputBoundary;
import main.java.use_case.save.SaveOutputBoundary;

import java.io.IOException;

public class LoadInteractor implements LoadInputBoundary {

    private final LoadDataAccessInterface loadDataAccessInterface;
    private final LoadOutputBoundary loadOutputBoundary;

    public LoadInteractor(LoadDataAccessInterface loadDataAccessInterface, LoadOutputBoundary loadOutputBoundary) {
        this.loadDataAccessInterface = loadDataAccessInterface;
        this.loadOutputBoundary = loadOutputBoundary;
    }

    /**
     * Executes the load use case
     */
    @Override
    public void load(){
        try {
            FarmSingleton.getInstance().setFarm(loadDataAccessInterface.loadData());
            loadOutputBoundary.loaded();
        }
        catch (DataAccessException | IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
