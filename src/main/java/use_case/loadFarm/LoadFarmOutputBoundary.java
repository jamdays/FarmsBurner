package main.java.use_case.loadFarm;

/**
 * Load farm output boundary.
 */
public interface LoadFarmOutputBoundary {
    /**
     * Updates farm state.
     * @param farmState .
     * @param cropTimes .
     * @param cropAge .
     * @param prices .
     * @param barnBucks .
     * @param power .
     * @param time .
     */
    void load(int[][] farmState, long[][] cropTimes, int[][] cropAge, int[][] prices,
              int barnBucks, int power, long time);
}
