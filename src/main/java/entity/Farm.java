package main.java.entity;
import main.java.use_case.plant.PlantingException;

import javax.swing.*;
import java.io.Serializable;

/*
int size
List<Crops> crops
boolean isDry
boolean isWet
boolean isSnowy
 */

public class Farm implements Serializable {

    //Instance Variables
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
    }

    public Farm(){
        this.farmLand = new Land[16][20];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 20; j++) {
                farmLand[i][j] = new Land();
            }
        }
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

    }

    public Land[][] getFarmLand() {
        return this.farmLand;
    }

    public int getBarnBucks() {
        return this.barnBucks;
    }

    public void setBarnBucks(int barnBucks) {
        this.barnBucks = barnBucks;
    }

    public Sprinkler getSprinkler() {
        return this.sprinkler;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean getSprinklerPurchased() {
        return this.sprinklerPurchased;
    }

    public void setSprinklerPurchased(boolean sprinklerPurchased) {
        this.sprinklerPurchased = sprinklerPurchased;
    }

    public int getSprinklerLevel() {
        return this.sprinklerLevel;
    }

    public void setSprinklerLevel(int sprinklerLevel) {
        this.sprinklerLevel = sprinklerLevel;
    }

    public boolean getHarvesterPurchased() {
        return this.harvesterPurchased;
    }

    public void setHarvesterPurchased(boolean harvesterPurchased) {
        this.harvesterPurchased = harvesterPurchased;
    }

    public int getHarvesterLevel() {
        return this.harvesterLevel;
    }

    public void setHarvesterLevel(int harvesterLevel) {
        this.harvesterLevel = harvesterLevel;
    }

    public boolean getTillerPurchased() {
        return this.tillerPurchased;
    }

    public void setTillerPurchased(boolean tillerPurchased) {
        this.tillerPurchased = tillerPurchased;
    }

    public int getTillerLevel() {
        return this.tillerLevel;
    }

    public void setTillerLevel(int tillerLevel) {
        this.tillerLevel = tillerLevel;
    }

    public boolean getFertilizerPurchased() {
        return this.fertilizerPurchased;
    }

    public void setFertilizerPurchased(boolean fertilizerPurchased) {
        this.fertilizerPurchased = fertilizerPurchased;
    }

    public int getFertilizerLevel() {
        return this.fertilizerLevel;
    }

    public void setFertilizerLevel(int fertilizerLevel) {
        this.fertilizerLevel = fertilizerLevel;
    }

    public String getActiveTool() {
        return this.activeTool;
    }

    public void setActiveTool(String activeTool) {
        this.activeTool = activeTool;
    }

    public String getActiveCrop() {
        return this.activeCrop;
    }

    public void setActiveCrop(String activeCrop) {
        this.activeCrop = activeCrop;
    }

    public void water(int r, int c){
        this.farmLand[r][c].water();
    }

    /**
     * Plants a crop and sets its planting time
     * @param r row to plant at
     * @param c column to plant at
     * @param time time of planting
     * @throws PlantingException if there is already a plant there
     */
    public void plant(int r, int c, Long time) throws PlantingException {
        this.farmLand[r][c].plant(time);
    }

    public void claim(int r, int c){
        this.farmLand[r][c].setClaimed(true);
    }

    public void harvest(int r, int c) {
        Land land = this.farmLand[r][c];
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
        } else if (!land.isFertilized() && land.isPlanted() && land.getCrop().getIsAlive()) {
            // add the crop into storage and store its regular price, given that there is space in storage
            if (this.getStorage().getCrops().size() < this.getStorage().getCapacity()) {
                land.getCrop().setPrice(3);
                this.getStorage().getCrops().add(land.getCrop());
            }
            else {
                System.out.println("not enough space in storage");
            }
        }
        this.farmLand[r][c].harvest();
    }

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
            JOptionPane.showMessageDialog(null, "You don't have enough crops in storage.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("you don't have enough crops in storage.");
        }
    }

    /**
     * Sets the weather for the farm
     * @param day 0 if night, 1 if day, 2 if dawn/dusk
     * @param rainy true if rainy, false if not
     * @param fog true if foggy, false if not
     * @param thunderstorm true if thunderstorm, false if not
     * @param snowy true if snowy, false if not
     * @param cloudy true if cloudy, false if not
     * @param clear, true if clear, false if not
     */
    public void setWeather(int day, boolean rainy, boolean fog, boolean thunderstorm, boolean snowy, boolean cloudy, boolean clear) {
        this.day = day;
        this.rainy = rainy;
        this.fog = fog;
        this.thunderstorm = thunderstorm;
        this.snowy = snowy;
        this.cloudy = cloudy;
        this.clear = clear;
    }

    public void fertilize(int r, int c) {
        this.farmLand[r][c].fertilize();
    }

    public String getCity(){
        return this.city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setSprinkler(Sprinkler sprinkler){
        this.sprinkler = sprinkler;
    }

    public void setStorage(Storage storage){
        this.storage = storage;
    }

    public Storage getStorage() {
        return this.storage;
    }

    public void setLogOutTime(Long time){
        this.time = time;
        for (Land[] lands : farmLand) {
            for (Land land : lands) {
                if (land.getCrop() != null)
                    land.getCrop().update(time);
            }
        }
    }

    public Long getTime(){
        return time;
    }

    public boolean isClear() {
        return clear;
    }

    public boolean isCloudy() {
        return cloudy;
    }

    public boolean isFog() {
        return fog;
    }

    public boolean isThunderstorm() {
        return thunderstorm;
    }

    public boolean isSnowy() {
        return snowy;
    }

    public boolean isRainy() {
        return rainy;
    }

    public int getDay(){
        return day;
    }
}
