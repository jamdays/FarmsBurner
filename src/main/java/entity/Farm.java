package main.java.entity;
import main.java.use_case.plant.PlantingException;

import java.io.Serializable;
import java.util.List;

/*
int size
List<Crops> crops
boolean isDry
boolean isWet
boolean isSnowy
 */

import java.util.ArrayList;
import java.util.List;

public class Farm implements Serializable {

    //Instance Variables
    private final Land[][] farmLand;
    private int barnBucks;
    private int power;
    private Sprinkler sprinkler;
    private String city;
    private Storage storage;

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
    }

    public Farm(){
        this.farmLand = new Land[8][10];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                farmLand[i][j] = new Land();
                if ((i == 3 || i == 4) && (j == 4 || j == 5)){
                    farmLand[i][j].setClaimed(true);
                }
            }
        }
        this.barnBucks = 0;
        this.power = 0;
        this.sprinkler = new Sprinkler();
        this.city = "Toronto";
        this.storage = new Storage(100);

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

    public void water(int r, int c){
        this.farmLand[r][c].water();
    }

    public void plant(int r, int c) throws PlantingException {
        this.farmLand[r][c].plant();
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
                this.getStorage().getCrops().remove(i);
            }
        }
        // otherwise, don't sell them
        else {
            // TODO make a popup for the user that tells them that they cannot sell crops they don't have
            System.out.println("you don't have enough crops in storage.");
        }
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
}
