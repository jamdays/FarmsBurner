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
    private final Sprinkler sprinkler;

    // Constructor
    public Farm(Land[][] farmLand) {
        this.farmLand = farmLand;
        this.barnBucks = 0;
        this.power = 0;
        this.sprinkler = new Sprinkler();
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

    public void harvest(int r, int c){
        this.farmLand[r][c].harvest();
    public void fertilize(int r, int c) {
        this.farmLand[r][c].fertilize();
    }
}
