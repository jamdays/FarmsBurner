package main.java.use_case.selecttool;

public class SelectToolInteractor implements SelectToolInputBoundary{

    private final SelectToolOutputBoundary outputBoundary;

    public SelectToolInteractor(SelectToolOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void selectTool(String tool) {
        if (tool.equalsIgnoreCase("sprinkler")) {
            outputBoundary.selectTool("sprinkler");
        }

        if (tool.equalsIgnoreCase("harvester")) {
            outputBoundary.selectTool("harvester");
        }
    }
}
