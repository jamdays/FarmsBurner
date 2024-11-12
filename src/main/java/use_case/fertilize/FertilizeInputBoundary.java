package main.java.use_case.fertilize;

public interface FertilizeInputBoundary {

    /**
     * executes code for fertilize use case
     * @param r, row to be claimed
     * @param c, column to be claimed
     */
    void execute(int r, int c);
}
