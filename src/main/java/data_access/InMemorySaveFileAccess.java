package main.java.data_access;

import java.io.IOException;
import java.util.ArrayList;

import main.java.entity.Crop;
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
     * @param farm farm to be saved
     * @throws DataAccessException never because this is a test object, (add a case if you need to for testing)
     * @throws IOException never because this is a test object, (add a case if you need to for testing)
     * @throws main.java.use_case.load.DataAccessException never because this is a test object,
     *      (add a case if you need to for testing)
     *
     */

    @Override
    public void saveData(Farm farm)
            throws DataAccessException, IOException, main.java.use_case.load.DataAccessException {
        /*
        Making a deep copy of the Farm
        Otherwise it passes by reference and the farm will just be a farm
         */
        this.farm = farm;
        this.farm.setCity(farm.getCity());
        this.farm.setBarnBucks(farm.getBarnBucks());
        this.farm.setPower(farm.getPower());
        this.farm.setSprinkler(farm.getSprinkler());
        this.farm.setWeather(farm.getDay(), farm.isRainy(), farm.isFog(), farm.isThunderstorm(), farm.isSnowy(),
                farm.isCloudy(), farm.isClear());
        // TODO set logout time
        // this.farm.setLogOutTime();
        this.farm.setSprinklerPurchased(farm.getSprinklerPurchased());
        this.farm.setSprinklerLevel(farm.getSprinklerLevel());
        this.farm.setHarvesterPurchased(farm.getHarvesterPurchased());
        this.farm.setHarvesterLevel(farm.getHarvesterLevel());
        this.farm.setTillerPurchased(farm.getTillerPurchased());
        this.farm.setTillerLevel(farm.getTillerLevel());
        this.farm.setFertilizerLevel(farm.getFertilizerLevel());
        this.farm.setFertilizerPurchased(farm.getFertilizerPurchased());

        Storage storage = new Storage(farm.getStorage().getCapacity());
        storage.setCrops(new ArrayList<>(farm.getStorage().getCrops()));
        this.farm.setStorage(storage);

        Land[][] farmLand = new Land[farm.getFarmLand().length][farm.getFarmLand()[0].length];
        CropFactory cropFactory = new CropFactory();
        for (int i = 0; i < farm.getFarmLand().length; i++) {
            for (int j = 0; j < farm.getFarmLand()[0].length; j++) {
                farmLand[i][j] = new Land();
                Land land = farm.getFarmLand()[i][j];
                farmLand[i][j].setIsSnowy(land.getIsSnowy());
                farmLand[i][j].setIsWet(land.isWet());
                farmLand[i][j].setClaimed(land.isClaimed());
                farmLand[i][j].setFertilized(land.isFertilized());
                if (land.getCrop() != null) {
                    Crop crop = cropFactory.createCrop(land.getCrop().getName(), land.getCrop().getTime(),
                            farmLand[i][j]);
                    crop.setAge(land.getCrop().getAge());
                    crop.setPrice(land.getCrop().getPrice());
                    crop.setIsAlive(land.getCrop().getIsAlive());
                    crop.setWaterlevel(land.getCrop().getWaterlevel());
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
