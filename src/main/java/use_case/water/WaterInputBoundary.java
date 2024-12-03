package main.java.use_case.water;

/**
 * Water input boundary.
 */
public interface WaterInputBoundary {
    /**
     * Executes code for water use case.
     * @param row row to be placed at
     * @param col column to be placed at
     */
    void execute(int row, int col);
}
