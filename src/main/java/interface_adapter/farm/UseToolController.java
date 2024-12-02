package main.java.interface_adapter.farm;

import main.java.use_case.usetool.UseToolInputBoundary;

public class UseToolController {

    private final UseToolInputBoundary inputBoundary;

    public UseToolController(UseToolInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void useTool(String tool, int rStart, int cStart) {
        inputBoundary.useTool(tool, rStart, cStart);
    }
}
