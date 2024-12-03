package main.java.interface_adapter.welcome;

import main.java.interface_adapter.ViewModel;

/**
 * Welcome view model.
 */
public class WelcomeViewModel extends ViewModel {

    public WelcomeViewModel() {
        super("welcome");
        setState(new WelcomeState());
    }
}
