package main.java.entity;

import java.io.Serializable;

import javax.swing.JOptionPane;

import main.java.use_case.plant.PlantingException;

/*
int size
List<Crops> crops
boolean isDry
boolean isWet
boolean isSnowy
 */
/**
 * Farm class.
 */
public class Farm implements Serializable {

    // Instance Variables
    private final Land[][] farmLand;
    private int barnBucks;
    private int power;
    private Sprinkler sprinkler;
    private String city;
    private Storage storage;
    private int day;
    private boolean rainy;
    private boolean fog;
    private boolean thunderstorm;
    private boolean snowy;
    private boolean cloudy;
    private boolean clear;
    private long time;

    // activeTool and activeCrop instance variables

    private boolean sprinklerPurchased;
    private int sprinklerLevel;
    private boolean harvesterPurchased;
    private int harvesterLevel;
    private boolean tillerPurchased;
    private int tillerLevel;
    private boolean fertilizerPurchased;
    private int fertilizerLevel;
    private boolean planterPurchased;
    private int planterLevel;

    private String activeTool;
    private String activeCrop;

    // Constructor
    public Farm(Land[][] farmLand) {
        this.farmLand = farmLand;
        this.barnBucks = 0;
        this.power = 0;
        // TODO: implement sprinkler so that you don't start with a sprinkler
        this.sprinkler = new Sprinkler();
        // Default city for testing
        this.city = "Toronto";
        // give farm some storage (can store up to 100 crops)
        this.storage = new Storage(100);
        this.sprinklerPurchased = false;
        this.sprinklerLevel = 2;
        this.harvesterPurchased = false;
        this.harvesterLevel = 2;
        this.tillerPurchased = false;
        this.tillerLevel = 2;
        this.fertilizerPurchased = false;
        this.fertilizerLevel = 2;
        this.planterPurchased = false;
        this.planterLevel = 2;
        this.activeCrop = "snowberry";
        this.activeTool = "none";
    }

    public Farm() {
        this.farmLand = new Land[16][20];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 20; j++) {
                farmLand[i][j] = new Land();
            }
        }
        this.activeCrop = "snowberry";
        this.barnBucks = 0;
        this.power = 0;
        this.sprinkler = new Sprinkler();
        this.city = "Toronto";
        this.storage = new Storage(100);
        this.sprinklerPurchased = false;
        this.sprinklerLevel = 2;
        this.harvesterPurchased = false;
        this.harvesterLevel = 2;
        this.tillerPurchased = false;
        this.tillerLevel = 2;
        this.fertilizerPurchased = false;
        this.fertilizerLevel = 2;
        this.planterPurchased = false;
        this.planterLevel = 2;
        this.activeTool = "none";

    }

    /**
     * Get farmland.
     * @return farmland.
     */
    public Land[][] getFarmLand() {
        return this.farmLand;
    }

    /**
     * Get BarnBucks.
     * @return BarnBucks.
     */
    public int getBarnBucks() {
        return this.barnBucks;
    }

    /**
     * Set BarnBucks.
     * @param barnBucks .
     */
    public void setBarnBucks(int barnBucks) {
        this.barnBucks = barnBucks;
    }

    /**
     * Get sprinkler.
     * @return sprinkler.
     */
    public Sprinkler getSprinkler() {
        return this.sprinkler;
    }

    /**
     * Get power.
     * @return power.
     */
    public int getPower() {
        return this.power;
    }

    /**
     * Set power.
     * @param power .
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Get sprinkler purchased.
     * @return sprinkler purchased.
     */
    public boolean getSprinklerPurchased() {
        return this.sprinklerPurchased;
    }

    /**
     * Set sprinkler purchased.
     * @param sprinklerPurchased .
     */
    public void setSprinklerPurchased(boolean sprinklerPurchased) {
        this.sprinklerPurchased = sprinklerPurchased;
    }

    /**
     * Get sprinkler level.
     * @return sprinkler level.
     */
    public int getSprinklerLevel() {
        return this.sprinklerLevel;
    }

    /**
     * Set sprinkler level.
     * @param sprinklerLevel .
     */
    public void setSprinklerLevel(int sprinklerLevel) {
        this.sprinklerLevel = sprinklerLevel;
    }

    /**
     * Get harvester purchased.
     * @return harvester purchased.
     */
    public boolean getHarvesterPurchased() {
        return this.harvesterPurchased;
    }

    /**
     * Set Harvester purchased.
     * @param harvesterPurchased .
     */
    public void setHarvesterPurchased(boolean harvesterPurchased) {
        this.harvesterPurchased = harvesterPurchased;
    }

    /**
     * Get harvester level.
     * @return harvester level.
     */
    public int getHarvesterLevel() {
        return this.harvesterLevel;
    }

    /**
     * Set harvester level.
     * @param harvesterLevel .
     */
    public void setHarvesterLevel(int harvesterLevel) {
        this.harvesterLevel = harvesterLevel;
    }

    /**
     * Get tiller purchased.
     * @return .
     */
    public boolean getTillerPurchased() {
        return this.tillerPurchased;
    }

    /**
     * Set tiller purchased.
     * @param tillerPurchased .
     */
    public void setTillerPurchased(boolean tillerPurchased) {
        this.tillerPurchased = tillerPurchased;
    }

    /**
     * Get tiller level.
     * @return tiller level.
     */
    public int getTillerLevel() {
        return this.tillerLevel;
    }

    /**
     * Set tiller level.
     * @param tillerLevel .
     */
    public void setTillerLevel(int tillerLevel) {
        this.tillerLevel = tillerLevel;
    }

    /**
     * Get fertilizer purchased.
     * @return fertilizer purchased.
     */
    public boolean getFertilizerPurchased() {
        return this.fertilizerPurchased;
    }

    /**
     * Set fertilizer purchased.
     * @param fertilizerPurchased .
     */
    public void setFertilizerPurchased(boolean fertilizerPurchased) {
        this.fertilizerPurchased = fertilizerPurchased;
    }

    /**
     * Get fertilizer level.
     * @return fertilizer level.
     */
    public int getFertilizerLevel() {
        return this.fertilizerLevel;
    }

    /**
     * Set fertilizer level.
     * @param fertilizerLevel .
     */
    public void setFertilizerLevel(int fertilizerLevel) {
        this.fertilizerLevel = fertilizerLevel;
    }

    /**
     * Get active tool.
     * @return active tool.
     */
    public String getActiveTool() {
        return this.activeTool;
    }

    /**
     * Set active tool.
     * @param activeTool .
     */
    public void setActiveTool(String activeTool) {
        this.activeTool = activeTool;
    }

    /**
     * Get active crop.
     * @return active crop.
     */
    public String getActiveCrop() {
        return this.activeCrop;
    }

    /**
     * Set active crop.
     * @param activeCrop .
     */
    public void setActiveCrop(String activeCrop) {
        this.activeCrop = activeCrop;
    }

    /**
     * Water.
     * @param row .
     * @param col .
     */
    public void water(int row, int col) {
        this.farmLand[row][col].water();
    }

    /**
     * Plants a crop and sets its planting time.
     * @param row row to plant at
     * @param col column to plant at
     * @param time time of planting
     * @throws PlantingException if there is already a plant there
     */
    public void plant(int row, int col, Long time) throws PlantingException {
        this.farmLand[row][col].plant(time, activeCrop);

    }

    /**
     * Claim.
     * @param row .
     * @param col .
     */
    public void claim(int row, int col) {
        this.farmLand[row][col].setClaimed(true);
    }

    /**
     * Harvest.
     * @param row .
     * @param col .
     */
    public void harvest(int row, int col) {
        Land land = this.farmLand[row][col];
        // TODO add so that the age impacts if you make money or not
        if (land.isFertilized() && land.isPlanted() && land.getCrop().getIsAlive()) {
            // add the crop into storage and store its high price, given that there is space in storage
            if (this.getStorage().getCrops().size() < this.getStorage().getCapacity()) {
                land.getCrop().setPrice(5);
                this.getStorage().getCrops().add(land.getCrop());
            }
            else {
                System.out.println("not enough space in storage");
            }
        }
        else if (!land.isFertilized() && land.isPlanted() && land.getCrop().getIsAlive()) {
            // add the crop into storage and store its regular price, given that there is space in storage
            if (this.getStorage().getCrops().size() < this.getStorage().getCapacity()) {
                land.getCrop().setPrice(3);
                this.getStorage().getCrops().add(land.getCrop());
            }
            else {
                System.out.println("not enough space in storage");
            }
        }
        this.farmLand[row][col].harvest();
    }

    /**
     * Sell.
     * @param quantity .
     */
    public void sell(int quantity) {
        // if you have enough crops in storage, sell them
        if (quantity <= this.getStorage().getCrops().size()) {
            for (int i = 0; i < quantity; i++) {
                // get the value of the current crop and add the value to barnBucks total
                // note: I'm treating storage as a queue (first crop in --> first crop out)
                int value = this.getStorage().getCrops().get(0).getPrice();
                this.barnBucks += value;
                // remove the crop from storage, now that it has been sold
                this.getStorage().getCrops().remove(0);
            }
        }
        // otherwise, don't sell them
        else {
            JOptionPane.showMessageDialog(null, "You don't have enough crops in storage.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("you don't have enough crops in storage.");
        }
    }

    /**
     * Sets the weather for the farm.
     * @param day 0 if night, 1 if day, 2 if dawn/dusk
     * @param rainy true if rainy, false if not
     * @param fog true if foggy, false if not
     * @param thunderstorm true if thunderstorm, false if not
     * @param snowy true if snowy, false if not
     * @param cloudy true if cloudy, false if not
     */
    public void setWeather(int day, boolean rainy, boolean fog, boolean thunderstorm, boolean snowy,
                           boolean cloudy, boolean clear) {
        this.day = day;
        this.rainy = rainy;
        this.fog = fog;
        this.thunderstorm = thunderstorm;
        this.snowy = snowy;
        this.cloudy = cloudy;
        this.clear = clear;
    }

    /**
     * Fertilize.
     * @param row .
     * @param col .
     */
    public void fertilize(int row, int col) {
        this.farmLand[row][col].fertilize();
    }

    /**
     * Get city.
     * @return city.
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Set city.
     * @param city .
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Set sprinkler .
     * @param sprinkler .
     */
    public void setSprinkler(Sprinkler sprinkler) {
        this.sprinkler = sprinkler;
    }

    /**
     * Set storage .
     * @param storage .
     */
    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * Get storage.
     * @return storage.
     */
    public Storage getStorage() {
        return this.storage;
    }

    /**
     * Set logout time.
     * @param time .
     */
    public void setLogOutTime(long time) {
        this.time = time;
        for (Land[] lands : farmLand) {
            for (Land land : lands) {
                if (land.getCrop() != null) {
                    land.getCrop().update(time);
                }
            }
        }
    }

    /**
     * Get time.
     * @return time.
     */
    public Long getTime() {
        return time;
    }

    /**
     * Check if clear.
     * @return clear.
     */
    public boolean isClear() {
        return clear;
    }

    /**
     * Check if cloudy.
     * @return cloudy.
     */
    public boolean isCloudy() {
        return cloudy;
    }

    /**
     * Check fog.
     * @return fog.
     */
    public boolean isFog() {
        return fog;
    }

    /**
     * Check thunderstorm.
     * @return thunderstorm.
     */
    public boolean isThunderstorm() {
        return thunderstorm;
    }

    /**
     * Check snowy.
     * @return snowy.
     */
    public boolean isSnowy() {
        return snowy;
    }

    /**
     * Check rainy.
     * @return rainy.
     */
    public boolean isRainy() {
        return rainy;
    }

    /**
     * Get day.
     * @return day.
     */
    public int getDay() {
        return day;
    }

    /**
     * Get planter purchased.
     * @return planter purchased.
     */
    public boolean getPlanterPurchased() {
        return this.planterPurchased;
    }

    /**
     * Set planter purchased.
     * @param planterPurchased .
     */
    public void setPlanterPurchased(boolean planterPurchased) {
        this.planterPurchased = planterPurchased;
    }

    /**
     * Get planter level.
     * @return planter level.
     */
    public int getPlanterLevel() {
        return this.planterLevel;
    }

    /**
     * Set planter level.
     * @param planterLevel .
     */
    public void setPlanterLevel(int planterLevel) {
        this.planterLevel = planterLevel;
    }

}
