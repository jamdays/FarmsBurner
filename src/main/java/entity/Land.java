package main.java.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Land implements Serializable {

    // instance variables
    private Crop crop;
    private boolean isDry;
    private boolean isWet;
    private boolean isSnowy;
    private boolean claimed;
    private boolean planted;

    // constructor
    public Land(Crop crop) {
        this.crop = crop;
        this.isDry = true;
        this.isWet = false;
        this.isSnowy = false;
        this.planted = true;
        this.claimed = true;
    }

    public Land() {
        this.isDry = true;
        this.isWet = false;
        this.isSnowy = false;
        this.planted = false;
        this.claimed = false;
    }



    // getter and setter for crops
    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    // getter and setter for isDry
    public boolean getIsDry() {
        return isDry;
    }

    public void setIsDry(boolean isDry) {
        this.isDry = isDry;
    }

    // getter and setter for isWet
    public boolean getIsWet() {
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

    public void water(){
        this.isWet = true;
        crop.water();
    }

    public void plant(){
        if (claimed && !planted && !isSnowy){
            planted = true;
            setCrop(new Crop());
        }
    }
}