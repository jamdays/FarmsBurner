package main.java.use_case.usetool;

public interface UseToolInputBoundary {

    /**
     * executes code for use tool use case
     * @param tool, the tool being used
     * @param rStart, starting row
     * @param cStart, starting column
     */
    void useTool(String tool, int rStart, int cStart);
}
