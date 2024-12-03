package main.java.use_case.save;

import java.io.IOException;

import main.java.entity.Farm;

/**
 * Interface for saving the farm data to a file.
 */
public interface SaveDataAccessInterface {
    /**
     * Saves the Farm Data to a file.
     * @param farm the farm to be saved
     * @throws DataAccessException .
     * @throws IOException .
     * @throws main.java.use_case.load.DataAccessException .
     */
    void saveData(Farm farm) throws DataAccessException, IOException, main.java.use_case.load.DataAccessException;

}
