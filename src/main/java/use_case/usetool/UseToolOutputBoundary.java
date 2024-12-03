package main.java.use_case.usetool;

/**
 * Use tool output boundary.
 */
public interface UseToolOutputBoundary {

    /**
     * Uses tool with the top left corner being at row rStart, column cStart.
     * @param tool the tool being used
     * @param rStart starting row
     * @param cStart starting column
     * @param amount the side length of the square area that the tool will be used on
     * @param time time.
     */
    void useTool(String tool, int rStart, int cStart, int amount, long time);
}
