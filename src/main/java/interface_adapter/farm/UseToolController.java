package main.java.interface_adapter.farm;

import main.java.use_case.usetool.UseToolInputBoundary;

/**
 * Use tool controller.
 */
public class UseToolController {

    private final UseToolInputBoundary inputBoundary;

    public UseToolController(UseToolInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Use tool.
     * @param tool .
     * @param rStart .
     * @param cStart .
     * @return level of tool.
     */
    public int useTool(String tool, int rStart, int cStart) {
        return inputBoundary.useTool(tool, rStart, cStart);
    }
}
