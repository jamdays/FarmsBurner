package main.java.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Land implements Serializable {

    // instance variables
    private int size;
    private List<Crop> crops;
    private boolean isDry;
    private boolean isWet;
    private boolean isSnowy;
    private int width;

    // constructor
    public Land(int size, List<Crop> crops) {
        this.size = size;
        this.crops = crops;
        this.isDry = true;
        this.isWet = false;
        this.isSnowy = false;
    }

    public Land(int width) {
        this.width = width;
        this.size = width*width;
        this.crops = new ArrayList<Crop>();
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

    /**
     * adds all crops in crops to the crops if there is space
     * @param crops the crops to be added
     */
    public void addCrops(List<Crop> crops){
        if (this.size <=  crops.size() + this.crops.size())
            this.crops.addAll(crops);
    }

    /**
     * adds this crop to the crops if there is space
     * @param crop the crop to be added
     */
    public void addCrop(Crop crop){
        if (this.size <=  1 + this.crops.size())
            this.crops.add(crop);
    }

    public int getWidth() {return this.width;}
}