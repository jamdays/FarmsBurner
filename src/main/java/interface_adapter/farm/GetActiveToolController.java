package main.java.interface_adapter.farm;

import main.java.use_case.getactivetool.GetActiveToolInputBoundary;

/**
 * Get active tool controller.
 */
public class GetActiveToolController {

    private final GetActiveToolInputBoundary inputBoundary;

    public GetActiveToolController(GetActiveToolInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Get active tool.
     * @return active tool.
     */
    public String getActiveTool() {
        return inputBoundary.getActiveTool();
    }
}
