package main.java.interface_adapter.welcome;

import main.java.use_case.start.StartInputBoundary;

/**
 * Start controller.
 */
public class StartController {
    private final StartInputBoundary startInputBoundary;

    public StartController(StartInputBoundary startInputBoundary) {
        this.startInputBoundary = startInputBoundary;
    }

    /**
     * Start.
     */
    public void start() {
        startInputBoundary.execute();
    }

}
