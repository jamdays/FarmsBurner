package main.java.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Land implements Serializable {

    // instance variables
    private Crop crop;
    private boolean isWet;
    private boolean isSnowy;
    private boolean claimed;
    private boolean planted;
    private boolean fertilized;

    // constructor
    public Land(Crop crop) {
        this.crop = crop;
        this.isWet = false;
        this.isSnowy = false;
        this.planted = true;
        this.claimed = true;
        this.fertilized = true;
    }

    public Land() {
        this.isWet = false;
        this.isSnowy = false;
        this.planted = false;
        this.claimed = false;
        this.fertilized = false;
    }



    // getter and setter for crops
    public Crop getCrop() {
        return crop;
    }


    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    // getter and setter for isWet
    public boolean isWet() {
        return isWet;
    }

    public void setIsWet(boolean isWet) {
        this.isWet = isWet;
    }

    // getter and setter for isSnowy

    public boolean getIsSnowy() {
        return isSnowy;
    }

    public void setIsSnowy(boolean isSnowy) {
        this.isSnowy = isSnowy;
    }

    public boolean isPlanted() {
        return planted;
    }

    public void setPlanted(boolean planted) {
        this.planted = planted;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public void setClaimed(boolean claimed) {
        this.claimed = claimed;
    }

    public boolean isFertilized() {
        return fertilized;
    }

    public void setFertilized(boolean fertilized) {
        this.fertilized = fertilized;
    }

    public void water(){
        this.isWet = true;
        if (planted)
            crop.water();
    }

    public void plant(){
        if (claimed && !planted && !isSnowy){
            planted = true;
            this.crop = new Crop();
        }
    }

    public void harvest() {
        if (planted && crop.getIsAlive()) {
            crop.harvest();
            setCrop(null);
            planted = false;
        }
    }
    public void fertilize(){
        if (!planted && !isSnowy) {
            fertilized = true;
        }
    }
}