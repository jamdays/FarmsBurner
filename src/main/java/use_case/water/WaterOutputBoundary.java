package main.java.use_case.water;

public interface WaterOutputBoundary {
    /**
     * waters a plant
     * @param r row
     * @param c column
     */
    void water(int r, int c);
}
