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
@SuppressWarnings("checkstyle:MagicNumber")
public class Farm implements Serializable {

    // Instance Variables
    private final Land[][] farmLand;
    private int barnBucks;
    private int power;
    private long powerRefresh;
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
    private int temp;
    private String weather;

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
    private final int[] prices = {0, 300, 900, 2700, 8100};

    private String activeTool;
    private String activeCrop;

    // Constructor
    public Farm(Land[][] farmLand) {
        this.farmLand = farmLand;
        this.barnBucks = 0;
        this.power = 0;
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
     * Refresh power.
     * @param currTime .
     */
    public void refreshPower(long currTime) {
        if (currTime - powerRefresh > 10800) {
            powerRefresh = currTime;
            if ("Clear".equalsIgnoreCase(weather)) {
                power += 100;
            }
            else if ("Clouds".equalsIgnoreCase(weather)) {
                power += 50;
            }
            else if ("Rain".equalsIgnoreCase(weather)) {
                power += 50;
            }
            else if ("Drizzle".equalsIgnoreCase(weather)) {
                power += 50;
            }
            else if ("Thunderstorm".equalsIgnoreCase(weather)) {
                power += 250;
            }
            else if ("Snow".equalsIgnoreCase(weather)) {
                power += 50;
            }
            else {
                power += 25;
            }
        }
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
        this.barnBucks -= prices[sprinklerLevel - 1];
        if (this.barnBucks < 0) {
            this.barnBucks += prices[sprinklerLevel - 1];
            return;
        }
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
        this.barnBucks -= prices[sprinklerLevel];
        if (this.barnBucks < 0) {
            this.barnBucks += prices[sprinklerLevel];
            return;
        }
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
        this.barnBucks -= prices[harvesterLevel - 1];
        if (this.barnBucks < 0) {
            this.barnBucks += prices[harvesterLevel - 1];
            return;
        }
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
        this.barnBucks -= prices[harvesterLevel];
        if (this.barnBucks < 0) {
            this.barnBucks += prices[harvesterLevel];
            return;
        }
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
        this.barnBucks -= prices[tillerLevel - 1];
        if (this.barnBucks < 0) {
            this.barnBucks += prices[tillerLevel - 1];
            return;
        }
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
        this.barnBucks -= prices[tillerLevel];
        if (this.barnBucks < 0) {
            this.barnBucks += prices[tillerLevel];
            return;
        }
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
        this.barnBucks -= prices[fertilizerLevel - 1];
        if (this.barnBucks < 0) {
            this.barnBucks += prices[fertilizerLevel - 1];
            return;
        }
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
        this.barnBucks -= prices[fertilizerLevel];
        if (this.barnBucks < 0) {
            this.barnBucks += prices[fertilizerLevel];
            return;
        }
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
        if (this.farmLand[row][col].isClaimed()) {
            if (!"Thunderstorm".equalsIgnoreCase(weather)) {
                power -= 5;
                if (power < 0) {
                    power += 5;
                    return;
                }
            }
        }
        this.farmLand[row][col].water();
    }

    /**
     * Plants a crop and sets its planting time.
     * @param row row to plant at
     * @param col column to plant at
     * @param currTime time of planting
     * @throws PlantingException if there is already a plant there
     */
    public void plant(int row, int col, Long currTime) throws PlantingException {
        if (this.farmLand[row][col].isClaimed() && !this.farmLand[row][col].isPlanted()) {
            if (!"Thunderstorm".equalsIgnoreCase(weather)) {
                power -= 5;
                if (power < 0) {
                    power += 5;
                    return;
                }
            }
        }
        this.farmLand[row][col].plant(currTime, activeCrop);

    }

    /**
     * Claim.
     * @param row .
     * @param col .
     */
    public void claim(int row, int col) {
        if (!this.farmLand[row][col].isClaimed()) {
            if (!"Thunderstorm".equalsIgnoreCase(weather)) {
                power -= 5;
                if (power < 0) {
                    power += 5;
                    return;
                }
            }
        }
        this.farmLand[row][col].setClaimed(true);
    }

    /**
     * Harvest.
     * @param row .
     * @param col .
     */
    public void harvest(int row, int col) {
        Land land = this.farmLand[row][col];
        if (land.isPlanted() && land.getCrop().getIsAlive()) {
            if (!"Thunderstorm".equalsIgnoreCase(weather)) {
                power -= 5;
                if (power < 0) {
                    power += 5;
                    return;
                }
            }
        }
        if (land.isFertilized() && land.isPlanted() && land.getCrop().getIsAlive()) {
            // add the crop into storage and store its high price, given that there is space in storage
            if (this.getStorage().getCrops().size() < this.getStorage().getCapacity()) {
                this.getStorage().getCrops().add(land.getCrop());
                // remove fertilizer from land
                this.getFarmLand()[row][col].setFertilized(false);
                // make it so that land is no longer planted
                this.getFarmLand()[row][col].setPlanted(false);
                this.getFarmLand()[row][col].setIsWet(false);
            }
            else {
                System.out.println("not enough space in storage");
            }
        }
        else if (!land.isFertilized() && land.isPlanted() && land.getCrop().getIsAlive()) {
            // add the crop into storage and store its regular price, given that there is space in storage
            if (this.getStorage().getCrops().size() < this.getStorage().getCapacity()) {
                this.getStorage().getCrops().add(land.getCrop());
                // make it so that land is no longer planted
                this.getFarmLand()[row][col].setPlanted(false);
                this.getFarmLand()[row][col].setIsWet(false);
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
     * @param currDay 0 if night, 1 if day, 2 if dawn/dusk
     * @param isRainy true if rainy, false if not
     * @param isFog true if foggy, false if not
     * @param isThunderstorm true if thunderstorm, false if not
     * @param isSnowy true if snowy, false if not
     * @param isCloudy true if cloudy, false if not
     * @param isClear true if clear, false if not
     * @param currTemp current temp
     * @param currWeather current weather
     * @param currTime current time
     */
    public void setWeather(int currDay, boolean isRainy, boolean isFog, boolean isThunderstorm, boolean isSnowy,
                           boolean isCloudy, boolean isClear, int currTemp, String currWeather, long currTime) {
        this.day = currDay;
        this.rainy = isRainy;
        this.fog = isFog;
        this.thunderstorm = isThunderstorm;
        this.snowy = isSnowy;
        this.cloudy = isCloudy;
        this.clear = isClear;
        this.temp = currTemp;
        this.weather = currWeather;
        refreshPower(currTime);
    }

    /**
     * Fertilize.
     * @param row .
     * @param col .
     */
    public void fertilize(int row, int col) {
        if (!this.farmLand[row][col].isFertilized() && !this.farmLand[row][col].isClaimed()) {
            if (!"Thunderstorm".equalsIgnoreCase(weather)) {
                power -= 5;
                if (power < 0) {
                    power += 5;
                    return;
                }
            }
        }
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
     * @param currTime .
     */
    public void setLogOutTime(long currTime) {
        this.time = currTime;
        for (Land[] lands : farmLand) {
            for (Land land : lands) {
                if (land.getCrop() != null) {
                    land.getCrop().setLand(land);
                    land.getCrop().setWeather(this.weather);
                    land.getCrop().setTemp(this.temp);
                    land.getCrop().update(currTime);
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
        barnBucks -= prices[planterLevel-1];
        if (barnBucks < 0) {
            barnBucks += prices[planterLevel-1];
            return;
        }
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
        barnBucks -= prices[planterLevel];
        if (barnBucks < 0) {
            barnBucks += prices[planterLevel];
            return;
        }
        this.planterLevel = planterLevel;
    }

    /**
     * Get temp.
     * @return temp.
     */
    public int getTemp() {
        return temp;
    }

    /**
     * Set temp.
     * @param temp .
     */
    public void setTemp(int temp) {
        this.temp = temp;
    }

    /**
     * Get weather.
     * @return weather.
     */
    public String getWeather() {
        return weather;
    }

    /**
     * Weather.
     * @param currWeather .
     */
    public void weather(String currWeather) {
        this.weather = currWeather;
    }

    /**
     * Get power refresh.
     * @return power refresh.
     */
    public long getPowerRefresh() {
        return powerRefresh;
    }
}
