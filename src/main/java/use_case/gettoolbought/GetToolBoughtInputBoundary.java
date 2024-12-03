package main.java.use_case.gettoolbought;

import java.util.List;

/**
 * Get tool bought input boundary.
 */
public interface GetToolBoughtInputBoundary {

    /**
     * Executes code for gettoolbought use case.
     * @param tool .
     * @return Tool bought.
     */
    List<Object> getToolBought(String tool);
}
