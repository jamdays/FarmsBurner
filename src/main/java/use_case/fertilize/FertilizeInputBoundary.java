package main.java.use_case.fertilize;

/**
 * Fertilize input boundary.
 */
public interface FertilizeInputBoundary {

    /**
     * Executes code for fertilize use case.
     * @param row row to be claimed
     * @param col column to be claimed
     */
    void execute(int row, int col);
}
