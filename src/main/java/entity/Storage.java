package main.java.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Storage class.
 */
public class Storage implements Serializable {

    // instance variables
    private int capacity;
    private ArrayList<AbstractCrop> crops;

    // constructor
    public Storage(int capacity) {
        this.capacity = capacity;
        this.crops = new ArrayList<AbstractCrop>();
    }

    /**
     * Get capacity.
     * @return capacity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Set capacity.
     * @param capacity .
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Get crops.
     * @return crops.
     */
    public ArrayList<AbstractCrop> getCrops() {
        return crops;
    }

    /**
     * Set crops.
     * @param crates .
     */
    public void setCrops(ArrayList<AbstractCrop> crates) {
        this.crops = crates;
    }
}
