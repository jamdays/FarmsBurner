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
    private final Land farmLand;
    private int barnBucks;
    private int power;
    private final Sprinkler sprinkler;

    // Constructor
    public Farm(Land farmLand) {
        this.farmLand = farmLand;
        this.barnBucks = 0;
        this.power = 0;
        this.sprinkler = new Sprinkler();
    }

    public Land getFarmLand() {
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

    public void water(){
        for(int c = 0; c < Math.min(farmLand.getWidth(), sprinkler.getLevel() + 1); c++){
            for (int r = 0; r < Math.min(farmLand.getSize()/farmLand.getWidth(), sprinkler.getLevel() + 1); r++){
                farmLand.getCrops().get(c + r*Math.min(farmLand.getWidth(), sprinkler.getLevel() + 10)).water();
            }
        }
    }
}
