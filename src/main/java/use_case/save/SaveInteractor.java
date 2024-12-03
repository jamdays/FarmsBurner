package main.java.use_case.save;

import java.io.IOException;
import java.util.List;

import main.java.data_access.OpenWeatherAccessInterface;
import main.java.entity.FarmSingleton;

/**
 * Save interactor.
 */
public class SaveInteractor implements SaveInputBoundary {

    private final SaveDataAccessInterface saveDataAccessInterface;
    private final SaveOutputBoundary saveOutputBoundary;
    private final OpenWeatherAccessInterface weatherDataAccessObject;

    public SaveInteractor(SaveDataAccessInterface saveDataAccessInterface, SaveOutputBoundary saveOutputBoundary,
                          OpenWeatherAccessInterface weatherDataAccessObject) {
        this.saveDataAccessInterface = saveDataAccessInterface;
        this.saveOutputBoundary = saveOutputBoundary;
        this.weatherDataAccessObject = weatherDataAccessObject;
    }

    /**
     * Executes the save use case.
     */
    @Override
    public void save() {
        try {
            List<Long> times = weatherDataAccessObject.getTimesForCity(FarmSingleton.getInstance().getFarm().getCity());
            FarmSingleton.getInstance().getFarm().setLogOutTime(times.get(0));
            saveDataAccessInterface.saveData(FarmSingleton.getInstance().getFarm());
            saveOutputBoundary.saved();
        }
        catch (main.java.use_case.load.DataAccessException | IOException
               | main.java.use_case.save.DataAccessException exception) {
            throw new RuntimeException(exception);
        }
    }
}
