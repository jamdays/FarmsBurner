package main.java.use_case.start;

import junit.framework.TestCase;

public class StartInteractorTest extends TestCase {

    public void testExecute() {

        StartOutputBoundary outputBoundary = new StartOutputBoundary() {
            @Override
            public void execute() {
            }
        };

        StartInteractor interactor = new StartInteractor(outputBoundary);
        // basically if there are no errors it should be ok
        interactor.execute();
    }
}