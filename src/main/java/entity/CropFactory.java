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
            case "Snowberry":
                return new Snowberry(time, land);
            case "Wheat":
                return new Wheat(time, land);
            case "Corn":
                return new Corn(time, land);
            case "Rice":
                return new Rice(time, land);
        }
        return null;
    }
}
