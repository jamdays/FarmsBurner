package main.java.use_case.save;
import main.java.entity.Farm;
/**
 * interface for saving the farm data to a file
 */
public interface SaveDataAccessInterface {
    /**
     * Saves the Farm Data to a file
     * @param farm, the farm to be saved
     * @return if the save was successful
     */
    boolean saveData(Farm farm) throws DataAccessException;

}
