package main.java.use_case.water;

/**
 * Water output boundary.
 */
public interface WaterOutputBoundary {
    /**
     * Waters a plant.
     * @param row row
     * @param col column
     */
    void water(int row, int col);
}
