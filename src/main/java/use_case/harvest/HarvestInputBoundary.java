package main.java.use_case.harvest;

/**
 * Harvest input boundary.
 */
public interface HarvestInputBoundary {
    /**
     * Executes code for harvestCrop use case.
     * @param row row to be harvested
     * @param col column to be harvested
     */
    void execute(int row, int col);
}
