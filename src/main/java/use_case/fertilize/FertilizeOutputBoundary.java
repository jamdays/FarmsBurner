package main.java.use_case.fertilize;

/**
 * Fertilize output boundary.
 */
public interface FertilizeOutputBoundary {
    /**
     * Fertilizes the land at (c, r).
     * @param row row to be placed at
     * @param col column to be placed at
     */
    void fertilize(int row, int col);
}
