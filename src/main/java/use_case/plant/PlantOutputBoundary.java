package main.java.use_case.plant;

public interface PlantOutputBoundary {
    /**
     * adds the crop
     * @param r, row to be placed at
     * @param c, column to be placed at
     * @param time, time of placement
     */
    void addCrop(int r, int c, long time);
}
