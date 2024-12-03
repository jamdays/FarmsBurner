package main.java.use_case.harvest;

/**
 * Harvest Output boundary.
 */
public interface HarvestOutputBoundary {
    /**
     * Harvests the crop.
     * @param row row to be harvested
     * @param col column to be harvested
     */
    void harvestCrop(int row, int col);
}
