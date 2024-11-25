package main.java.entity;
import main.java.use_case.fertilize.FertilizeException;
import main.java.use_case.harvest.HarvestException;
import main.java.use_case.plant.PlantingException;

import java.io.Serializable;

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

    // water should only succeed if land is claimed, not snowy, and has a plant,
    public void water(){
        if (!claimed){
            System.out.println("Land is not claimed");
        } else if (isSnowy){
            System.out.println("Land is snowy");
        } else if (!planted) {
            System.out.println("No crop is planted");
        } else{
            crop.water();
            isWet = true;
        }
    }

    // plant should only work on claimed land and if it is not snowy and if there isn't already a plant
    public void plant() throws PlantingException {
        if (!claimed){
            throw new PlantingException("Land is not claimed");
        } else if (isSnowy){
            throw new PlantingException("Land is snowy");
        } else if (planted){
            throw new PlantingException("There is already a plant here");
        } else{
            planted = true;
            this.crop = new Crop();
        }
//        if (claimed && !planted && !isSnowy){
//            planted = true;
//            setCrop(new Crop());
//        }
    }

    public void harvest() {
        if (!planted) {
            System.out.println("No crop is planted");
        } else if (!crop.getIsAlive()) {
            setCrop(null);
            planted = false;
            throw new HarvestException("Crop is dead");
        } else if (crop.getAge() < 5) {
            throw new HarvestException("Crop is not ready to harvest");
        } else {
            crop.harvest();
            setCrop(null);
            planted = false;
        }
    }

    public void fertilize(){
        if (isSnowy){
            throw new FertilizeException("Land is snowy");
        } else if (fertilized) {
            throw new FertilizeException("Land is already fertilized");
        } else {
            fertilized = true;
        }
    }
}