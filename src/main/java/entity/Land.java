package main.java.entity;

import java.io.Serializable;

import main.java.use_case.fertilize.FertilizeException;
import main.java.use_case.harvest.HarvestException;
import main.java.use_case.plant.PlantingException;

/**
 * Land class.
 */
public class Land implements Serializable {

    // instance variables
    private AbstractCrop crop;
    private boolean isWet;
    private boolean isSnowy;
    private boolean claimed;
    private boolean planted;
    private boolean fertilized;

    // constructor
    public Land(AbstractCrop crop) {
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

    /**
     * Get crop.
     * @return crop.
     */
    public AbstractCrop getCrop() {
        return crop;
    }

    /**
     * Set crop.
     * @param crop .
     */
    public void setCrop(AbstractCrop crop) {
        this.crop = crop;
    }

    /**
     * Check if wet.
     * @return isWet.
     */
    public boolean isWet() {
        return isWet;
    }

    /**
     * Set isWet.
     * @param isWet .
     */
    public void setIsWet(boolean isWet) {
        this.isWet = isWet;
    }

    /**
     * Check if snowy.
     * @return isSnowy.
     */
    public boolean getIsSnowy() {
        return isSnowy;
    }

    /**
     * Set isSnowy.
     * @param isSnowy .
     */
    public void setIsSnowy(boolean isSnowy) {
        this.isSnowy = isSnowy;
    }

    /**
     * Check if planted.
     * @return isPlanted.
     */
    public boolean isPlanted() {
        return planted;
    }

    /**
     * Check is claimed.
     * @return isClaimed.
     */
    public boolean isClaimed() {
        return claimed;
    }

    /**
     * Set claimed.
     * @param claimed .
     */
    public void setClaimed(boolean claimed) {
        this.claimed = claimed;
    }

    /**
     * Check if fertilized.
     * @return fertilized.
     */
    public boolean isFertilized() {
        return fertilized;
    }

    /**
     * Set fertilized.
     * @param fertilized .
     */
    public void setFertilized(boolean fertilized) {
        this.fertilized = fertilized;
    }

    /**
     * Water should only succeed if land is claimed, not snowy, and has a plant.
     */
    public void water() {
        if (!claimed) {
            System.out.println("Land is not claimed");
        }
        else if (isSnowy) {
            System.out.println("Land is snowy");
        }
        else if (!planted) {
            System.out.println("No crop is planted");
        }
        else {  
            crop.water();
            isWet = true;
        }
    }

    /**
     * Plant should only work on claimed land and if it is not snowy and if there isn't already a plant.
     * @param time .
     * @param crop .
     * @throws PlantingException .
     */
    public void plant(Long time, String crop) throws PlantingException {
        if (!claimed) {
            throw new PlantingException("Land is not claimed");
        }
        else if (isSnowy) {
            throw new PlantingException("Land is snowy");
        }
        else if (planted) {
            throw new PlantingException("There is already a plant here");
        }
        else {
            CropFactory cropFactory = new CropFactory();
            planted = true;
            this.crop = cropFactory.createCrop(crop, time, this);
        }
    }

    /**
     * Harvest.
     * @throws HarvestException .
     */
    public void harvest() {
        if (!planted) {
            System.out.println("No crop is planted");
        }
        else if (!crop.getIsAlive()) {
            setCrop(null);
            planted = false;
            fertilized = false;
            throw new HarvestException("Crop is dead");
        }
        else if (crop.getAge() < 5) {
            throw new HarvestException("Crop is not ready to harvest");
        }
        else {
            crop.harvest();
            setCrop(null);
            planted = false;
            fertilized = false;
        }
    }

    /**
     * Fertilize.
     * @throws FertilizeException .
     */
    public void fertilize() {
        if (isSnowy) {
            throw new FertilizeException("Land is snowy");
        }
        else if (fertilized) {
            throw new FertilizeException("Land is already fertilized");
        }
        else {
            fertilized = true;
            // If the crop is not null set it to fertilized
            if (crop != null) {
                crop.fertilize();
            }
        }
    }
}
