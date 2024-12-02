package main.java.data_access;

import main.java.entity.Farm;
import main.java.use_case.load.LoadDataAccessInterface;
import main.java.use_case.save.DataAccessException;
import main.java.use_case.save.SaveDataAccessInterface;

import java.io.IOException;

public class InMemorySaveFileAccess implements SaveDataAccessInterface, LoadDataAccessInterface {
    /**
     * @param farm
     * @throws DataAccessException
     * @throws IOException
     * @throws main.java.use_case.load.DataAccessException
     */
    @Override
    public void saveData(Farm farm) throws DataAccessException, IOException, main.java.use_case.load.DataAccessException {

    }

    /**
     * @return 
     * @throws DataAccessException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public Farm loadData() throws DataAccessException, IOException, ClassNotFoundException {
        return null;
    }

}
