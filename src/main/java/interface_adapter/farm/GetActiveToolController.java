package main.java.interface_adapter.farm;

import main.java.use_case.getactivetool.GetActiveToolInputBoundary;

public class GetActiveToolController {

    private final GetActiveToolInputBoundary inputBoundary;

    public GetActiveToolController(GetActiveToolInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public String getActiveTool() {
        return inputBoundary.getActiveTool();
    }
}
