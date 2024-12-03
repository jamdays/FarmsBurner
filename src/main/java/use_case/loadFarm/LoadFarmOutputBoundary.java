package main.java.use_case.loadFarm;

/**
 * Load farm output boundary.
 */
public interface LoadFarmOutputBoundary {
    /**
     * Updates farm state.
     * @param farmState .
     */
    void load(int[][] farmState);
}
