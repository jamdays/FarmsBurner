package main.java.interface_adapter.welcome;

import main.java.use_case.load.LoadInputBoundary;

/**
 * Load controller.
 */
public class LoadController {
    private final LoadInputBoundary loadInputBoundary;

    public LoadController(LoadInputBoundary loadInputBoundary) {
        this.loadInputBoundary = loadInputBoundary;
    }

    /**
     * Load.
     */
    public void load() {
        loadInputBoundary.load();
    }
}
