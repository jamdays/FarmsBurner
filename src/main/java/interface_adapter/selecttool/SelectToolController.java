package interface_adapter.selecttool;

import use_case.selecttool.SelectToolInputBoundary;

public class SelectToolController {
    private final SelectToolInputBoundary inputBoundary;

    public SelectToolController(SelectToolInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void selectTool(String tool) {
        inputBoundary.selectTool(tool);
    }
}
