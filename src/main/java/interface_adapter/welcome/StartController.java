package main.java.interface_adapter.welcome;

import main.java.use_case.setcity.SetCityInputBoundary;
import main.java.use_case.start.StartInputBoundary;

public class StartController {
    private final StartInputBoundary startInputBoundary;

    public StartController(StartInputBoundary startInputBoundary) {
        this.startInputBoundary = startInputBoundary;
    }

    public void start(){
        startInputBoundary.execute();
    }

}
