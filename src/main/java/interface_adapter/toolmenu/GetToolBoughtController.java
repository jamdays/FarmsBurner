package main.java.interface_adapter.toolmenu;

import java.util.List;

import main.java.use_case.gettoolbought.GetToolBoughtInputBoundary;

/**
 * Get tool bought controller.
 */
public class GetToolBoughtController {

    private final GetToolBoughtInputBoundary inputBoundary;

    public GetToolBoughtController(GetToolBoughtInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Get tool bought.
     * @param tool .
     * @return .
     */
    public List<Object> getToolBought(String tool) {
        return inputBoundary.getToolBought(tool);
    }
}
