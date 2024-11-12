package main.java.use_case.fertilize;

public interface FertilizeOutputBoundary {
    /**
            * fertilizes the land at (c, r)
     * @param r, row to be placed at
     * @param c, column to be placed at
     */
    void fertilize(int r, int c);
}
