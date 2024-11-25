package main.java.entity;
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

    // Constructor
    public Farm(Land[][] farmLand) {
        this.farmLand = farmLand;
        this.barnBucks = 0;
        this.power = 0;
        // TODO: implement sprinkler so that you don't start with a sprinkler
        this.sprinkler = new Sprinkler();
        //Default city for testing
        this.city = "Toronto";
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

    public void plant(int r, int c){
        this.farmLand[r][c].plant();
    }

    public void claim(int r, int c){
        this.farmLand[r][c].setClaimed(true);
    }

    public void harvest(int r, int c) {
        Land land  = this.farmLand[r][c];
        // TODO add so that the age impacts if you make money or not
        if (land.isFertilized() && land.isPlanted() && land.getCrop().getIsAlive()) {
            this.barnBucks += 5;
        } else if (!land.isFertilized() && land.isPlanted() && land.getCrop().getIsAlive()) {
            this.barnBucks += 3;
        }
        this.farmLand[r][c].harvest();
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
}
