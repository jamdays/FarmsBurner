package main.java.use_case.save;

import main.java.data_access.OpenWeatherAccessInterface;
import main.java.entity.FarmSingleton;
import main.java.view.FarmLabel;

import java.io.IOException;
import java.util.List;

public class SaveInteractor implements SaveInputBoundary{

    private final SaveDataAccessInterface saveDataAccessInterface;
    private final SaveOutputBoundary saveOutputBoundary;
    private final OpenWeatherAccessInterface weatherDAO;

    public SaveInteractor(SaveDataAccessInterface saveDataAccessInterface, SaveOutputBoundary saveOutputBoundary, OpenWeatherAccessInterface weatherDAO) {
        this.saveDataAccessInterface = saveDataAccessInterface;
        this.saveOutputBoundary = saveOutputBoundary;
        this.weatherDAO = weatherDAO;
    }

    /**
     * Executes the save use case
     */
    @Override
    public void save(){
        try {
            List<Long> times = weatherDAO.getTimesForCity(FarmSingleton.getInstance().getFarm().getCity());
            FarmSingleton.getInstance().getFarm().setLogOutTime(times.get(0));
            saveDataAccessInterface.saveData(FarmSingleton.getInstance().getFarm());
            saveOutputBoundary.saved();
        } catch (main.java.use_case.load.DataAccessException | IOException | main.java.use_case.save.DataAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
