package main.java.use_case.load;

import java.io.IOException;

import main.java.entity.Farm;
import main.java.use_case.save.DataAccessException;

/**
 * Interface for saving the farm data to a file.
 */
public interface LoadDataAccessInterface {
    /**
     * Saves the Farm Data to a file.
     * @return Farm that is in storage
     * @throws main.java.use_case.load.DataAccessException .
     * @throws IOException .
     * @throws ClassNotFoundException .
     */
    Farm loadData() throws DataAccessException, IOException, ClassNotFoundException;

}
