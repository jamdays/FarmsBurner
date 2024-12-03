package main.java.entity;

/**
 * Crop Factory.
 */
public class CropFactory {
    /**
     * Create crop.
     * @param cropName .
     * @param time .
     * @param land .
     * @return null.
     */
    public AbstractCrop createCrop(String cropName, long time, Land land) {
        switch (cropName) {
            case "Wheat":
                return new Wheat(time, land);
            case "Corn":
                return new Corn(time, land);
            case "Rice":
                return new Rice(time, land);
            default:
                return new Snowberry(time, land);
        }
    }
}
