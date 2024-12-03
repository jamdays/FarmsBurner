package main.java.use_case.usetool;

/**
 * Use tool input boundary.
 */
public interface UseToolInputBoundary {

    /**
     * Executes code for use tool use case.
     * @param tool the tool being used
     * @param rStart starting row
     * @param cStart starting column
     * @return the level of the tool.
     */
     int useTool(String tool, int rStart, int cStart);
}
