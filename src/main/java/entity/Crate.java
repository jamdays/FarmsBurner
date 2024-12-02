package main.java.entity;

import java.io.Serializable;

/**
 * Crate class.
 */
public class Crate implements Serializable {

    // instance variables
    private int daysLeft;
    private AbstractCrop[] crops;

    // constructor
    public Crate(int daysLeft, AbstractCrop[] crops) {
        this.daysLeft = daysLeft;
        this.crops = crops;
    }

    /**
     * Getter for daysLeft.
     * @return days left.
     */
    public int getDaysLeft() {
        return daysLeft;
    }

    /**
     * Set days left.
     * @param daysLeft .
     */
    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    /**
     * Get crops.
     * @return crops.
     */
    public AbstractCrop[] getCrops() {
        return crops;
    }

    /**
     * Set crops.
     * @param crops .
     */
    public void setCrops(AbstractCrop[] crops) {
        this.crops = crops;
    }

}
