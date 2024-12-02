package main.java.interface_adapter.toolmenu;

import main.java.use_case.gettoolbought.GetToolBoughtInputBoundary;

import java.util.List;

public class GetToolBoughtController {

    private final GetToolBoughtInputBoundary inputBoundary;

    public GetToolBoughtController(GetToolBoughtInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public List<Object> getToolBought(String tool) {
        return inputBoundary.getToolBought(tool);
    }
}
