package main.java.interface_adapter.selecttool;

import main.java.use_case.selecttool.SelectToolInputBoundary;

/**
 * Select tool controller.
 */
public class SelectToolController {
    private final SelectToolInputBoundary inputBoundary;

    public SelectToolController(SelectToolInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Select tool.
     * @param tool .
     */
    public void selectTool(String tool) {
        inputBoundary.selectTool(tool);
    }
}
