package main.java.use_case.loadFarm;

public interface LoadFarmOutputBoundary {
    /**
     * Updates farm state
     */
    public void load(int[][] farmState);
}
