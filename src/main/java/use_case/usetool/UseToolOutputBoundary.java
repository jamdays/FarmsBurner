package main.java.use_case.usetool;

public interface UseToolOutputBoundary {

    /**
     * uses tool with the top left corner being at row rStart, column cStart
     * @param tool, the tool being used
     * @param rStart, starting row
     * @param cStart, starting column
     * @param amount, the side length of the square area that the tool will be used on
     */
    void useTool(String tool, int rStart, int cStart, int amount, long time);
}
