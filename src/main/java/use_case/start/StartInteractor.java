package main.java.use_case.start;

/**
 * Start interactor.
 */
public class StartInteractor implements StartInputBoundary {
    private final StartOutputBoundary startOutputBoundary;

    public StartInteractor(StartOutputBoundary startOutputBoundary) {
        this.startOutputBoundary = startOutputBoundary;
    }

    @Override
    public void execute() {
        startOutputBoundary.execute();

    }
}
