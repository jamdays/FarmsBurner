package main.java.use_case.getactivetool;

import main.java.entity.FarmSingleton;

public class GetActiveToolInteractor implements GetActiveToolInputBoundary {

    GetActiveToolOutputBoundary outputBoundary;

    public GetActiveToolInteractor(GetActiveToolOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    public String getActiveTool() {
        String activeTool = FarmSingleton.getInstance().getFarm().getActiveTool();
        outputBoundary.activeTool(activeTool);
        return activeTool;
    }
}
