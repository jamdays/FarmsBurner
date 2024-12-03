package main.java.use_case.getactivetool;

import main.java.entity.FarmSingleton;

/**
 * Get active tool interactor.
 */
public class GetActiveToolInteractor implements GetActiveToolInputBoundary {

    private final GetActiveToolOutputBoundary outputBoundary;

    public GetActiveToolInteractor(GetActiveToolOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    /**
     * Get active tool.
     * @return active tool.
     */
    public String getActiveTool() {
        String activeTool = FarmSingleton.getInstance().getFarm().getActiveTool();
        outputBoundary.activeTool(activeTool);
        return activeTool;
    }
}
