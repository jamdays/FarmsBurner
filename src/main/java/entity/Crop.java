package main.java.entity;

import java.io.Serializable;

public class Crop implements Serializable {

    // instance variables
    private int age;
    private boolean isAlive;
    private int price;
    private int waterlevel;
    private boolean readyToHarvest;

    // constructor
    public Crop(int age, boolean isAlive, int price) {
        this.age = age;
        this.isAlive = isAlive;
        this.price = price;
        this.waterlevel = 0;
        this.readyToHarvest = false;
    }

    public Crop(){
        this.age = 0;
        this.isAlive = true;
        this.price = 0;
        this.waterlevel = 0;
    }

    // getter and setter for age
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // getter and setter for alive
    public boolean getIsAlive() {
        return this.isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    // getter and setter for price
    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // getter and setter for waterlevel
    public int getWaterlevel() {return this.waterlevel;}

    // plant is watered if waterlevel > 0. This allows plants to start off not watered.
    public boolean isWatered() {return this.waterlevel > 0;}

    public void setWaterlevel(int level) {
        this.waterlevel = level;
    }

    public void setReadyToHarvest(boolean readyToHarvest) {
        this.readyToHarvest = readyToHarvest;
    }

    public boolean getReadyToHarvest() {
        return this.readyToHarvest;
    }

    public void water(){
        if (this.waterlevel == 0){
            age += 1;
        }
        this.waterlevel += 1;
        if (this.waterlevel == 5){
            isAlive = false;
        }
    }

    public void harvest(){
        // Crops are only ready to harvest if age > 5
        if (this.isAlive && this.age >= 5){
            this.readyToHarvest = true;
            this.isAlive = false;
        }
        else{
            this.readyToHarvest = false;
            System.out.println("Crop is not ready to harvest");
        }
    }
}
