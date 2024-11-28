package main.java.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Storage implements Serializable {

    // instance variables
    private int capacity;
    private ArrayList<Crop> crops;

    // constructor
    public Storage(int capacity) {
        this.capacity = capacity;
        this.crops = new ArrayList<Crop>();
    }

    // getter and setter for capacity
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // getter and setter for crates
    public ArrayList<Crop> getCrops() {
        return crops;
    }

    public void setCrops(ArrayList<Crop> crates) {
        this.crops = crates;
    }
}
