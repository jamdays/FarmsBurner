package main.java.use_case.loadFarm;

public interface LoadFarmOutputBoundary {
    /**
     * Updates farm state
     */
    public void load(int[][] farmState, long[][] cropTimes, int[][] cropAge, int[][] prices, int barnBucks, int power);
}
