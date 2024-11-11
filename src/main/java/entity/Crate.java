package main.java.entity;

import java.io.Serializable;

public class Crate implements Serializable {

    // instance variables
    private int daysLeft;
    private Crop[] crops;

    // constructor
    public Crate(int daysLeft, Crop[] crops) {
        this.daysLeft = daysLeft;
        this.crops = crops;
    }

    // getter and setter for daysLeft
    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    // getter and setter for crops
    public Crop[] getCrops() {
        return crops;
    }

    public void setCrops(Crop[] crops) {
        this.crops = crops;
    }

}
