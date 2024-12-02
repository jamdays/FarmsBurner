package main.java.entity;

public class CropFactory {
    public Crop createCrop(String cropName, long time, Land land) {
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
