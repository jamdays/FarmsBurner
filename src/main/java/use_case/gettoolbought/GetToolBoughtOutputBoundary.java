package main.java.use_case.gettoolbought;

/**
 * Get tool bought output boundary.
 */
public interface GetToolBoughtOutputBoundary {

    /**
     * Executes code for gettoolbought use case.
     * @param bought if the tool has been bought or not
     * @param tool .
     * @param level .
     */
    void toolBought(String tool, boolean bought, int level);
}
