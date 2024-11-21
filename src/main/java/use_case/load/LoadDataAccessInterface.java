package main.java.use_case.load;
import main.java.entity.Farm;
import main.java.use_case.save.DataAccessException;

import java.io.IOException;

/**
 * interface for saving the farm data to a file
 */
public interface LoadDataAccessInterface {
    /**
     * Saves the Farm Data to a file
     * @return Farm that is in storage
     */
    Farm loadData() throws DataAccessException, IOException, ClassNotFoundException;

}
