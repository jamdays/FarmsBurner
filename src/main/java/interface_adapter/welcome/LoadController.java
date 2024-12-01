package main.java.interface_adapter.welcome;

import main.java.use_case.load.LoadInputBoundary;

public class LoadController {
    private final LoadInputBoundary loadInputBoundary;

    public LoadController(LoadInputBoundary loadInputBoundary) {
        this.loadInputBoundary = loadInputBoundary;
    }

    public void load(){
        loadInputBoundary.load();
    }
}
