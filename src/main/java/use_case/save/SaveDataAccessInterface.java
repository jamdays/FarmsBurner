package main.java.use_case.save;
import main.java.entity.Farm;

import java.io.IOException;

/**
 * interface for saving the farm data to a file
 */
public interface SaveDataAccessInterface {
    /**
     * Saves the Farm Data to a file
     * @param farm, the farm to be saved
     */
    void saveData(Farm farm) throws DataAccessException, IOException, main.java.use_case.load.DataAccessException;

}
