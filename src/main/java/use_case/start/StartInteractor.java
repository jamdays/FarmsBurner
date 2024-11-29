package main.java.use_case.start;

public class StartInteractor implements StartInputBoundary {
    private final StartOutputBoundary startOutputBoundary;

    StartInteractor(StartOutputBoundary startOutputBoundary) {
        this.startOutputBoundary = startOutputBoundary;
    }
    @Override
    public void execute() {
        startOutputBoundary.execute();

    }
}