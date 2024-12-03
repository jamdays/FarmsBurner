package main.java.data_access;

import java.io.IOException;
import java.util.ArrayList;

import main.java.entity.AbstractCrop;
import main.java.entity.CropFactory;
import main.java.entity.Farm;
import main.java.entity.Land;
import main.java.entity.Storage;
import main.java.use_case.load.LoadDataAccessInterface;
import main.java.use_case.save.DataAccessException;
import main.java.use_case.save.SaveDataAccessInterface;

/**
 * In memory save file access.
 */
public class InMemorySaveFileAccess implements SaveDataAccessInterface, LoadDataAccessInterface {
    private Farm farm;
    /**
     * Save Data.
     * @param currFarm farm to be saved
     * @throws DataAccessException never because this is a test object, (add a case if you need to for testing)
     * @throws IOException never because this is a test object, (add a case if you need to for testing)
     * @throws main.java.use_case.load.DataAccessException never because this is a test object,
     *      (add a case if you need to for testing)
     *
     */

    @Override
    public void saveData(Farm currFarm)
            throws DataAccessException, IOException, main.java.use_case.load.DataAccessException {
        /*
        Making a deep copy of the Farm
        Otherwise it passes by reference and the farm will just be a farm
         */
        this.farm = currFarm;
        this.farm.setCity(currFarm.getCity());
        this.farm.setBarnBucks(currFarm.getBarnBucks());
        this.farm.setPower(currFarm.getPower());
        // NEVER REALLY USE THIS SO IT DOESN'T WORK LOW KEY
        this.farm.setWeather(currFarm.getDay(), currFarm.isRainy(), currFarm.isFog(),
                currFarm.isThunderstorm(), currFarm.isSnowy(),
                currFarm.isCloudy(), currFarm.isClear(), currFarm.getTemp(), currFarm.getWeather(), 0);
        // TODO set logout time
        // this.farm.setLogOutTime();
        this.farm.setSprinklerPurchased(currFarm.getSprinklerPurchased());
        this.farm.setSprinklerLevel(currFarm.getSprinklerLevel());
        this.farm.setHarvesterPurchased(currFarm.getHarvesterPurchased());
        this.farm.setHarvesterLevel(currFarm.getHarvesterLevel());
        this.farm.setTillerPurchased(currFarm.getTillerPurchased());
        this.farm.setTillerLevel(currFarm.getTillerLevel());
        this.farm.setFertilizerLevel(currFarm.getFertilizerLevel());
        this.farm.setFertilizerPurchased(currFarm.getFertilizerPurchased());

        Storage storage = new Storage(currFarm.getStorage().getCapacity());
        storage.setCrops(new ArrayList<>(currFarm.getStorage().getCrops()));
        this.farm.setStorage(storage);

        Land[][] farmLand = new Land[currFarm.getFarmLand().length][currFarm.getFarmLand()[0].length];
        CropFactory cropFactory = new CropFactory();
        for (int i = 0; i < currFarm.getFarmLand().length; i++) {
            for (int j = 0; j < currFarm.getFarmLand()[0].length; j++) {
                farmLand[i][j] = new Land();
                Land land = currFarm.getFarmLand()[i][j];
                farmLand[i][j].setIsSnowy(land.getIsSnowy());
                farmLand[i][j].setIsWet(land.isWet());
                farmLand[i][j].setClaimed(land.isClaimed());
                farmLand[i][j].setFertilized(land.isFertilized());
                if (land.getCrop() != null) {
                    AbstractCrop crop = cropFactory.createCrop(land.getCrop().getName(), land.getCrop().getTime(),
                            farmLand[i][j]);
                    crop.setAge(land.getCrop().getAge());
                    crop.setPrice(land.getCrop().getPrice());
                    crop.setIsAlive(land.getCrop().getIsAlive());
                    crop.setWaterLevel(land.getCrop().getWaterlevel());
                    farmLand[i][j].setCrop(crop);
                }

            }
        }

    }

    /**
     * Load Data.
     * @return farm
     * @throws DataAccessException never because this is a test object, (add a case if you need to for testing)
     * @throws IOException never because this is a test object, (add a case if you need to for testing)
     * @throws ClassNotFoundException never because this is a test object, (add a case if you need to for testing)
     */
    @Override
    public Farm loadData() throws DataAccessException, IOException, ClassNotFoundException {
        return farm;
    }

}
