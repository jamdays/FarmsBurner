package main.java.interface_adapter.land;

import main.java.interface_adapter.ViewModel;

public class LandViewModel extends ViewModel {
    public LandViewModel() {
        super("land");
        setState(new LandState());
    }
}
