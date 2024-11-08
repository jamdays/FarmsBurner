package main.java.entity;
import java.util.List;

public class Land {

    // instance variables
    private int size;
    private List<Crop> crops;
    private boolean isDry;
    private boolean isWet;
    private boolean isSnowy;

    // constructor
    public Land(int size, List<Crop> crops) {
        this.size = size;
        this.crops = crops;
        this.isDry = true;
        this.isWet = false;
        this.isSnowy = false;
    }

    // getter and setter for size
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // getter and setter for crops
    public List<Crop> getCrops() {
        return crops;
    }

    public void setCrops(List<Crop> crops) {
        this.crops = crops;
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
}