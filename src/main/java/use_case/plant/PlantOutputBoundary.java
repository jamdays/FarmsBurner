package main.java.use_case.plant;

/**
 * Plant output boundary.
 */
public interface PlantOutputBoundary {
    /**
     * Adds the crop.
     * @param row row to be placed at
     * @param col column to be placed at
     * @param time time of placement
     */
    void addCrop(int row, int col, long time);
}
